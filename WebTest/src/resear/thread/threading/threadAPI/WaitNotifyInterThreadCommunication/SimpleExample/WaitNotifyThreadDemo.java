package resear.thread.threading.threadAPI.WaitNotifyInterThreadCommunication.SimpleExample;

class WaitNotifyThreadDemo implements Runnable {

	static Thread mainThreadParent;
	public void run(){
		synchronized(this){
			System.out.println(mainThreadParent.getName()+" is waiting for the "+Worker.getWhatCurrentThreadName()+ "to complete it's work");
			new Worker().doPrintTill1000();
			System.out.println(Worker.getWhatCurrentThreadName()+" is going to notify to "+mainThreadParent.getName());
			try{
				Thread.sleep(1000);
			} catch(InterruptedException interruptedException){
				System.out.println(interruptedException.getMessage());
			}
			System.out.println("Parent thread "+mainThreadParent.getName()+" state:"+mainThreadParent.getState());
			this.notify();
			System.out.println(Worker.getWhatCurrentThreadName()+" has completed it's work and now notified "+mainThreadParent.getName());
			System.out.println("Control is going from "+Worker.getWhatCurrentThreadName()+" to "+mainThreadParent.getName());
		}
	}
}