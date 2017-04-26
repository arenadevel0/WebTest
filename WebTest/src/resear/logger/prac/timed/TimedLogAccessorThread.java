package resear.logger.prac.timed;

import java.nio.file.Path;
import java.nio.file.Paths;

//this thread is used to view the logs at random intervals.

public class TimedLogAccessorThread implements Runnable {
	
	@Override
	public void run() {
		Path sizedLogLocation = Paths.get(SizedLog.SIZEDLOGLOCATION);
		Path lastRequiredLogs = Paths.get(SizedLog.LOGGED_LOCATION, "last logs.txt");
	}
}
