package resear.logger.prac;

import java.util.logging.Filter;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class SimpleFilter {

  private static Logger logger = Logger.getLogger("SimpleFilter");

  static class Duck {
  };

  static class Wombat {
  };

  static void sendLogMessages() {
    logger.log(Level.WARNING, "A duck in the house!", new Duck());
    logger.log(Level.WARNING, "A Wombat at large!", new Wombat());
  }

  public static void main(String[] args) {
    sendLogMessages();
    logger.setFilter(new Filter() {
      public boolean isLoggable(LogRecord record) {
        Object[] params = record.getParameters();
        System.out.println(record);
        if (params == null)
          return true; // No parameters
        if (record.getParameters()[0] instanceof Duck)
          return true; // Only log Duck. To log only Duck.
        return false;
      }
    });
    logger.info("After setting filter..");
    sendLogMessages();

  }
}