package resear.fileLocking;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class WriteLockerThreaded {
	StringBuffer stringBuilder = new StringBuffer();
	Path path = Paths.get("D:\\personal_DATA\\fileToLock.txt");
	private static final int LIMIT = 99999;
	private final String eol = System.getProperty("line.separator");
	
	public static void main(String[] args) throws IOException, InterruptedException {
		new WriteLockerThreaded().doWork();
	}

	private void doWork() throws IOException, InterruptedException {
		Files.deleteIfExists(path);
		Files.createFile(path);
		FileChannel fileChannel = FileChannel.open(path, StandardOpenOption.WRITE, StandardOpenOption.READ);
		FileLock fileLock = fileChannel.lock();
		System.out.println("is fileLock shared: "+fileLock.isShared());
		Thread.sleep(10000);
		long startTime = System.currentTimeMillis();
		if(fileLock.isValid()){
			Thread t1 = new Thread(new Runnable(){
				public void run(){
					for(int i=0; i<LIMIT; i++){
						stringBuilder.append("This is printed by thread-1"+eol);
					}
				}
			});
			t1.start();
			
			Thread t2 = new Thread(new Runnable(){
				public void run(){
					for(int i=0; i<LIMIT; i++){
						stringBuilder.append("This is printed by thread-2"+eol);
					}
				}
			});
			t2.start();
			
			Thread t3 = new Thread(new Runnable(){
				public void run(){
					for(int i=0; i<LIMIT; i++){
						stringBuilder.append("This is printed by thread-3"+eol);
					}
				}
			});
			t3.start();
			
			Thread t4 = new Thread(new Runnable(){
				public void run(){
					for(int i=0; i<LIMIT; i++){
						stringBuilder.append("This is printed by thread-4"+eol);
					}
				}
			});
			t4.start();
			
			t1.join();
			t2.join();
			t3.join();
			t4.join();
			
			fileChannel.write(ByteBuffer.wrap(stringBuilder.toString().getBytes()));
			long endTime = System.currentTimeMillis();
			System.out.println("Time Efficiency: "+(endTime-startTime)+"millis");
		}
		fileLock.release();
		fileChannel.close();
	}

}