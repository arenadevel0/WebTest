package resear.thread.threading.threadAPI.yield;

public class Runner{
	public static void main(String[] args) {
		
		UtilsClass.getTotalThread();
		System.out.println("Only non-daemon thread(parent of all other threads that are going to start under it's command/methos) that runs from starting is : "+Thread.currentThread().getName());
		Thread.currentThread().setName("main-thread");
		System.out.println("new name of main thread is : "+Thread.currentThread().getName());
		System.out.println(Thread.currentThread().getName()+" state : "+Thread.currentThread().getState());
		System.out.println(Thread.currentThread().getName()+" priority : "+Thread.currentThread().getPriority());
		
		Thread yeildDemoThread = new Thread(new YeildDemo());
		yeildDemoThread.setName("yeildDemo-thread");
		yeildDemoThread.start();
		UtilsClass.getTotalThread();
		
		System.out.println("in this method rest is executed by: "+Thread.currentThread().getName());
		UtilsClass.doLoopTill10();
		
	}
}