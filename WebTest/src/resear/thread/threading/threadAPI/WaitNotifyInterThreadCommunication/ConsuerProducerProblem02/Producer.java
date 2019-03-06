package resear.thread.threading.threadAPI.WaitNotifyInterThreadCommunication.ConsuerProducerProblem02;

import java.util.List;

public class Producer implements Runnable {

	private List<String> producerConsumerList;
	private static int i=0;
	public Producer(List<String> producerConsumerList) {
		this.producerConsumerList=producerConsumerList;
	}

	@Override
	public void run() {
		while(true){
			try{
				doProduce();
			} catch(IllegalMonitorStateException e){
				System.out.println(e.getLocalizedMessage());
			}
		}
	}
	private void doProduce() {
		
		synchronized (producerConsumerList) {
			while(producerConsumerList.size()==5){
				System.out.println("list is full already.let consumer, consues some items.");
				try {
					producerConsumerList.wait();
				} catch (InterruptedException | IllegalMonitorStateException e) {
					System.out.println(e.getMessage());
				}
			}
		}
		synchronized (producerConsumerList) {
			producerConsumerList.add((++i)+"");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			producerConsumerList.notify();
		}
		
	}

}
