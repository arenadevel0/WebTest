package resear.thread.threading.threadAPI.multipleObjectLockSolutionClassLock.staticSynchronizedMethod;

public class DisplayMessage {

	/*to solve the problem of two object lock of current object, make the object lock on current class, make the synchronized method static.*/
	
	/*uncomment static to see the change*/
	public static synchronized void greetingMessage(String name){
		for(int i=0; i<10; i++){
			System.out.print("Greeting: ");
			try{
				Thread.sleep(100);
			} catch(InterruptedException interruptedException){
				interruptedException.getMessage();
			}
			System.out.println(name);
		}
	}
}