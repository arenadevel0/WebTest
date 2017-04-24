package resear.thread.checkFileChangeWithThread;

import java.util.logging.*;

public class LoggingEnteringExiting {
	private static final String className = LoggingEnteringExiting.class.getName();
	private static final Logger logger = Logger.getLogger(className);
	public static void main(String[] args) {
		logger.setLevel(Level.ALL);
		new LoggingEnteringExiting().doWork();
	}

	public void doWork(){
		logger.entering(className, "doWork");
		logger.finer("doWork is working");
		logger.exiting(className, "doWork");
	}
}