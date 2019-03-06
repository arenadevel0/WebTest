package resear.eclipse.swt.mykong;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class HelloWorld {

	public static void main(String[] args) {		
		Display display = new Display();
		Shell shell = new Shell(display);
		
		Text text = new Text(shell, SWT.NONE);
		text.setText("Hello World SWT");
		text.pack();
		
		shell.pack();
		shell.open();
		while (!shell.isDisposed()) {
			if(!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}

}
