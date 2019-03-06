package resear.thread.threading.threadAPI.multipleObjectLockSolutionClassLock.staticBlock.ClassLevelStaticBlockLockUniversalSolution;

public class SynchronizedThreadDemo implements Runnable {
	
	private DisplayMessage displayMessage;
	private String name;

	public SynchronizedThreadDemo(DisplayMessage displayMessage, String name){
		this.displayMessage=displayMessage;
		this.name=name;
	}

	public void run(){
		displayMessage.greetingMessage(name);
	}
}