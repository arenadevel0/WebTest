package resear.thread.threading.threadAPI.general;

public class Runner{

	public static void main(String[] args) throws InterruptedException{
		
		//without thread
		long bef = System.currentTimeMillis();
		new Runner().doWork(bef);
		long aft = System.currentTimeMillis();
		//Thread.sleep(5000);
		System.out.println("time taken without threading: "+new Double((aft-bef)/1000)+"sec");
		
		//with thread
		bef = System.currentTimeMillis();
		// new Runner().doWorkWithThread();
		Thread workerThread1 = new Thread(new WorkerThread1());
		workerThread1.start();
		Thread workerThread2 = new Thread(new WorkerThread2());
		workerThread2.start();
		Thread workerThread3 = new Thread(new WorkerThread3());
		workerThread3.start();
		Thread workerThread4 = new Thread(new WorkerThread4());
		workerThread4.start();
		Thread workerThread5 = new Thread(new WorkerThread5());
		workerThread5.start();

		workerThread1.join();
		workerThread2.join();
		workerThread3.join();
		workerThread4.join();
		workerThread5.join();
		aft = System.currentTimeMillis();
		System.out.println("time taken with threading: "+new Double((aft-bef)/1000)+"sec");
	}
	public void doWork(long bef){
		Worker w = new Worker();
		w.print1();
		w.print2();
		w.print3();
		w.print4();
		w.print5();
	}
	
	public void doWorkWithThread(){
		Thread workerThread1 = new Thread(new WorkerThread1());
		workerThread1.start();
		Thread workerThread2 = new Thread(new WorkerThread2());
		workerThread2.start();
		Thread workerThread3 = new Thread(new WorkerThread3());
		workerThread3.start();
		Thread workerThread4 = new Thread(new WorkerThread4());
		workerThread4.start();
		Thread workerThread5 = new Thread(new WorkerThread5());
		workerThread5.start();
	}
	
}