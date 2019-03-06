package resear.thread.threading.threadAPI.join;

public class JoinDemo implements Runnable{
	public void run() {
		try{
			UtilsClass.doLoopTill10();			
		} catch(InterruptedException interruptedException){
			interruptedException.getMessage();
		}
	}
}