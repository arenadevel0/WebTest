package resear.thread.threading.threadAPI.multipleObjectLockSolutionClassLock.staticBlock.ClassLevelStaticBlockLockUniversalSolution;

public class Runner {
	public static void main(String[] args) {
		 
		/*no matter how many object of DisplayMessage give their locks to Threads, Class level lock in synchronized block will make it even.*/

		DisplayMessage displayMessage1 = new DisplayMessage();
		DisplayMessage displayMessage2 = new DisplayMessage();

		Thread synchronizedThreadDemo1 = new Thread(new SynchronizedThreadDemo(displayMessage1, "Thread-1"));
		Thread synchronizedThreadDemo2 = new Thread(new SynchronizedThreadDemo(displayMessage1, "Thread-2"));
		Thread synchronizedThreadDemo3 = new Thread(new SynchronizedThreadDemo(displayMessage2, "Thread-3"));
		Thread synchronizedThreadDemo4 = new Thread(new SynchronizedThreadDemo(displayMessage2, "Thread-4"));

		synchronizedThreadDemo1.start();
		synchronizedThreadDemo2.start();
		synchronizedThreadDemo3.start();
		synchronizedThreadDemo4.start();
	}
}