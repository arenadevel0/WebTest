package resear.thread.threading.threadAPI.WaitNotifyInterThreadCommunication.ConsuerProducerProblem01;

public class Consumer implements Runnable {

	private QueueWorker queueWorkerSingleton;
	
	public Consumer(QueueWorker queueWorkerSingleton) {
		this.queueWorkerSingleton=queueWorkerSingleton;
	}
	
	@Override
	public void run() {
		while(true){
			doConsume();
		}
	}

	private void doConsume() {
		synchronized (queueWorkerSingleton) {
			if(queueWorkerSingleton.isQueueEmpty()){
				try {
					System.out.println("wait for producer to produce");
					queueWorkerSingleton.wait();
				} catch (InterruptedException | IllegalMonitorStateException e) {
					System.out.println(e.getMessage());
				}
			} else{
				System.out.println("Consumer consuming");
				while(!queueWorkerSingleton.isQueueEmpty()){
					System.out.println("Consumed item: "+queueWorkerSingleton.queueRemove());
				}
			}
		}		
	}

}
