public class Delta extends Seq {
	
	private int num;
	private int initial;
	private int delta;

	public Delta (int num, int initial, int delta) {
		this.num = num;
		if(this.num == 0)
			this.initial = this.delta = 0;
		else {
			this.initial = initial;
			this.delta = delta;
		}
	} // end of constructor

	public String toString () {
		return ("< " + this.num + " : " + this.initial + " &" + this.delta + " >");
	} // end of toString

} // end of class Delta
