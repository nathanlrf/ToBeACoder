/** 5.5 Write a function to determine the number of bits you would need to flip to 
 *  convert interger A to integer B.
 *  Eg.
 *  	Input: 29(or: 11101), 15(or: 01111)
 *  	Output: 2
 */
 
//11:23

/** I think
 *  convert number to binary string, scan the string, count the difference between them
 *  need to supplement 0 before the smaller number if they don't have same length
 */
 
public int BitsToFlip(int A, int B){
	String bin_A = Integer.toBinaryString(A);
	String bin_B = Integer.toBinaryString(B);
	int cnt = Math.abs(bin_A.length() - bin_B.length());
	if(bin_A.length() > bin_B.length()){
		for(int i=bin_B.length(),int j=bin_A.length(); i>=0; i--,j--){
			if(bin_A.charAt(i) != bin_B.charAt(j))
				cnt++;
		}
	}else{
		for(int i=bin_B.length(),int j=bin_A.length(); j>=0; i--,j--){
			if(bin_A.charAt(i) != bin_B.charAt(j))
				cnt++;
		}
	}
	return cnt;
}

//11:34

/** Book solution
 *  Rather than using strings, book uses bit manipulation XOR
 */

//my understanding
public int BitsToFlip(int A, int B){
	int xor = A^B;
	int cnt = 0;
	while(xor != 0){
		if(xor & 1== 1)
			cnt++;
		xor >>= 1;
	}
	return cnt;
}

//book initial version
public int BitsToFlip(int a, int b){
	int cnt =0;
	for(int c = a^b; c!=0; c>>=1){
		cnt += c&1;//save me from if condition!
	}
	return cnt;
}

//book better version
public int BitsToFlip(int a, int b){
	int cnt = 0;
	/* c = 10110, c-1 = 10101, 
	 * if c[0] = 0, then c&(c-1) will clear all the bits until [p], where c[p] =1, thus consume a 1 in c
	 * if c[0] = 1, then c&(c-1) will consume only the last bit
	 */
	for(int c = a^b; c!= 0; c = c&(c-1)){
		cnt++;
	}
	return cnt;
}