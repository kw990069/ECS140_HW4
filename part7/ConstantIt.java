public class ConstantIt implements SeqIt {
	
	private int count, val;	

	public ConstantIt (Constant s) {
		this.count = s.num;
		this.val = s.value;
	} // end of constructor

	public boolean hasNext() {

		if(count != 0)
			return true;
		else
			return false;
		
 	} // end of hasNext

	public int next() throws UsingIteratorPastEndException  {
		
		if(count != 0)
			count--;
		else {
			// throw exception when call past end
			throw new UsingIteratorPastEndException();
		} // else
		
		return val;

	} // end of next

} // end of ConstantIt class
