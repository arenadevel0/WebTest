package resear.thread.general;


import java.util.Scanner;

public class TestThread {

	public static void main(String[] args) {
		
		Processor processor = new Processor();
		processor.start();
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Press ENTER to stop the thread");
		scanner.nextLine();
		scanner.close();
		processor.shutDown();
	}

}

class Processor extends Thread{
	
	public boolean running = true;

	@Override
	public void run() {
		while(running){
			System.out.println("..Print..");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void shutDown(){
		running = false;
	}
	
}
