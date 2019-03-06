package resear.thread.threading.threadAPI.general;

public class WorkerThread1 implements Runnable{

	public void run(){
		new Worker().print1();
	}
}