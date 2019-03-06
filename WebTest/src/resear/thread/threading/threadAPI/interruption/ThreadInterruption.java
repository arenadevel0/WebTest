package resear.thread.threading.threadAPI.interruption;

public class ThreadInterruption implements Runnable{

	public static Thread mainParentThread;
	//if the thread sleeps during execution
	public void run(){
		try{
			for(int i=0; i<10; i++){
				System.out.println(Thread.currentThread().getName()+" is lazy - "+i);
				Thread.sleep(100);
			}
		} catch(InterruptedException interruptedException){
			System.out.println("InterruptedException exception caught. No more execution from this thread now!!");
		}
	}
	
	//if the thread sleeps after execution. interrupting thread main-thread will wait till the moment this thread get into sleep even if after completion it's task.
	/*public void run(){
		for(int i=0; i<100; i++){
			System.out.println(Thread.currentThread().getName()+" is lazy - "+i);
		}
		try{
			Thread.sleep(100);
		} catch(InterruptedException interruptedException){
			System.out.println("InterruptedException exception caught. No more execution from this thread now!!");
		}
	}*/
	
	//if the thread never sleeps. Wastage of interrupt call from main-thread bcoz this thread is not sleeping even after the task is executed. Still no exception.
	/*public void run(){
		for(int i=0; i<100; i++){
			System.out.println(Thread.currentThread().getName()+" is lazy - "+i);
		}
		System.out.println(ThreadUtils.getCurrentThreadName()+" is never slept so wastage of calling interrupt call from thread \""+mainParentThread.getName()+"\"");
	}*/
}