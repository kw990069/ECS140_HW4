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

} // end of class Jumble
