package resear.thread.threading.callableAPI.general;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableExec {

	public static void main(String[] args) {
		
		ExecutorService executor = Executors.newFixedThreadPool(2);
		System.out.println("With Sleep:--------------");
		List<Future<Integer>> factoList = new ArrayList<Future<Integer>>();
		
		Random random = new Random();
		
		for(int i=0; i<4; i++){
			FactorialCalcSleep factorialCalcSleep = new FactorialCalcSleep(random.nextInt(10));
			Future<Integer> futureResult = executor.submit(factorialCalcSleep);
			factoList.add(futureResult);
		}
		
		for(Future<Integer> future: factoList){
			try {
				System.out.println("Future result is - " + " - " + future.get() + "; And Task done is " + future.isDone());
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}
		
		factoList.clear();
		
		System.out.println("Without Sleep:--------------");
						
		for(int i=0; i<4; i++){
			FactorialCalcNoSleep factorialCalcNoSleep = new FactorialCalcNoSleep(random.nextInt(10));
			Future<Integer> futureResult = executor.submit(factorialCalcNoSleep);
			factoList.add(futureResult);
		}
		
		for(Future<Integer> future: factoList){
			try {
				//this could lead to stackoverflow because we're using recursion over here, so maybe a chance for higher digit to have
				//deep stack that could lead towards stackoverflow
				System.out.println("Future result is - " + " - " + future.get() + "; And Task done is " + future.isDone());
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
			
		}
		executor.shutdown();
	}

}
