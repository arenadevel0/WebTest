package resear.eclipse.swt.mykong.group;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;

public class SWTGroupDemo extends Composite
{
	public SWTGroupDemo(Composite parent)
	{
		super(parent, SWT.NONE);
		this.setSize(300, 300);
		
		Group group = new Group(this, SWT.SHADOW_ETCHED_IN);
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
		
	}
}
