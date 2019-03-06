package resear.thread.threading.threadAPI.general;

public class Worker{

	private static final long CONST = 10;
	
	public void print1(){
		for(long i=0; i<(Integer.MAX_VALUE*CONST); i++){
		}
		System.out.println("print1 done!");
	}
	
	public void print2(){
		for(long i=0; i<(Integer.MAX_VALUE*CONST); i++){
		}
		System.out.println("print2 done!");
	}
	
	public void print3(){
		for(long i=0; i<(Integer.MAX_VALUE*CONST); i++){
		}
		System.out.println("print3 done!");
	}
	
	public void print4(){
		for(long i=0; i<(Integer.MAX_VALUE*CONST); i++){
		}
		System.out.println("print4 done!");
	}
	
	public void print5(){
		for(long i=0; i<(Integer.MAX_VALUE*CONST); i++){
		}
		System.out.println("print5 done!");
	}
}