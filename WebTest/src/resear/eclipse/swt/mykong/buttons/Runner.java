package resear.eclipse.swt.mykong.buttons;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
 
public class Runner {
 
public static void main (String [] args) {
	Display display = new Display ();
	Shell shell = new Shell(display);
	shell.setText("SWT Button Example");
	
	new SWTButtonDemo(shell);
	
	shell.pack();
	shell.open();
	
	while (!shell.isDisposed ()) {
		if (!display.readAndDispatch ()) display.sleep ();
	}
	display.dispose ();
}
}
