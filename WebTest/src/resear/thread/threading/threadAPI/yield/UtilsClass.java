package resear.thread.threading.threadAPI.yield;

public class UtilsClass{

	public static void doLoopTill10(){
		for(int i=0; i<10; i++){
			System.out.println(Thread.currentThread().getName()+" "+i);
		}
	}
	
	public static void getTotalThread(){
		System.out.println("Total number of threads in current thread's thread group: "+Thread.activeCount());
	}
}