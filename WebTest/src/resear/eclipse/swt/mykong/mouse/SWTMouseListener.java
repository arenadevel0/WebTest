package resear.eclipse.swt.mykong.mouse;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
 
public class SWTMouseListener {
 
public static void main (String [] args) {
	Display display = new Display ();
	Shell shell = new Shell(display);
 
	//push button
	Button pushButton = new Button(shell, SWT.PUSH);
	pushButton.setLocation(50, 50);
	pushButton.setText("Im a Push Button");
	pushButton.pack();
 
	pushButton.addMouseListener(new MouseListener()
	{
		public void mouseDown(MouseEvent e)
		{
			System.out.println("Mouse Down.");
		}
		public void mouseUp(MouseEvent e)
		{
			System.out.println("Mouse Up.");
		}
		public void mouseDoubleClick(MouseEvent e)
		{
			System.out.println("Mouse Double click.");
		}
	
	});
	
	shell.setSize(500,500);
	shell.open ();
	while (!shell.isDisposed ()) {
		if (!display.readAndDispatch ()) display.sleep ();
	}
	display.dispose ();
}
}
