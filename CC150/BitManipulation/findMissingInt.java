/** 5.7 An array A contains all the integers from 0 to n, except for one number which is
 *  missing. In this problem we cannot an entire integer in A with a single operation. 
 *  The elements of A are represented in binary, and the only operation we can use to 
 *  access them is "fetch the jth bit of A[i]", which takes constant time. Write code to 
 *  find the missing integer. Can yo do it in O(n) time?
 */
 
//8:03pm

/** I think
 *  for number n, there is log2(n)+1 bits, if check all the bits of an integer is sum of log2(i)+1
 *  suppose they are sorted in array A: last bit should be 0->1->0, find one not follow the pattern
 *  use O(n) to scan last bit [0], if n is odd, then cnt_1s - cnt_0s should = 0; if is even, cnt_1s - cnt_0s = -1 => determine odd or even number missing
 *  build number miss_number[0] = 0 or 1 depends on odd/even missing
 *  suppose odd missing, n is odd, scan [1] to see cnt_1s - cnt_0s should = 0; if n is even, cnt_1s - cnt_0s = -1, O(n/2)
 *  miss_number[1] = 0 or 1
 *  n = 7, odd 1 3 5 7, 3 missing
 *  01, 11,101, 111, 
 *  n = 6, odd 1 3 5
 *  01, 11, 101
 *  ...
 *  until miss_number is fully built
 *  termination condition: 
 *  	the missing 1s/0s cnt = 0
 */
 
public int findMissingInt(int[] A, int n, int bit_index, int miss_number){
	if(bit_index >= Math.log(n)/Math.log(2))
		return miss_number;
	int missing_number = 0;
	int cnt_1s = count(A, 1, bit_index);
	int cnt_0s = count(A, 0, bit_index);
	if(n%2 == 0){
		if(cnt_1s+1 > cnt_0s)//even are missing
			return findMissingInt(getPart(A, 0), n, bit_index+1, miss_number<<1);
		else{//odd missing
			return findMissingInt(getPart(A, 1), n, bit_index+1, miss_number<<1+1);
	}else{
		if(cnt_1s > cnt_0s)//even missing
			return findMissingInt(getPart(A, 0), n, bit_index+1, miss_number<<1);
		else//odd missing
			return findMissingInt(getPart(A, 1), n, bit_index+1, miss_number<<1+1);
	}
}

/**
 *  however the book use an ArrayList, saves much effort!
 */
private int[] getPart(int[] A, int parity){// get all the odd/even elements in array A
}

public int count(int[] A, int bit, bit_index){
	int cnt = 0;
	for(int i=0; i<A.length(); i++){
		if( getBit(A, i, bit_index) == bit)
			cnt++;
	}
	return cnt;
}
//8:47Pm

/** Book solution
 *  The same logic! I AM GENIOUS!
 *  the book simplifies the logic:
 *  	(n%2 == 0 && cnt_0s = cnt_1s) || ( n%2 != 0 && cnt_1s>cnt_0s) => miss_number<<1|0
 *  	(n%2 == 0 && cnt_0s > 1+cnt_1s) || ( n%2 != 0 && cnt_1s<cnt_0s) => miss_number<<1|1
 *  => 	if(cnt_1s >= cnt_0s){add 0 to miss_number}
 *  	else{ add 1}
 *  
 */
