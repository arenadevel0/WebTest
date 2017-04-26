package resear.logger.prac.timed;

import java.nio.file.Paths;
import java.util.Scanner;
import java.util.logging.Logger;

import resear.utils.SleepingCurrentThread;
import resear.utils.Viewer;

public class AccessLog {
	
	private volatile static AccessLog accessLogObj;
	private Logger logger;
	private LogProp logProp;
	private Scanner sc = new Scanner(System.in);
	/*private boolean LOGLAST5MINS = true;*/
	private final boolean GOODNIGHT = false;

	public static void main(String[] args) {
		getAccessLogObj().doConfiguration();
	}

	private void doConfiguration() {
		logProp = LogProp.getLogPropObj();
		System.out.print("u need log of last:\n1.5\n\2.10\n3.15\n4.20\n(in minutes): ");
		int timeLimit = sc.nextInt();
		logProp.setTimeLimit(timeLimit);
		/*if(timeLimit>5)
			LOGLAST5MINS=false;
		logProp.setFileSize(Integer.parseInt(System.getenv("DS_IDOCSVR_LOG_BUFFER_SIZE")), LOGLAST5MINS);*/
		logProp.setFileSizeConst(Integer.parseInt(System.getenv("DS_IDOCSVR_LOG_BUFFER_SIZE")));
		logger = SizedLog.getSizedLogObj().configureLogger();
		getAccessLogObj().doWork();
		Viewer.getViewerObj().viewFile(Paths.get(SizedLog.SIZEDLOGLOCATION));
		
	}
	
	private AccessLog(){
		
	}
	
	public static AccessLog getAccessLogObj(){
		if(accessLogObj==null){
			synchronized (AccessLog.class) {
				if(accessLogObj==null){
					accessLogObj = new AccessLog();
				}
			}
		}
		return accessLogObj;
	}
	
	public void doWork(){
		for(int i=0; i<Short.MAX_VALUE; i++){
			if(GOODNIGHT)
				SleepingCurrentThread.buildObj().ripCurrentThread(1);
			logger.info("logger: "+i);
		}
	}
}
