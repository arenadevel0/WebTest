package resear.fileLocking;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class ReadLocker {

	Path path = Paths.get("D:\\personal_DATA\\fileToLock.txt");
	
	public static void main(String[] args) throws IOException {
		new ReadLocker().doWork();
	}

	private void doWork() throws IOException {
		if (Files.exists(path)) {
			for (;;) {
				FileChannel fileChannel = FileChannel.open(path, StandardOpenOption.WRITE);
				FileLock fileLock = fileChannel.tryLock();
				if (fileLock != null) {
					fileLock.release();
					fileChannel.close();
					Path path1 = Paths.get("D:\\personal_DATA\\readerFile.txt");
					Files.deleteIfExists(path1);
					Files.createFile(path1);
					Writer writer = new FileWriter(path1.toFile());
					BufferedWriter bufferedWriter = new BufferedWriter(writer);
					Reader reader = new FileReader(path.toFile());
					BufferedReader bufferedReader = new BufferedReader(reader);
					StringBuilder stringBuilder = new StringBuilder();
					String str = "";
					System.out.println("file created and writing start at path: "+path1);
					while ((str = bufferedReader.readLine()) != null && str.length() != 0) {
						stringBuilder.append(str+"\n");
					}
					bufferedWriter.write(stringBuilder.toString());
					bufferedReader.close();
					bufferedWriter.close();
					System.out.println("writing done at path: "+path1);
					System.out.print("press enter to open the file: ");
					if(System.in.read()==13)
						Desktop.getDesktop().open(path1.toFile());
					else
						System.exit(0);
//					Desktop.getDesktop().open(path.toFile());
//					Desktop.getDesktop().open(path1.toFile());
					break;
				} else{
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.err.println("Still Locked");
				}
			}
		} else{
			throw new FileNotFoundException("Mentioned file is not there to read...");
		}
	}
}
