package resear.thread.threading.threadAPI.WaitNotifyInterThreadCommunication.ConsumerProducerProblemByWaitNotifyIncomplete;

public class Runner {

	public static void main(String[] args) throws InterruptedException {
		
		Thread producerThread = new Thread(new ProducerInserter());
		Thread consumerThread = new Thread(new ConsumerRemover());
		producerThread.setName("producer-thread");
		consumerThread.setName("consumer-thread");
		ProducerInserter.consumerThread = consumerThread;
		ConsumerRemover.producerThread = producerThread;
		producerThread.start();
		consumerThread.start();		
		
	}
	
	public static String insertIntoQueue(QueueWorker queueWorker){
		if(queueWorker.isQueueFull()){
			return QueueWorker.FULLQUEUEMESSAGE;
		}
		queueWorker.queueInsert(10+"");
		return 10+" is inserted into the Queue.\n"+queueWorker.queueStatus();
	}
	
	public static String removeFromQueue(QueueWorker queueWorker){
		if(queueWorker.isQueueEmpty())
			System.out.println(QueueWorker.EMPTYQUEUEMESSAGE);
		
		return queueWorker.queueRemove()+" element is removed from Queue.\n"+queueWorker.queueStatus();
	}

}
