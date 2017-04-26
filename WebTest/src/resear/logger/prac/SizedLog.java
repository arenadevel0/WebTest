package resear.logger.prac;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class SizedLog {
	
	public static final String LOGGED_LOCATION = "D:\\Logs\\";
	public static final String SIZEDLOGFILE = "sizedLog.log";
	public static final int FILE_THRESHOLD = 1024*10;
	private static final int TOTAL_FILE = 1;
	private static final boolean SHALL_APPENDED=true;
	
	
	static Logger logger = Logger.getLogger(SizedLog.class.getName());
	static FileHandler fh;
	
	public static void main(String[] args) {	
		SizedLog sl = new SizedLog();
		sl.configureLogger();
		sl.doWork();
	}
	
	public void configureLogger(){
			SimpleFormatter sf = new SimpleFormatter();
			/*for(Handler handler: logger.getHandlers()){
				System.out.println(handler);
				if(handler instanceof ConsoleHandler){
					logger.removeHandler(handler);
				}
			}*/
			try{
				fh = new FileHandler(LOGGED_LOCATION+SIZEDLOGFILE, FILE_THRESHOLD, TOTAL_FILE, SHALL_APPENDED);
				fh.setFormatter(sf);
				logger.addHandler(fh);
				logger.setLevel(Level.FINER);
			}catch(IOException e){
				System.out.println(e);
			}
	}
	public void doWork(){
			/*logger.entering(this.getClass().getName(), "doWork()");
			logger.info("LOGGING_START");*/
			for(int i=0; i<Short.MAX_VALUE; i++){
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				logger.info("logger: "+i);
			}
			/*logger.info("LOGGING_END");
			logger.exiting(this.getClass().getName(), "doWork()");*/
		}
}