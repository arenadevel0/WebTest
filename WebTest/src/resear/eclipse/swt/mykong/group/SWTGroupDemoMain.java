package resear.eclipse.swt.mykong.group;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
 
public class SWTGroupDemoMain {
 
public static void main (String [] args) {
	Display display = new Display ();
	Shell shell = new Shell(display);
	shell.setText("SWT Group Example");
	
	Group group = new Group(shell, SWT.SHADOW_IN);
	group.setLocation(50, 50);
	
	group.setText("Group SHADOW_IN");
	
	Label label = new Label(group, SWT.NONE);
	label.setText("Label in Group");
	label.setLocation(20,20);
	label.pack();
	
	Button button = new Button(group, SWT.PUSH);
	button.setText("Push button in Group");
	button.setLocation(20,45);
	button.pack();
	
	group.pack();
	
	shell.setSize(300, 300);
	shell.open();
	
	while (!shell.isDisposed ()) {
		if (!display.readAndDispatch ()) display.sleep ();
	}
	display.dispose ();
}
}