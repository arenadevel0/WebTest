package resear.logger.prac;

import java.util.logging.*;
import java.io.*;

class SizedLog {
	private static final String LOGGED_LOCATION = "D:\\Logs\\";
	private static final String SIZEDLOG = "sizedLog.log";
	static Logger logger = Logger.getLogger(SizedLog.class.getName());
	static FileHandler fh;
	
	public static void main(String[] args) {
		SizedLog sl = new SizedLog();
		sl.configureLogger();
		sl.doWork();
	}
	
	public void configureLogger(){
		SimpleFormatter sf = new SimpleFormatter();
		try{
			fh = new FileHandler(LOGGED_LOCATION+SIZEDLOG, 1024*10, 2, true);
			fh.setFormatter(sf);
			logger.addHandler(fh);
			logger.setLevel(Level.FINER);
		}catch(IOException e){
			System.out.println(e);
		}
	}
	public void doWork(){
		// logger.entering(this.getClass().getName(), "doWork()");
		// logger.info("LOGGING_START");
		for(int i=0; i<Byte.MAX_VALUE; i++){
			try {
				Thread.sleep(150);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			logger.info("logger: "+i);
		}
		// logger.info("LOGGING_END");
		// logger.exiting(this.getClass().getName(), "doWork()");
	}
}