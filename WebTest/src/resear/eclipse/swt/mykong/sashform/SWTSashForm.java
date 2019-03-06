package resear.eclipse.swt.mykong.sashform;

import java.io.IOException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
 
public class SWTSashForm
{
	public static void main (String [] args) {
		final SWTSashForm swtSashForm = new SWTSashForm();
		
		System.out.println("Type:\n\'1\' to run two SWT displays with single thread\n\'2\' to run two SWT displays with multi threads");
		char c;
		try {
			c = (char) System.in.read();
			if('1'==c)
				//with single thread
				twoDisplayWithSingleThread(swtSashForm);
			else if ('2'==c)
//				with multi thread
				twoDisplayWithMultiThread(swtSashForm);
			else{
				System.err.println(new RuntimeException("Go get a new glass").getMessage());
				throw new RuntimeException("Go get a new glass");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} 		
	}

	public static void twoDisplayWithMultiThread(final SWTSashForm swtSashForm) {
		Thread thread1 = new Thread(new Runnable() {
			public void run() {
				swtSashForm.sashFormInsideShell();
			}
		});
		
		Thread thread2 = new Thread(new Runnable() {
			public void run() {
				swtSashForm.sashFormInsideSashForm();
			}
		});
		thread1.start();
		thread2.start();
	}

	public static void twoDisplayWithSingleThread(final SWTSashForm swtSashForm) {
		swtSashForm.sashFormInsideShell();
		swtSashForm.sashFormInsideSashForm();
	}

	public void sashFormInsideShell() {
		Display display = new Display ();
		Shell shell = new Shell(display);
		shell.setText("SashFormInsideShell");
	 
		shell.setLayout(new FillLayout());

	    // Create the SashForm with HORIZONTAL
	    SashForm sashForm1 = new SashForm(shell, SWT.HORIZONTAL);
	    new Button(sashForm1, SWT.PUSH).setText("Left");
	    new Button(sashForm1, SWT.PUSH).setText("Right");
		
	    // Create the SashForm with VERTICAL
	    SashForm sashForm2 = new SashForm(shell, SWT.VERTICAL);
	    new Button(sashForm2, SWT.PUSH).setText("Up");
	    new Button(sashForm2, SWT.PUSH).setText("Down");
		
		shell.open();
	 
		while (!shell.isDisposed ()) {
			if (!display.readAndDispatch ()) display.sleep ();
		}
		display.dispose ();
	}

	public void sashFormInsideSashForm() {
		Display display = new Display ();
		Shell shell = new Shell(display);
		shell.setText("SashFormInsideSashForm");
	 
		shell.setLayout(new FillLayout());

		// Create the SashForm with SMOOTH
	    SashForm sashForm = new SashForm(shell, SWT.HORIZONTAL);
		
	    // Create the SashForm with HORIZONTAL
	    SashForm sashForm1 = new SashForm(sashForm, SWT.HORIZONTAL);
	    new Button(sashForm1, SWT.PUSH).setText("Left");
	    new Button(sashForm1, SWT.PUSH).setText("Right");
		
	    // Create the SashForm with VERTICAL
	    SashForm sashForm2 = new SashForm(sashForm, SWT.VERTICAL);
	    new Button(sashForm2, SWT.PUSH).setText("Up");
	    new Button(sashForm2, SWT.PUSH).setText("Down");
		
		shell.open();
	 
		while (!shell.isDisposed ()) {
			if (!display.readAndDispatch ()) display.sleep ();
		}
		display.dispose ();
	}

}