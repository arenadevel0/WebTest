package resear.eclipse.swt.mykong.buttons;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;

public class SWTButtonDemo extends Composite
{
	public SWTButtonDemo(Composite parent)
	{
		super(parent, SWT.NONE);
		this.setSize(500, 500);
		
		Group group = new Group(this, SWT.SHADOW_ETCHED_IN);
		group.setLocation(50, 50);
		
		group.setText("Group SHADOW_IN");
		
		//push button
		Button pushButton = new Button(group, SWT.PUSH);
		pushButton.setLocation(50, 50);
		pushButton.setText("Im a Push Button");
		pushButton.pack();
	 
		//arrow button
		Button arrowLeftButton = new Button(group, SWT.ARROW | SWT.LEFT);
		arrowLeftButton.setLocation(50, 100);
		arrowLeftButton.setText("LEFT");
		arrowLeftButton.pack();
		
		Button arrowRightButton = new Button(group, SWT.ARROW | SWT.RIGHT);
		arrowRightButton.setLocation(80, 100);
		arrowRightButton.setText("RIGHT");
		arrowRightButton.pack();
		
		Button arrowUpButton = new Button(group, SWT.ARROW | SWT.UP);
		arrowUpButton.setLocation(110, 100);
		arrowUpButton.setText("UP");
		arrowUpButton.pack();
		
		Button arrowDownButton = new Button(group, SWT.ARROW | SWT.DOWN);
		arrowDownButton.setLocation(140, 100);
		arrowDownButton.setText("DOWN");
		arrowDownButton.pack();
		
		//toggle
		Button toggleNotPressedButton = new Button(group, SWT.TOGGLE);
		toggleNotPressedButton.setSelection(false);
		toggleNotPressedButton.setLocation(50, 150);
		toggleNotPressedButton.setText("Button Not Pressed");
		toggleNotPressedButton.pack();
		
		Button togglePressedButton = new Button(group, SWT.TOGGLE);
		togglePressedButton.setSelection(true);
		togglePressedButton.setLocation(170, 150);
		togglePressedButton.setText("Button Pressed");
		togglePressedButton.pack();
		
		//check box
		Button[] checkBoxs = new Button[3];
		checkBoxs[0] = new Button(group, SWT.CHECK);
		checkBoxs[0].setSelection(true);
		checkBoxs[0].setText("Choice 1");
		checkBoxs[0].setLocation(50,200);
		checkBoxs[0].pack();
		
		checkBoxs[1] = new Button(group, SWT.CHECK);
		checkBoxs[1].setText("Choice 2");
		checkBoxs[1].setLocation(120,200);
		checkBoxs[1].pack();
		
		checkBoxs[2] = new Button(group, SWT.CHECK);
		checkBoxs[2].setText("Choice 3");
		checkBoxs[2].setLocation(190,200);
		checkBoxs[2].pack();
		
		//radio
		Button[] radioButtons = new Button[3];
		radioButtons[0] = new Button(group, SWT.RADIO);
		radioButtons[0].setSelection(true);
		radioButtons[0].setText("Choice 1");
		radioButtons[0].setLocation(50,250);
		radioButtons[0].pack();
		
		radioButtons[1] = new Button(group, SWT.RADIO);
		radioButtons[1].setText("Choice 2");
		radioButtons[1].setLocation(120,250);
		radioButtons[1].pack();
		
		radioButtons[2] = new Button(group, SWT.RADIO);
		radioButtons[2].setText("Choice 3");
		radioButtons[2].setLocation(190,250);
		radioButtons[2].pack();
		
		group.pack();
		
	}
}
