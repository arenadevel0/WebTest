package resear.thread.threading.threadAPI.WaitNotifyInterThreadCommunication.SimpleExample;

class Runner {
	
	public static void main(String[] args) {
		
		Worker.getCurrentThreadCount();
		Worker.setCurrentThreadName("main-thread");
		Worker.getCurrentThreadName();

		WaitNotifyThreadDemo.mainThreadParent = Thread.currentThread();
		Thread waitNotifyThreadDemoThread = new Thread(new WaitNotifyThreadDemo());
		waitNotifyThreadDemoThread.setName("waitNotifyThreadDemo-thread");
		waitNotifyThreadDemoThread.start();
		synchronized(waitNotifyThreadDemoThread){
			System.out.println(Worker.getWhatCurrentThreadName()+ " is going to wait for "+waitNotifyThreadDemoThread.getName());
			System.out.println("Control is going from "+Worker.getWhatCurrentThreadName()+" to "+waitNotifyThreadDemoThread.getName());
			try{
				waitNotifyThreadDemoThread.wait();
			} catch(InterruptedException interruptedException){
				interruptedException.getMessage();
			}
			
			System.out.println(waitNotifyThreadDemoThread.getName()+ " has done it's work and now waiting time for "+Worker.getWhatCurrentThreadName()+" is over so, "+Worker.getWhatCurrentThreadName()+" can resume.");
		}

	}
}