package resear.logger.prac.timed;

import java.lang.reflect.Method;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.logging.Logger;

import resear.utils.SleepingCurrentThread;
import resear.utils.Viewer;
/**
 * 
 * Provide environment variable DS_IDOCSVR_LOG_BUFFER_SIZE with integer value before running this
 * 
 **/

public class AccessLog {
	
	private volatile static AccessLog accessLogObj;
	private Logger logger;
	private LogProp logProp;
	private Scanner sc = new Scanner(System.in);
	/*private boolean LOGLAST5MINS = true;*/
	private final boolean GOODNIGHT = false;

	public static void main(String[] args) throws ClassNotFoundException {
		
		
		
//		getAccessLogObj().doConfiguration();
		int var = 0;
		int varPlusTen = 0;
		boolean makeSleep=false;
		for(int i=0; i<Integer.MAX_VALUE; i++){
			System.out.println(i);
//			this.logger.log(Level.INFO, ">>>>>> DS_IDOCSVR_LOG_BUFFER_SIZE: "+System.getenv("DS_IDOCSVR_LOG_BUFFER_SIZE")+" :"+i+"\n");
			if(i%16384==0 && i>=16384){
//				this.logger.log(Level.INFO, "Reached: "+i);
				System.out.println(i);
				var = i;
				varPlusTen=var+10;
			}	
			if(i<varPlusTen){
				System.out.println(i);
				makeSleep=true;
//				this.logger.log(Level.INFO, "Reached: "+i);
			}else{
				varPlusTen=0;
				makeSleep=false;
			}
			if(makeSleep){
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			String hi = "TRUE";
			if(Boolean.parseBoolean(hi))
				System.out.println("done!!");
			
//			System.out.println("null parsing Integer: "+Integer.parseInt(null));
			System.out.println("null parsing Boolean: "+Boolean.parseBoolean(null));
//			System.out.println("null parsing Double: "+Double.parseDouble(null));
//			System.out.println("null parsing Long: "+Long.parseLong(null));
			Double d = 129826471.7898734;
			System.out.println("size: "+Double.SIZE);
			
			for(Method meth: Object.class.getDeclaredMethods()){
				System.out.println(meth.getName());
			}
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
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
