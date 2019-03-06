package resear.thread.threading.threadAPI.multipleObjectLockSolutionClassLock.staticBlock.ClassLevelStaticBlockLockUniversalSolution;

public class DisplayMessage {
	
	/*synchronized block on class level lock, ultimate solution for all problem. No matter how many object uses this method on there respective lock,
	class lock will prevent the data from being unsynchronized*/
	public void greetingMessage(String name){
		synchronized(DisplayMessage.class){
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
}