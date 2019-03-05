package resear.logger;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UseLogger {
	
	private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public void doSomeThingAndLog() {
    	//Now only logs with higher or equal level than WARNING will appear 
            LOGGER.setLevel(Level.WARNING);
            LOGGER.severe("Severe Log");
            LOGGER.warning("Warning Log");
            LOGGER.info("Info Log");
            LOGGER.finest("Finest log");

        //Now only logs with higher or equal level than INFO will appear 
            LOGGER.setLevel(Level.INFO);
            LOGGER.severe("Severe Log");
            LOGGER.warning("Warning Log");
            LOGGER.info("Info Log");
            LOGGER.finest("Finest log");
            
            for(int i=0; i<Byte.MAX_VALUE; i++){
            	LOGGER.log(Level.INFO, i+": log generated");
//            	System.out.println(i+": log generated");
            }
    }

    public static void main(String[] args) {
            UseLogger tester = new UseLogger();
            try {
                    MyLogger.setup();
            } catch (IOException e) {
                    e.printStackTrace();
                    throw new RuntimeException("Problems with creating the log files");
            }
            tester.doSomeThingAndLog();
    }
}
