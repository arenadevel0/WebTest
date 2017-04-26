package resear.utils;

public class SleepingCurrentThread {

	private static SleepingCurrentThread sleepingCurrentThread;
	
	private SleepingCurrentThread(){
		
	}
	
	public static SleepingCurrentThread buildObj(){
		if(sleepingCurrentThread==null){
			synchronized (SleepingCurrentThread.class) {
				if(sleepingCurrentThread==null){
					sleepingCurrentThread = new SleepingCurrentThread();
				}
			}
		}
		return sleepingCurrentThread;
	}
	
	public void ripCurrentThread(long millis){
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}