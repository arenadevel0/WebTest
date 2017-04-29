package resear.logger.prac;

import java.util.logging.*;
import java.io.IOException;

public class LoggingRoug {

	static Logger logger = Logger.getLogger(LoggingRoug.class.getName());
	static String c="LoggingRough";
	public static void main(String[] args) throws IOException{
		doLog();
	}
	public static void doLog() throws SecurityException, IOException{
		String m = "public static void main(String[] args)";
		logger.entering(c,m);
		System.out.println("Statement 1");

		
		FileHandler fh = new FileHandler("D:\\Logs\\Log.txt", 500000, 5);
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
}