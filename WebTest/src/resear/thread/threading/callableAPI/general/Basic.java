package resear.thread.threading.callableAPI.general;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Basic {

	public static void main(String[] args) {
		
		ExecutorService executors = Executors.newFixedThreadPool(2);
		
		List<Future<String>> taskList = new ArrayList<Future<String>>();
		
		Future<String> futureTask = executors.submit(new Task1to10Add());
		taskList.add(futureTask);
		futureTask = executors.submit(new Task11to20Add());
		taskList.add(futureTask);
		futureTask = executors.submit(new Task31to40Add());
		taskList.add(futureTask);
		futureTask = executors.submit(new Task21to30Add());
		taskList.add(futureTask);
		
		
		for(Future<String> futureT: taskList){
			try {
				System.out.println(futureT.get());
			} catch (ExecutionException | InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		executors.shutdown();
	}

}

class Task1to10Add implements Callable<String>{
	public String call(){
		int n=0;
		for(int i=1; i<=10; i++){
			n+=i;
		}
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "Addition of 1 to 10 is "+n;
	}
}

class Task11to20Add implements Callable<String>{
	public String call(){
		int n=0;
		for(int i=11; i<=20; i++){
			n+=i;
		}
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "Addition of 11 to 20 is "+n;
	}
}

class Task21to30Add implements Callable<String>{
	public String call(){
		int n=0;
		for(int i=21; i<=30; i++){
			n+=i;
		}
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "Addition of 21 to 30 is "+n;
	}
}

class Task31to40Add implements Callable<String>{
	public String call(){
		int n=0;
		for(int i=31; i<=40; i++){
			n+=i;
		}
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "Addition of 31 to 40 is "+n;
	}
}
