public class Plus {


	public static Seq plus (Seq s1, Seq s2) {
		
		int size = 0, walker = 0, init = 0, 
			del = 0, preVal = 0, currVal = 0;
		boolean firstEle = true,
				firstDelta = true,
				isConstant = true,
				isDelta = true;
		
		// create iterators for the sequences
		SeqIt sItr1 = s1.createSeqIt();
		SeqIt sItr2 = s2.createSeqIt();
		
		while(sItr1.hasNext() && sItr2.hasNext()) {
			
			try {
				if(firstEle) {
					preVal = sItr1.next() + sItr2.next();
					size++;
					init = preVal;
					firstEle = false; // walked past first element
				} // if firstEle
				else {
					
					currVal = sItr1.next() + sItr2.next();
					
					/* check whether we can use Constant or Delta */
					
					//// Constant
					// note: isConstant is initially true, so
					//		 only modify when it's no longer true
					if(currVal != preVal && isConstant)
						isConstant = false;
					
					//// Delta
					if(firstDelta) {
						del = currVal - preVal;
						firstDelta = false;
					} // if firstDelta
					
					// only modify isDelta when the difference
					// between consecutive elements is inconsistent
					if((del != (currVal - preVal)) && isDelta)
						isDelta = false;
					
					/* increments for looping */
					size++;
					preVal = currVal;
					
				} // else !firstEle				
				
			} // try
			catch (UsingIteratorPastEndException e) { break; } // catch
			
		} // while both sequences still have elements
		
		
		/* decide which type of sequence to return */
		
		if(isConstant) {
			
			return new Constant(size, init);
			
		} // returns Constant sequence
		else if(isDelta) {
			
			return new Delta(size, init, del);
			
		} // returns Delta sequence
		else {
			
			// prepare dynamic array for Jumble seq
			int [] sum = new int[size];
			
			// reuses previously declared iterator
			sItr1 = s1.createSeqIt();
			sItr2 = s2.createSeqIt();
			
			// walks sequences to add corresponding elements
			while(walker < size) {
				
				try {
					sum[walker] = sItr1.next() + sItr2.next();
					walker++;
				} // try
				catch(UsingIteratorPastEndException e) { break; } // catch
				
			} // while
			
			return new Jumble(sum);
			
		} // returns Jumble sequence
			
	} // end of plus (s1, s2)

 /*********** from part 6-7

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

	public static Seq plus (Constant c1, Delta d1) {
		
		int size, // shorter length of the two sequence
		    init; // new initial value for the resulting sequence
		
		// determine the shorter length of the two seq
		if(c1.num <= d1.num)
			size = c1.num;
		else
			size = d1.num;

		// find new initial value
		init = d1.initial + c1.value;

		// return a Delta object
		// note: delta of new sequence doesn't change
		return	new Delta(size, init, d1.delta);

	} // end of plus (c1, d1)

	public static Seq plus (Delta d1, Constant c1) {
		
		// same code as previous function
		return plus(c1, d1);	
	
	} // end of plus (d1, c1)

	public static Seq plus (Constant c1, Jumble j1)	{
		
		int size, 	// shorter length of the two sequences
		    walker = 0;	// index walker for array

		// find short length
		if(c1.num <= j1.values.length)
			size = c1.num;
		else
			size = j1.values.length;

		// add corresponding elements
		int [] sum = new int[size];
		while(walker < size) {
			sum[walker] = j1.values[walker] + c1.value;
			walker++;
		} // while 
	
		// return Jumble sequence
		return new Jumble(sum);

	} // end of plus (c1, j1)

	public static Seq plus (Jumble j1, Constant c1) {
		
		// same code as previous function
		return plus(c1, j1);

	} // end of plus (j1, c1)

	public static Seq plus (Delta d1, Jumble j1) {
		
		int size, 	// shorter length of the two sequences
		    walker = 0, // index wakler for array
		    dVal;	// current value in delta, d1		
	
		// detemine the shorter length
		if(d1.num <= j1.values.length)
			size = d1.num;
		else
			size = j1.values.length;

		// add corresponding elements
		int [] sum = new int[size];
		dVal = d1.initial;
		while(walker < size) {
			sum[walker] = j1.values[walker] + dVal;
			dVal += d1.delta;
			walker++;
		} // while
		
		// return Jumble sequence
		return new Jumble(sum);
	} // end of plus (d1, j1)

	public static Seq plus (Jumble j1, Delta d1) {

		// same code as previous function
		return plus(d1, j1);

	} // end of plus (j1, d1)


 *****/ // from part 6 - 7


} // end of class Plus





