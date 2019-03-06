package resear.collection.hashtable.checkLogicForStoringValue.dto;

public class StateIntoOne implements CheckStateBasedHashcode{
	
	private int i;

	public StateIntoOne(int i) {
		super();
		this.i = i;
	}

	@Override
	public int hashCode() {
		return i;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return Integer.toString(i);
	}		
}
