package resear.thread.threading.executorAPI.general;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
Only one thread runs at a time.
*/

public class UsingSingleThreadExecutorDemo{
	
	public static void main(String[] args){
		
		System.out.println("Main thread starts here...");
		
		ExecutorService execService = Executors.newSingleThreadExecutor();
		
		execService.execute(new LoopTill10());
		execService.execute(new LoopTillJ());
		execService.execute(new LoopTill10());
		execService.execute(new LoopTillJ());
		execService.execute(new LoopTill10());
		execService.execute(new LoopTillJ());
		
		execService.shutdown();
		
		System.out.println("Main thread ends here...");
	}
}