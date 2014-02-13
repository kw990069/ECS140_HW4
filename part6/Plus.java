public class Plus {

	public static Seq plus (Constant c1, Constant c2) {

		int size, // the shorter length of the two sequences 
		    sum;  // the sum of the values from corr element of the two seq
		
		// determine which sequence has the shorter length
		if(c1.num <= c2.num)
			size = c1.num;
		else
			size = c2.num;

		// find sum of corresponding elements from c1 and c2
		sum = c1.value + c2.value;

		// return a new sequence object
		return new Constant(size, sum);
			
	} // end of plus (c1, c2)

	public static Seq plus (Delta d1, Delta d2) {
		
		int size, // the shorter length of the two sequences
		    init, // the initial of the resulting sequence
		    del;  // the delta of the resulting sequence

		// determines which sequence has the shorter length
		if(d1.num <= d2.num)
			size = d1.num;
		else
			size = d2.num;

		// determines the new initial value and new delta
		init = d1.initial + d2. initial;
		del = d1.delta + d2.delta;

		// return a new sequence object
		return new Delta(size, init, del);
		
	} // end of plus (d1, d2)

	public static Seq plus (Jumble j1, Jumble j2) {
		
		int size,   	// the shorter length of the two sequences
		    walker = 0; // index walker for the arrays 
		
		// determines which sequence has the shorter length
		if(j1.values.length <= j2.values.length)
			size = j1.values.length;
		else
			size = j2.values.length;
		
		// sum the arrays
		int [] sum = new int[size];
		
		while(walker < size) {
			sum[walker] = j1.values[walker] + j2.values[walker];
			walker++;
		} // while
		
		return new Jumble(sum);
		
	} // end of plus (j1, j2)

} // end of class Plus





