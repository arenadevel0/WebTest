package resear.thread.threading.threadAPI.deadlockByJoin.byCallingAnotherDependentThread;

public class UtilsClass{

	public static void doLoopTill10() throws InterruptedException{
		for(int i=0; i<10; i++){
			System.out.println(Thread.currentThread().getName()+" "+i);
			if(Thread.currentThread().getName().contains("joinDemo-thread")){
				Thread.sleep(100);
				if(i==9){
					System.out.println("Now main-thread will start running");
					Thread.sleep(1000);
				}
			}
		}
	}
	
	public static void getTotalThread(){
		System.out.println("Total number of threads in current thread's thread group: "+Thread.activeCount());
	}
}