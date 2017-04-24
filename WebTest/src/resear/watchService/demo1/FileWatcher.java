package resear.watchService.demo1;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.FileSystems;
import java.nio.file.WatchService;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchKey;
import java.nio.file.WatchEvent;
import java.io.IOException;

import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.SimpleFormatter;
import java.util.logging.Logger;


class FileWatcher {
	public static void main(String[] args) throws IOException {
		doLog();
		new FileWatcher().doWatchOverFile();
	}

	public static void doLog() throws IOException{
		Logger logger = Logger.getLogger(FileWatcher.class.getName());
		String c="LoggingRough";
		String m = "public static void doLog()";
		logger.entering(c,m);
		System.out.println("Statement 1");

		
		FileHandler fh = new FileHandler("D:\\Logs\\Log.txt");
		SimpleFormatter sf = new SimpleFormatter();
		fh.setFormatter(sf);
		logger.addHandler(fh);
		logger.info("sf reference: "+sf);
		// logger.addHandler(new FileHandler("Log.txt").setFormatter(new SimpleFormatter()));
		logger.log(Level.INFO, "Statement 1 executed fine");
		logger.severe("Severity Log");
		logger.info("info Log");

		for(int i=0; i<Byte.MAX_VALUE; i++){
			logger.info("logged: "+i);
		}
		logger.exiting(c,m);
	}

	public void doWatchOverFile(){
		final Path path = Paths.get("D:\\Logs");
		System.out.println("file to be watched: "+path);
		try (final WatchService watchService = FileSystems.getDefault().newWatchService()) {
		    final WatchKey watchKey = path.register(watchService, StandardWatchEventKinds.ENTRY_MODIFY);
		    while (true) {
		        final WatchKey wk = watchService.take();
		        for (WatchEvent<?> event : wk.pollEvents()) {
		            //we only register "ENTRY_MODIFY" so the context is always a Path.
		            final Path changed = (Path) event.context();
		            System.out.println(changed);
		            if (changed.endsWith("Log.txt")) {
		                System.out.println("My file has changed");
		            }
		        }
		        // reset the key
		        boolean valid = wk.reset();
		        if (!valid) {
		            System.out.println("Key has been unregisterede");
		        }
		    }
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}
}