/** 5.1 You are givn two 32-bit numbers, N and M, and two bit positions, i and j.
 *  Write a method to insert M into N such that  M starts at bit j and ends at bit i.
 *  You can assume that the bits j through i have enough space to fit all of M.
 *  That is, if M = 10011, you can assume that there are at least 5 bits between j and i.
 *  You would not, for example, have j=3 and i=2, because M could not fully fit between 
 *  bit 3 and bit 2.
 *  eg.
 *  	Input: N=10000000000, M=10011, i=2, j=6
 *  	Output: N = 10001001100
 */
 
//10:21PM

/** I think
 *  clear N[j:i], set N[j:i] to M
 *  clear need a mask to be 1..1[j]0..0[i]1...1
 */
 
public int insertNumber(int N, int M, int i, int j){
	int mask = (-1<<(j+1)) | ~(-1<<i);
	N = N & mask;
	N = N | M<<(i+1);
	return N;
}

//10:56

//caution! use "|" , not "+"!