package resear.collection.hashtable.checkLogicForStoringValue.dto;

public class SingleState implements CheckStateBasedHashcode{
	
	private int i;
	

	public SingleState(int i) {
		super();
		this.i = i;
	}

	@Override
	public int hashCode() {
		return 2;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return Integer.toString(i);
	}		
}
