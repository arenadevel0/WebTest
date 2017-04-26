package resear.logger.prac;

import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_DELETE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class SizedLogThreadedIncomplete {
	
	public static final String LOGGED_LOCATION = "D:\\Logs\\";
	public static final String SIZEDLOGFILE = "sizedLog.log";
	public static final int FILE_THRESHOLD = 1024*10;
	private static final int TOTAL_FILE = 1;
	private static final boolean SHALL_APPENDED=true;
	public static final Path existingFilePath = Paths.get(LOGGED_LOCATION, SIZEDLOGFILE);
	public static final Path backupFilePath = Paths.get(LOGGED_LOCATION, "sizedLogBackup.log");
	
	static Logger logger = Logger.getLogger(SizedLogThreadedIncomplete.class.getName());
	static FileHandler fh;
	
	public static void main(String[] args) throws InterruptedException {
		/*only in case when the new backup log file need to be created before deleting the backup*/ 
		Thread fileSizeCheckerThread = new Thread(new FileSizeChecker());
		fileSizeCheckerThread.start();
		fileSizeCheckerThread.join(500);
		/*only in case when the new backup log file need to be created before deleting the backup*/
		
		SizedLogThreadedIncomplete sl = new SizedLogThreadedIncomplete();
		sl.configureLogger();
		sl.doWork();
	}
	
	public void configureLogger(){
//		synchronized (Logger.class) {
			SimpleFormatter sf = new SimpleFormatter();
			
			for(Handler handler: logger.getHandlers()){
				System.out.println(handler);
				if(handler instanceof ConsoleHandler){
					logger.removeHandler(handler);
				}
			}
			
			try{
				fh = new FileHandler(LOGGED_LOCATION+SIZEDLOGFILE, FILE_THRESHOLD, TOTAL_FILE, SHALL_APPENDED);
				fh.setFormatter(sf);
				logger.addHandler(fh);
				logger.setLevel(Level.FINER);
			}catch(IOException e){
				System.out.println(e);
			}
//		}
	}
	public void doWork(){
//		synchronized (Logger.class) {
			/*logger.entering(this.getClass().getName(), "doWork()");
			logger.info("LOGGING_START");*/
			for(int i=0; i<Byte.MAX_VALUE; i++){
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				logger.info("logger: "+i);
			}
			/*logger.info("LOGGING_END");
			logger.exiting(this.getClass().getName(), "doWork()");*/
//		}
	}
	public static void shiftDataBeforeDeleting(){
//		synchronized (Logger.class) {
			try {
				Files.copy(existingFilePath, backupFilePath, StandardCopyOption.REPLACE_EXISTING);
			} catch (IOException e) {
				System.err.println("File is copied due to the folowing error: ");
				e.printStackTrace();
			}
		}
//	}
}

class FileSizeChecker implements Runnable{
	public void doCheckSizeCopyIfNeeded(){
//		synchronized (Logger.class) {
			WatchService watcher;
			try {
				watcher = FileSystems.getDefault().newWatchService();
			    Path dir = Paths.get(SizedLogThreadedIncomplete.LOGGED_LOCATION);
			    dir.register(watcher, ENTRY_CREATE, ENTRY_DELETE, ENTRY_MODIFY);
			    System.out.println("Watch Service registered for dir: " + dir.getFileName());
	            
	            while (true) {
	                WatchKey key;
	                try {
	                    key = watcher.take();
	                } catch (InterruptedException ex) {
	                	return;
	                }
	                for (WatchEvent<?> event : key.pollEvents()) {
	                    WatchEvent.Kind<?> kind = event.kind();
	                    @SuppressWarnings("unchecked")
	                    WatchEvent<Path> ev = (WatchEvent<Path>) event;
	                    Path fileName = ev.context();
	                    System.out.println(kind.name() + ": " + fileName);
	                    if (Files.exists(SizedLogThreadedIncomplete.existingFilePath, LinkOption.NOFOLLOW_LINKS) && kind == ENTRY_MODIFY &&
	                            fileName.toString().equals(SizedLogThreadedIncomplete.SIZEDLOGFILE)) {
//	                        System.out.println("My source file has changed!!!");
	                        if(Files.size(SizedLogThreadedIncomplete.existingFilePath)>(1024*8)){
	                        	try {
	                        		SizedLogThreadedIncomplete.logger.wait();
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
	                        	SizedLogThreadedIncomplete.shiftDataBeforeDeleting();
	                        	try {
	                        		SizedLogThreadedIncomplete.logger.wait();
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
	                        }
	                    }
	                }
	                boolean valid = key.reset();
	                if (!valid) {
	                    break;
	                }
	            }
			} catch (IOException e) {
				e.printStackTrace();
			}
//		}
	}

	@Override
	public void run() {
		doCheckSizeCopyIfNeeded();
	}
}