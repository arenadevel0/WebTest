package resear.thread.threading.executorAPI.general;

/*
Fixed number of threads runns that ar specifiesd, and once each of them completd their work, thn look into workqueue, and start execting the next task found.
xample here:
6 taks in workpool/taskpool
3 threads . first these 3 complete their from those 6 tasks and once they completem thn they take remaining tasks from pools.
at a tim eonlt 3 tasks can be done concurrently.
*/

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UsingFixedThreadExecutorDemo{
	
	public static void main(String[] args){
		
		System.out.println("Main thread starts here...");
		
		ExecutorService execService = Executors.newFixedThreadPool(3);
		
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