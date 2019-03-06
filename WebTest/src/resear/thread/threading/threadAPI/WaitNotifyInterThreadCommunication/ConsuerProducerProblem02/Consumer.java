package resear.thread.threading.threadAPI.WaitNotifyInterThreadCommunication.ConsuerProducerProblem02;

import java.util.List;

public class Consumer implements Runnable {

	private List<String> producerConsumerList;
	
	public Consumer(List<String> producerConsumerList) {
		this.producerConsumerList=producerConsumerList;
	}
	
	@Override
	public void run() {
		while(true){
			try {
				doConsume();
			} catch (IllegalMonitorStateException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	private void doConsume() {
		
		synchronized (producerConsumerList) {
			while(producerConsumerList.isEmpty()){
				System.out.println("list is empty. let producer produce some itmes in the list.");
				try {
					producerConsumerList.wait();
				} catch (InterruptedException | IllegalMonitorStateException e) {
					System.out.println(e.getMessage());
				}
			}
		}
		synchronized (producerConsumerList) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
			System.out.println("consumer consumed item: "+producerConsumerList.remove(0));
			producerConsumerList.notify();
		}
		
	}

}
