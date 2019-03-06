package resear.thread.threading.threadAPI.WaitNotifyInterThreadCommunication.ConsuerProducerProblem01;

public class Producer implements Runnable {

	private QueueWorker queueWorkerSingleton;
	private static int i=0;
	public Producer(QueueWorker queueWorkerSingleton) {
		this.queueWorkerSingleton=queueWorkerSingleton;
	}

	@Override
	public void run() {
		while(true){
			doProduce(i);
		}
	}

	private void doProduce(int j) {
		synchronized (queueWorkerSingleton) {
			while (!queueWorkerSingleton.isQueueFull()) {
				queueWorkerSingleton.queueInsert(++i+"");
			}
			System.out.println("producer produced value");
			queueWorkerSingleton.showQueue();
			queueWorkerSingleton.notify();
		}
	}

}
