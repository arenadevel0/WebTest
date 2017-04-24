package resear.thread.daemon.basic;

class CustomDaemonExecutor {
	public static void main(String[] args) {
		Thread customDaemon = new Thread(new CustomDaemon());
		customDaemon.start();
	}
}