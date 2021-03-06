package resear.logger.prac;

import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

public class MultipleHandler2 {

  private static Logger logger = Logger.getLogger("MultipleHandlers2");

  public static void main(String[] args) throws Exception {
    FileHandler logFile = new FileHandler("MultipleHandlers2.xml");
    logger.addHandler(logFile);
    logger.addHandler(new ConsoleHandler());
    logger.setUseParentHandlers(false);
    logger.warning("Output to multiple handlers");

  }
}