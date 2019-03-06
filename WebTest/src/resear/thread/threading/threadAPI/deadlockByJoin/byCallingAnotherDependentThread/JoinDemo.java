package resear.thread.threading.threadAPI.deadlockByJoin.byCallingAnotherDependentThread;

public class JoinDemo implements Runnable{
	
	public static Thread parentMainThread;
	
	public void run() {
		try{
			//below line results infinite loops. as it maks it dependent on main-thread which is dependent on joinDemoThread.
			parentMainThread.join();//joinDemoThread join main-thread and will wait until it gets executed completly. This line means current executing thread i.ejoinDemoThread  joins main-thrad.
			UtilsClass.doLoopTill10();			
		} catch(InterruptedException interruptedException){
			interruptedException.getMessage();
		}
	}
}