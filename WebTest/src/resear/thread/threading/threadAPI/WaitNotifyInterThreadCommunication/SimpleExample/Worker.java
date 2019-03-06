package resear.thread.threading.threadAPI.WaitNotifyInterThreadCommunication.SimpleExample;

class Worker {
	
	public void doPrintTill1000()  {
		for (int i=0; i<100; i++) {
			System.out.println("I'll print till 10000: "+i);
		}
	}

	public static void setCurrentThreadName(String name){
		Thread.currentThread().setName(name);
	}
	public static void getCurrentThreadName(){
		System.out.println("Current Thread name is: "+Thread.currentThread().getName());
	}

	public static String getWhatCurrentThreadName(){
		return Thread.currentThread().getName();
	}

	public static void getCurrentThreadCount(){
		System.out.println("Currently "+Thread.activeCount()+" thrads are in the current thread group.");
	}
}