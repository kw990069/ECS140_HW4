public class JumbleUser  {

	public static int lengthLongestNDCSS1 (Jumble j) {
		// NDCSS = non-deceasing, contiguous subsequence
		JumbleIt jItr = new JumbleIt(j);
		int length = 0, preVal = 0, currVal = 0, maxLength = 0;
		boolean first = true; // is it the first element?
		
		// Jumble is empty
		if(!jItr.hasNext())
			return 0; 
		
		// Jumble is not empty
		while(jItr.hasNext()) {
			try {
				if(first) {
					preVal = jItr.next();
					length++;
					first = false;
				} // if first
				else if (preVal <= (currVal = jItr.next())) {
					// non-decreasing, continue to count
					preVal = currVal;
					length++;
				} // prev <= next
				else {
					if(length > maxLength)
						maxLength = length;
					length = 1; // start counting from this ele
					preVal = currVal;
				} // else
			} // try
			catch(UsingIteratorPastEndException e) {
				// do nothing	
			} // catch

		} // while jumble still has element
		
	
		// special condition
		// length of the array == longest NDCSS
		if(length > maxLength)
			maxLength = length;

		return maxLength;	

	} // end of lengthLongestNDCSS1

	public static int lengthLongestNDCSS2(Jumble j) {

		// computes same result as lengthLongestNDCSS1, but
		// cannot use Jumble's hasNext() method

		JumbleIt jItr = new JumbleIt(j);
		int length = 0, preVal = 0, currVal = 0, maxLength = 0;
		boolean first = true; // is this the first element?
		
		while(true) { // loop until break
			try {
				if(first) {
					preVal = jItr.next();
					length++;
					first = false;
				} // if first
				else if(preVal <= (currVal = jItr.next())) {
					// non-decreasing, continue to count
					preVal = currVal;
					length++;
				} // else if prev <= next
				else {
					if(length > maxLength)
						maxLength = length;
					length = 1; // start counting from this ele
					preVal = currVal;
				} // else
			} // try
			catch(UsingIteratorPastEndException e) {
				break;	
			} // catch
		} // while true						

		// length of the array == longest NDCSS
		if(length > maxLength)
			maxLength = length;

		return maxLength;

	} // end of lengthLongestNDCSS2

} // end of JumbleUser class



