package resear.thread.threading.threadAPI.synchronize;

public class Runner {

	public static void main(String[] args) {
		DisplayMessage displayMessage = new DisplayMessage();
		
		SynchronizedThreadDemo synchronizedThreadDemo1 = new SynchronizedThreadDemo(displayMessage, "Thread-1");
		SynchronizedThreadDemo synchronizedThreadDemo2 = new SynchronizedThreadDemo(displayMessage, "Thread-2");
		SynchronizedThreadDemo synchronizedThreadDemo3 = new SynchronizedThreadDemo();
		synchronizedThreadDemo3.setDisplayMessage(displayMessage);
		synchronizedThreadDemo3.setName("Thread-3");
		SynchronizedThreadDemo synchronizedThreadDemo4 = new SynchronizedThreadDemo();
		synchronizedThreadDemo4.setDisplayMessage(displayMessage);
		synchronizedThreadDemo4.setName("Thread-4");
		
		Thread thread1 = new Thread(synchronizedThreadDemo1);
		Thread thread2 = new Thread(synchronizedThreadDemo2);
		Thread thread3 = new Thread(synchronizedThreadDemo3);
		Thread thread4 = new Thread(synchronizedThreadDemo4);
		
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
	}

}
