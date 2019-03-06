package resear.thread.threading.executorAPI.general;

import java.util.concurrent.TimeUnit;

public class LoopTillJ implements Runnable{
	
	private static int count=96;
	private char id;

	public LoopTillJ(){
		this.id=(char)++count;
	}
	
	@Override
	public void run(){
		System.out.println("#### <TASK-"+id+"> STARTING ####");
		
		for(int i=97; i<=106; i++){
			System.out.println("<TASK-"+id+">TICK TICK  - "+(char)i);
			try{
				TimeUnit.MILLISECONDS.sleep((long)(Math.random()*1000));
			}catch(InterruptedException e){
				System.out.println(e.getMessage());
			}
		}
		System.out.println("#### <TASK-"+id+"> COMPLETED ####");
	}
	
}