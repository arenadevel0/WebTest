package resear.logger;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UseLogger {
	
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public void doSomeThingAndLog() {
            LOGGER.setLevel(Level.SEVERE);
            LOGGER.severe("Info Log");
            LOGGER.warning("Info Log");
            LOGGER.info("Info Log");
            LOGGER.finest("Really not important");

            LOGGER.setLevel(Level.INFO);
            LOGGER.severe("Info Log");
            LOGGER.warning("Info Log");
            LOGGER.info("Info Log");
            LOGGER.finest("Really not important");
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
