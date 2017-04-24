package resear.logger.prac;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

public class LoggerPracUtil {

	public static void doView(String path){
		if(System.getProperty("os.name").contains("Win")){
			try {
				Desktop.getDesktop().open(new File(path));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
