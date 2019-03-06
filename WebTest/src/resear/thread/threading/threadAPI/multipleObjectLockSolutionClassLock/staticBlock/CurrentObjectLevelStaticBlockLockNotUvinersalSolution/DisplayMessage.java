package resear.thread.threading.threadAPI.multipleObjectLockSolutionClassLock.staticBlock.CurrentObjectLevelStaticBlockLockNotUvinersalSolution;

public class DisplayMessage {
	
	/*not a viable solution, will make unsynchronized data when more than two objects of DisplayMessage will give their respective locks to different threads.*/
	public void greetingMessage(String name){
		synchronized(this){
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