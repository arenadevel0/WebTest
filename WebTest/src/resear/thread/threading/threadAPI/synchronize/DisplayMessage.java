package resear.thread.threading.threadAPI.synchronize;

/*no matter is current thread is sleeping or not, if it gets the lock by synchronization, then until it completed all 
 * it's execution it'll not release object(DisplayMessage here) lock and next thread will not be able to gain that lock.
next thread can't gain lock*/

public class DisplayMessage {

	/*uncomment/comment synchronized to see effect of synchronization*/
	public synchronized void showGreetingMessage(String name){
		
		for(int i=0; i<10; i++){
			System.out.print("Greetings: ");
			try {
				Thread.sleep(100);
				System.out.println(name);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
