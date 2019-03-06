package resear.thread.threading.threadAPI.synchronize;

import java.lang.reflect.Method;

public class SynchronizedThreadDemo implements Runnable{

	private DisplayMessage displayMessage;
	
	private String name;
	
	public SynchronizedThreadDemo(){
		
	}
	
	static{
		try {
			Method displayMessageshowGreetingMessageMethod = Class.forName("threading.threadAPI.synchronize.DisplayMessage").getMethod("showGreetingMessage", String.class);
			
			/*to check is method is synchronized*/
			/*first way*/
			/*System.out.println(Modifier.isSynchronized(displayMessageshowGreetingMessageMethod.getModifiers()));
			System.out.println("modifier: "+displayMessageshowGreetingMessageMethod.getModifiers());*/
			/*second way*/
			/*System.out.println(displayMessageshowGreetingMessageMethod.toGenericString()+"\n"+displayMessageshowGreetingMessageMethod.toString());*/
			
			if(displayMessageshowGreetingMessageMethod.toString().contains("synchronized")){
				System.err.println("-------x------ synchronized output -------x------\n\n");
			} else{
				System.err.println("-------x------ non-synchronized output -------x------\n\n");
			}
			
		} catch (SecurityException | ClassNotFoundException | NoSuchMethodException e) {
			e.printStackTrace();
		}
	}
	
	public SynchronizedThreadDemo(DisplayMessage displayMessage, String name) {
		this.displayMessage=displayMessage;
		this.name=name;
	}
	
	public DisplayMessage getDisplayMessage() {
		return displayMessage;
	}

	public void setDisplayMessage(DisplayMessage displayMessage) {
		this.displayMessage = displayMessage;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		displayMessage.showGreetingMessage(name);
	}

}
