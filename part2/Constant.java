public class Constant extends Seq {
	
	private int num;
	private int value;

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

} // end of class Constant
