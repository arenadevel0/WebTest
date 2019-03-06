package resear.thread.threading.threadAPI.join;

public class Runner{
	public static void main(String[] args) throws InterruptedException{
		
		UtilsClass.getTotalThread();
		System.out.println("Only non-daemon thread(parent of all other threads that are going to start under it's command/methos) that runs from starting is : "+Thread.currentThread().getName());
		Thread.currentThread().setName("main-thread");
		
		Thread joinDemoThread = new Thread(new JoinDemo());
		joinDemoThread.setName("joinDemo-thread");
		joinDemoThread.start();
		UtilsClass.getTotalThread();
		
//		comment below two lines to see it's effect and vice-versa.
		System.out.println(Thread.currentThread().getName()+" will wait for "+joinDemoThread.getName()+" to be finishd first no matter, how much time it'll take and then it'll start it's execution");
		joinDemoThread.join();//main method join joinDemoThread and will wait until it gets executed completly. This line means current executing thread i.e main-thrad joins joinDemoThread.
		
//		comment above two lines to see it's effect and vice-versa.
//		System.out.println(Thread.currentThread().getName()+" will wait for "+joinDemoThread.getName()+" to get excuted for 500 milliscond, after this, "+Thread.currentThread().getName()+"'ll take it's turn");
//		joinDemoThread.join(500);//main method join joinDemoThread and will wait for 500 millisecond, if joinDemoThread executed completly or not, it'll gonna start executing. This line means current executing thread i.e main-thrad joins joinDemoThread.
		
		UtilsClass.doLoopTill10();
		
		System.out.println(Thread.currentThread().getName()+" belongs to the group: "+Thread.currentThread().getThreadGroup().getName());
		
	}
}