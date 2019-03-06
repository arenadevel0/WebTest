package resear.thread.threading.executorAPI.general;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
number of tasks = numbers of thrads created. If another tasks defines and if a thread is free thn it taks over otherwise new thread will be creatd. No upper limit for number of threads in this case.
*/

public class UsingCacheThreadExecutorDemo{
	
	public static void main(String[] args){
		
		System.out.println("Main thread starts here...");
		
		ExecutorService execService = Executors.newCachedThreadPool();
		
		execService.execute(new LoopTill10());
		execService.execute(new LoopTillJ());
		execService.execute(new LoopAtoE());
		execService.execute(new LoopTill10());
		execService.execute(new LoopAtoE());
		execService.execute(new LoopTillJ());
		try{
			Thread.sleep(5000);
		} catch(InterruptedException e){
			System.out.println(e.getMessage());
		}
		execService.execute(new LoopAtoE());
		execService.execute(new LoopTill10());
		execService.execute(new LoopTillJ());
		
		
		execService.shutdown();
		
		System.out.println("Main thread ends here...");
	}
}