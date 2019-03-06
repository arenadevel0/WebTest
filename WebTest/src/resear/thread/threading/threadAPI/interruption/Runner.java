package resear.thread.threading.threadAPI.interruption;

public class Runner{

	public static void main(String[] args) throws InterruptedException{
		ThreadInterruption.mainParentThread = Thread.currentThread();
		
		Thread.currentThread().setName("main-thread");
		System.out.println("current thread is: "+ThreadUtils.getCurrentThreadName());
		
		Thread threadInterruptionThread = new Thread(new ThreadInterruption());
		threadInterruptionThread.setName("interrupted-thread");
		threadInterruptionThread.start();
		
		System.out.println(ThreadUtils.getCurrentThreadName()+" is interrupting sleeping thread \""+threadInterruptionThread.getName()+"\". If \""+threadInterruptionThread.getName()+
		"\" is in sleep mode then "+ThreadUtils.getCurrentThreadName()+" will interrupt it else it will wait to get \n\""+threadInterruptionThread.getName()+"\" in sleeping state.");
		threadInterruptionThread.interrupt();
	}
}