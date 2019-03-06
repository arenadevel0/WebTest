package resear.thread.threading.threadAPI.deadlockByJoin.byCallingAnotherDependentThread;

public class Runner{
	public static void main(String[] args) throws InterruptedException{
		
		JoinDemo.parentMainThread = Thread.currentThread();
		
		UtilsClass.getTotalThread();
		System.out.println("Only non-daemon thread(parent of all other threads that are going to start under it's command/methos) that runs from starting is : "+Thread.currentThread().getName());
		Thread.currentThread().setName("main-thread");
		
		Thread joinDemoThread = new Thread(new JoinDemo());
		joinDemoThread.setName("joinDemo-thread");
		joinDemoThread.start();
		System.out.println(joinDemoThread.getName()+" is started by "+Thread.currentThread().getName());
		UtilsClass.getTotalThread();
		
		System.out.println(Thread.currentThread().getName()+" will wait for "+joinDemoThread.getName()+" to be finishd first no matter, how much time it'll take and then it'll start it's execution");
		//below line results infinite loops. as it maks it dependent on joinDemoThread which is already dependent on main-thread
		joinDemoThread.join();//main method join joinDemoThread and will wait until it gets executed completly. This line means current executing thread i.e main-thrad joins joinDemoThread.
				
		UtilsClass.doLoopTill10();
				
	}
}