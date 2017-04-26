package resear.logger.prac.timed;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class SizedLog {
	
	public static final String LOGGED_LOCATION = "D:\\Logs\\";
	public static final String SIZEDLOGFILE = "sizedLog.log";
	private static final int TOTAL_FILE = 1;
	private static final boolean SHALL_APPENDED=true;
	public static final String SIZEDLOGLOCATION = LOGGED_LOCATION+SIZEDLOGFILE;
	private Logger logger;
	private static FileHandler fh;
	
	private static SizedLog sizedLog;
	
	private SizedLog(){
		
	}
	
	public static SizedLog getSizedLogObj(){
		if(sizedLog==null){
			synchronized (SizedLog.class) {
				if(sizedLog==null){
					sizedLog = new SizedLog();
				}
			}
		}
		return sizedLog;
	}
	
	public static int getFileThreshold() {
		return getLogPropObj().getFileSize();
	}
	
	public static LogProp getLogPropObj() {
		return LogProp.getLogPropObj();
	}
	
	public synchronized Logger configureLogger(){
		if(logger==null){
			if(logger==null){
				logger = Logger.getLogger(SizedLog.class.getName());
				SimpleFormatter sf = new SimpleFormatter();
				try{
					fh = new FileHandler(LOGGED_LOCATION+SIZEDLOGFILE, getFileThreshold(), TOTAL_FILE, SHALL_APPENDED);
					fh.setFormatter(sf);
					logger.addHandler(fh);
					logger.setLevel(Level.FINER);
				}catch(IOException e){
					System.out.println(e);
				}
			}
		}
		return logger;
	}
}
