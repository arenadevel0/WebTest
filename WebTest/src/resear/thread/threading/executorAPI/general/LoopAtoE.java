package resear.thread.threading.executorAPI.general;

import java.util.concurrent.TimeUnit;

public class LoopAtoE implements Runnable{
	
	private static int count=64;
	private char id;
	
	public LoopAtoE(){
		this.id=(char)++count;
	}
	
	@Override
	public void run(){
		System.out.println("#### <TASK-"+id+"> STARTING ####");
		
		for(int i=65; i<=69; i++){
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