public class JumbleIt implements SeqIt {

	private Jumble obj;
	private int walker, val;
	
	public JumbleIt (Jumble j) {
		this.obj = j;
		this.walker = 0;
	} // end of constructor

	public boolean hasNext() {

		if(walker != obj.values.length)
			return true;
		else
			return false;

	} // end of hasNext

	public int next() {
	
		if(walker == obj.values.length) {
			System.out.println("JumbleIt called past end");
			System.exit(1);
		} // if
		
		val = obj.values[walker];
		walker++;
		return val;

	} // end of next

} // end of class JumbleIt
