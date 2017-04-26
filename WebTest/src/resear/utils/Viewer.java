package resear.utils;

import java.awt.Desktop;
import java.io.IOException;
import java.nio.file.Path;

public class Viewer {

	private volatile static Viewer viewer;
	
	private Viewer(){
		
	}
	
	public static Viewer getViewerObj(){
		if(viewer==null){
			synchronized (Viewer.class) {
				if(viewer==null){
					viewer = new Viewer();
				}
			}
		}
		return viewer;
	}
	
	public void viewFile(Path path){
		if(System.getProperty("os.name").contains("Win")){
			if(Desktop.isDesktopSupported()){
				try {
					Desktop.getDesktop().open(path.toFile());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
