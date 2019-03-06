package resear.thread.threading.threadAPI.WaitNotifyInterThreadCommunication.ConsumerProducerProblemByWaitNotifyIncomplete;

import java.util.Scanner;

public class ProducerInserter implements Runnable {

	static Thread consumerThread;
	QueueWorker queueWorker = QueueWorker.getQueueWorkerSingletonObj();
	@Override
	public void run() {
		synchronized(queueWorker){
			String choice;
			Scanner scanner = new Scanner(System.in);
			if(queueWorker.isQueueFull()){
				System.out.println(QueueWorker.FULLQUEUEMESSAGE);
				System.out.println("Kindly wait for consumer-thread to remove some elements from queue.");			
				try {
					queueWorker.wait();
				} catch (InterruptedException | IllegalMonitorStateException e) {
					e.getMessage();
				}
			} else{
				do{
					if(queueWorker.isQueueFull()){
						System.out.println("QueueFull");
						queueWorker.notify();					
					}
					System.out.print("enter the element(insert integer value):");
					queueWorker.queueInsert(scanner.nextInt()+"");
					System.out.println(queueWorker.showQueue());
					scanner.nextLine();
					System.out.print("press yes/y to proceed with insertion: ");
					choice= scanner.nextLine();
				}while(choice.equalsIgnoreCase("yes")||choice.equalsIgnoreCase("y"));
				queueWorker.notify();
			}
			scanner.close();
		}
	}
}
