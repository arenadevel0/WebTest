package resear.thread.threading.threadAPI.yield;

public class YeildDemo implements Runnable{
	public void run(){
		System.out.println("child thread of main-thread that will be responsible below code, and which is started by main-thread is: "+Thread.currentThread().getName());
		System.out.println(Thread.currentThread().getName()+" state : "+Thread.currentThread().getState());
		System.out.println(Thread.currentThread().getName()+" priority : "+Thread.currentThread().getPriority());
		
		System.out.println(Thread.currentThread().getName()+" would like to let other thread or same or higher priority to be excuted first ,so it's going to be yeild. Now this thread will be the last one to finished.");
		Thread.yield();
		
		UtilsClass.doLoopTill10();
	}
}