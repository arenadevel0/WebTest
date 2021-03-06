package resear.eclipse.wizard;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.ListIterator;

import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.ILazyTreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

/**
 * A simple TreeViewer to demonstrate usage of an ILazyContentProvider.
 * 
 */
public class Snippet047VirtualLazyTreeViewer {
	private class MyContentProvider implements ILazyTreeContentProvider {
		private TreeViewer viewer;
		private IntermediateNode[] elements;

		public MyContentProvider(TreeViewer viewer) {
			this.viewer = viewer;
		}

		public void dispose() {

		}

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			this.elements = (IntermediateNode[]) newInput;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.jface.viewers.ILazyTreeContentProvider#getParent(java.lang.Object)
		 */
		public Object getParent(Object element) {
			if (element instanceof LeafNode)
				return ((LeafNode) element).parent;
			return elements;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.jface.viewers.ILazyTreeContentProvider#updateChildCount(java.lang.Object,
		 *      int)
		 */
		public void updateChildCount(Object element, int currentChildCount) {
			
			int length = 0;
			if (element instanceof IntermediateNode) {
				IntermediateNode node = (IntermediateNode) element;
				length =  node.children.length;
			} 
			if(element == elements)
				length = elements.length;
			viewer.setChildCount(element, length);
			

		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.jface.viewers.ILazyTreeContentProvider#updateElement(java.lang.Object,
		 *      int)
		 */
		public void updateElement(Object parent, int index) {
			
			Object element;
			if (parent instanceof IntermediateNode) 
				element = ((IntermediateNode) parent).children[index];
			
			else
				element =  elements[index];
			viewer.replace(parent, index, element);
			updateChildCount(element, -1);
			
		}

	}

	public Snippet047VirtualLazyTreeViewer(Shell shell) {
		final CheckboxTreeViewer v = new CheckboxTreeViewer(shell, SWT.VIRTUAL | SWT.BORDER);
		v.setLabelProvider(new LabelProvider());
		v.setContentProvider(new MyContentProvider(v));
		v.setUseHashlookup(true);
		IntermediateNode[] model = createModel();
		v.setInput(model);
		v.getTree().setItemCount(model.length);
		
		// When user checks a checkbox in the tree, check all its children
	    v.addCheckStateListener(new ICheckStateListener() {
	      public void checkStateChanged(CheckStateChangedEvent event) {
	        // If the item is checked . . .
	        if (event.getChecked()) {
	          // . . . check all its children
	          v.setSubtreeChecked(event.getElement(), true);
	        } else {
	        	v.setSubtreeChecked(event.getElement(), false);
	        }
	        Object[] objArr = v.getCheckedElements();
	        
	        removeParentWithListIterator(objArr);
//		    removeParentWithArray(objArr);
	      }

			@SuppressWarnings("unused")
			public void removeParentWithArray(Object[] objArr) {
				long oldTime=System.currentTimeMillis();
				Object[] objArr1 ;
		        objArr1 = new Object[objArr.length];
				for(int i=0,j=0;i<objArr.length;i++) {
					if(!(objArr[i] instanceof IntermediateNode)){
						objArr1[j]=objArr[i];
						j++;
					}
				}
			    for(Object object:objArr1){
			    	System.err.println(object);
			    }
			    long newTime=System.currentTimeMillis();
			    System.out.println("Total time taken with array:"+(newTime-oldTime));
			}

			public void removeParentWithListIterator(Object[] objArr) {
				long oldTime=System.currentTimeMillis();
				LinkedList<Object> list = new LinkedList<Object>(Arrays.asList(objArr));
		        ListIterator<Object> listIterator = list.listIterator();
		        while (listIterator.hasNext()) {
					Object object = (Object) listIterator.next();
					if(object instanceof IntermediateNode)
						listIterator.remove();
				}
		        
		        listIterator = list.listIterator();
		        while (listIterator.hasNext()) {
					Object object = (Object) listIterator.next();
					System.err.println(object);
				}
		        long newTime=System.currentTimeMillis();
			    System.out.println("Total time taken with linked list:"+(newTime-oldTime));
			}
	    });

	}

	private IntermediateNode[] createModel() {
		IntermediateNode[] elements = new IntermediateNode[10];

		for (int i = 0; i < 10; i++) {
			elements[i] = new IntermediateNode(i);
			elements[i].generateChildren(10);
		}

		return elements;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setLayout(new FillLayout());
		new Snippet047VirtualLazyTreeViewer(shell);
		shell.open();

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}

		display.dispose();

	}

}

class LeafNode {
	public int counter;
	public IntermediateNode parent;

	public LeafNode(int counter, IntermediateNode parent) {
		this.counter = counter;
		this.parent = parent;
	}

	public String toString() {
		return "LeafNode " + this.counter;
	}
}

class IntermediateNode {
	public int counter;
	public LeafNode[] children = new LeafNode[0];

	public IntermediateNode(int counter) {
		this.counter = counter;
	}

	public String toString() {
		return "IntermediateNode " + this.counter;
	}

	public void generateChildren(int i) {
		children = new LeafNode[i];
		for (int j = 0; j < i; j++) {
			children[j] = new LeafNode(j, this);
		}

	}
}
