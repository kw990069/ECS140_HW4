public class Delta extends Seq {
	
	protected int num;
	protected int initial;
	protected int delta;

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

	public int min() {
		if(this.delta >= 0)
			return this.initial;
		else
			return this.initial + (this.delta * (this.num - 1));
	} // end of min

	public DeltaIt createSeqIt () {
		return new DeltaIt(this);
	} // end of createSeqIt

} // end of class Delta
