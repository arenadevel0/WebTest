package resear.thread.threading.threadAPI.WaitNotifyInterThreadCommunication.ConsumerProducerProblemByWaitNotifyIncomplete;

import java.util.Scanner;

public class ConsumerRemover implements Runnable {

	static Thread producerThread;
	QueueWorker queueWorker = QueueWorker.getQueueWorkerSingletonObj();
	@Override
	public void run() {
		synchronized (queueWorker) {
			String choiceStr=null;
			Scanner scanner = new Scanner(System.in);
			if(queueWorker.isQueueEmpty()){
				System.out.println(QueueWorker.EMPTYQUEUEMESSAGE);
				System.out.println("Kindly wait for producer-thread to add some elements to queue.");
				synchronized (producerThread) {
					try {
						queueWorker.wait();
					} catch (InterruptedException | IllegalMonitorStateException e) {
						e.getMessage();
					}	
				}
			} else{
				do{
					if(queueWorker.isQueueEmpty()){
						queueWorker.notify();	
					}
					System.out.println(queueWorker.queueRemove());
					System.out.print("you want to proceed with removal(yes/no)?: ");
					choiceStr = scanner.nextLine();
				}while(choiceStr.equalsIgnoreCase("yes"));
				
			queueWorker.notify();
			
			}
			scanner.close();
		}
	}
}
