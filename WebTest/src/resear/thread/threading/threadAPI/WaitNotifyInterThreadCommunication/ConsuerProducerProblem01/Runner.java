package resear.thread.threading.threadAPI.WaitNotifyInterThreadCommunication.ConsuerProducerProblem01;

public class Runner {

	public static void main(String[] args) {
		
		QueueWorker queueWorkerSingleton=QueueWorker.getQueueWorkerSingletonObj();
		Thread producerThread = new Thread(new Producer(queueWorkerSingleton));
		Thread consumerThread = new Thread(new Consumer(queueWorkerSingleton));
		producerThread.start();
		consumerThread.start();
	}

}
