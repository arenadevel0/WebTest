package resear.logger.prac;

import java.awt.Desktop;
import java.io.File;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

public class MultipleHandler {

	private static final String LOGGED_LOCATION = "D:\\Logs\\";
	private static final String XMLLOG = "MultipleHandlers.xml";
	private static Logger logger = Logger.getLogger("MultipleHandlers");
	
	public static void main(String[] args) throws Exception {
		FileHandler logFile = new FileHandler(LOGGED_LOCATION+XMLLOG, true);
	    logger.addHandler(logFile);
	    logger.addHandler(new ConsoleHandler());
	    logger.warning("Output to multiple handlers");
	
	    if(System.getProperty("os.name").contains("Win")){
			if(Desktop.isDesktopSupported()){
				Desktop.getDesktop().open(new File(LOGGED_LOCATION+XMLLOG));
			}
		}
	}
}