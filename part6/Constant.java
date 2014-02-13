public class Constant extends Seq {
	
	protected int num;
	protected int value;

	public Constant(int num, int value){
		this.num = num;
		if(this.num == 0)
			this.value = 0;
		else
			this.value = value;	
	} // end of constructor

	public String toString() {
		return ("[ " + this.num + " : " + this.value + " ]");
	} // end of toString

	public int min() {
		return value;
	} // end of min

	public ConstantIt createSeqIt () {
		return new ConstantIt(this);
	} // end of createSeqIt

} // end of class Constant
