package resear.logger;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class MyLogger {
	
	private static FileHandler fileTxt;
	private static SimpleFormatter formatterTxt;

	private static FileHandler fileHTML;
	private static Formatter formatterHTML;

	public static void setup() throws IOException {

            Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

            //to stop logging on console
            /*Logger rootLogger = Logger.getLogger("");
            Handler[] handlers = rootLogger.getHandlers();
            if (handlers[0] instanceof ConsoleHandler) {
                    rootLogger.removeHandler(handlers[0]);
            }*/

            logger.setLevel(Level.SEVERE);
            fileTxt = new FileHandler("Logging.txt");
            fileHTML = new FileHandler("Logging.html");

            formatterTxt = new SimpleFormatter();
            fileTxt.setFormatter(formatterTxt);
            logger.addHandler(fileTxt);

            formatterHTML = new MyHtmlFormatter();
            fileHTML.setFormatter(formatterHTML);
            logger.addHandler(fileHTML);
    }
}
