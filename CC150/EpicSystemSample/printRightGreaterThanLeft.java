/** Given n. Generate all numbers with number of digits equal to n, 
 *  such that the digit to the right is greater than the left digit (ai+1 > ai). 
 *  E.g. if n=3 (123,124,125,……129,234,…..789)
 */
 
/** I think:
 *  in recursion:
 *  1. start from 9, single digit
 *  2. find all the smaller number than the most significant one, append it in the front
 *  3. termination: number of digits == n or there is no smaller numbers than the most significant digit: significant = 1 && number of digits < n
 */

 /**
 *  @param [in] n       n above
 *  @param [in] dig_num number of digits
 *  @param [in] number  number to print
 */
	public static void main(String[] args){
		for(int i=9; i>0;i--){
			printRightGreaterThanLeft(3,1,i);
		}
	}
	
	public static void printRightGreaterThanLeft(int n, int dig_num, int number){
		if(dig_num == n){
			System.out.println(number);
			return;
		}
		
		int init = (int) (number/(Math.pow(10,dig_num-1))-1);
		if(init < 1 && dig_num < n)
			return;
//		System.out.println("init "+init+" dig_num: "+dig_num);
		// found possible candidate
		for(int cand = init; cand>0; cand--){
			int num = number + (int)(cand*Math.pow(10, dig_num));
			int d_num = dig_num+1;
			printRightGreaterThanLeft(n, d_num, num);
		}
	}