public class Jumble extends Seq {

	private int [] values;

	public Jumble (int [] values) {
		this.values = new int[values.length];
		System.arraycopy(values, 0, this.values, 0, values.length);
	} // end of constructor
	
	public String toString () {
		
		String temp = "{ " + this.values.length + " :";
		for(int i: this.values)
			temp += " " + i;
		return temp + " }";

	} // end of toString
	
	public int min() {
		int min = 999999; // inital min to a really big number
		if(this.values.length == 0)
			min = 0;
		else {
			for(int i: this.values) {
				if(i < min)
					min = i;
			} // for
		} // else
		return min;
			
	} // end of min

} // end of class Jumble
