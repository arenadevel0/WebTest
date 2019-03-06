package resear.eclipse.wizard;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.IViewActionDelegate;
import org.eclipse.ui.IViewPart;

public class ResourceManagerViewActionDelegate implements IViewActionDelegate {
    private IViewPart view;

    public void init(IViewPart view) {
             this.view = view; // cache the view part, this will be used in run action
                                 // to fetch the parent shell for dialog
    }

    public void run(IAction action) {
    	CaptureEmployeeInfomrationWizard wizard = new CaptureEmployeeInfomrationWizard();
        WizardDialog dialog = new WizardDialog(view.getSite().getShell(), wizard);
        dialog.create();
        dialog.open();
    }
 
   public void selectionChanged(IAction action, ISelection selection) {}
}