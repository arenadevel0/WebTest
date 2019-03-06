package resear.thread.threading.executorAPI.general;

import java.util.concurrent.TimeUnit;

public class LoopTill10 implements Runnable{
	
	private static int count=0;
	private int id;
	
	public LoopTill10(){
		this.id=++count;
	}
	
	@Override
	public void run(){
		System.out.println("#### <TASK-"+id+"> STARTING ####");
		
		for(int i=1; i<=10; i++){
			System.out.println("<TASK-"+id+">TICK TICK  - "+i);
			try{
				TimeUnit.MILLISECONDS.sleep((long)(Math.random()*1000));
			}catch(InterruptedException e){
				System.out.println(e.getMessage());
			}
		}
		System.out.println("#### <TASK-"+id+"> COMPLETED ####");
	}
}