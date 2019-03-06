package resear.collection.hashtable.checkLogicForStoringValue.dto;

public class StateIntoTwo implements CheckStateBasedHashcode{
	
	private int i;

	public StateIntoTwo(int i) {
		super();
		this.i = i;
	}

	@Override
	public int hashCode() {
		return i*2;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return Integer.toString(i);
	}		
}
