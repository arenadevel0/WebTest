package resear.thread.threading.threadAPI.WaitNotifyInterThreadCommunication.ConsuerProducerProblem02;

import java.util.LinkedList;
import java.util.List;

public class Runner {

	public static void main(String[] args) {
		
		List<String> producerConsumerList = new LinkedList<String>();
		Thread producerThread = new Thread(new Producer(producerConsumerList));
		Thread consumerThread = new Thread(new Consumer(producerConsumerList));
		producerThread.start();
		consumerThread.start();
	}

}
