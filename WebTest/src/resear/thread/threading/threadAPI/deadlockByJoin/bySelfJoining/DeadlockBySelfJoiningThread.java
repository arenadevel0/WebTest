package resear.thread.threading.threadAPI.deadlockByJoin.bySelfJoining;

public class DeadlockBySelfJoiningThread{
	public static void main(String[] args) throws InterruptedException{
		System.out.println("Current number of thread in current thread group: "+ Thread.activeCount());
		System.out.println("Current Thread name is: "+Thread.currentThread().getName());
		System.out.println("Current Thread joins current thread (i.e. itself), results to deadloack: ");
		Thread.currentThread().join();
	}
}