public class DeltaIt implements SeqIt {
	
	private int count,
		    initial,
		    delta,
		    currVal;

	public DeltaIt (Delta d) {
		this.count = d.num;
		this.initial = d.initial; // assume we start from the beginning
		this.delta = d.delta;
	} // end of constructor
	
	public boolean hasNext() {
		if(count != 0)
			return true;
		else
			return false;
	} // end of hasNext

	public int next() {

		if(count == 0) {
			System.out.println("DeltaIt called past end");
			System.exit(1);		
		} // if

		count--;
		currVal = initial;	
		initial += delta;

		return currVal;
			
	} // end of next

} // end of class DeltaIt
