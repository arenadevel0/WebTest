package resear.thread.threading.threadAPI.interruption;

public class ThreadUtils{

	public static String getCurrentThreadName(){
	
		return "\""+Thread.currentThread().getName()+"\"";
	}
}