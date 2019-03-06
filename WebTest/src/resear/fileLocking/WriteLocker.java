package resear.fileLocking;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class WriteLocker {
	StringBuffer stringBuilder = new StringBuffer();
	Path path = Paths.get("D:\\personal_DATA\\fileToLock.txt");
	private static final int LIMIT = 999999;
	private final String eol = System.getProperty("line.separator");
	
	public static void main(String[] args) throws IOException, InterruptedException {
		new WriteLocker().doWork();
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
			for(int i=1; i<=LIMIT; i++){
				stringBuilder.append("i: "+i);
				if(i<LIMIT)
					stringBuilder.append(eol);
			}
			fileChannel.write(ByteBuffer.wrap(stringBuilder.toString().getBytes()));
			long endTime = System.currentTimeMillis();
			System.out.println("Time Efficiency: "+(endTime-startTime)+"millis");
		}
		fileLock.release();
		fileChannel.close();
	}

}