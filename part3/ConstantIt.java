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

	public int next() {
		
		if(count != 0)
			count--;
		else {
			System.out.println("ConstantIt called past end");
			System.exit(1);
		} // else
		
		return val;

	} // end of next

} // end of ConstantIt class
