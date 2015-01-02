/**The stepping number:
 *  A number is called as a stepping number if the adjacent digits are having a difference of 1. 
 *  For eg. 8,343,545 are stepping numbers. While 890, 098 are not. The difference between a ‘9’ 
 *  and ‘0’ should not be considered as 1.
 *  Given start number(s) and an end number(e) your function should list out all the stepping 
 *  numbers in the range including both the numbers s & e.
 */

/** I think:
 *  inclusive: [start, end]
 *  number to digits: a b c d e f
 *  while(i < digits_length-2){
 *  	if(Math.abs(digits[i] - digits[i+1]) != 1)
 *  		return false;
 *  	i++;
 *  }
 */
 
void printStepNumber(int start, int end){
	for(int number = start; number<=end; number++){
		if(isStepNumber(number))
			System.out.println(number);
	}
}

boolean isStepNumber(int number){
	String str= String.valueOf(number);
	for(int i = 0; i< str.length()-1;i++){
		int first = Integer.parseInt(str.substring(i,i+1));
		int second = Integer.parseInt(str.substring(i+1,i+2));
		if(Math.abs(first-second) != 1)
			return false;
	}
	return true;
}
/** above is too slow
 *  think it another way: rather than check every number, generate all the possible number
 *  now it reduce from O(n) to O(logN)
 */
 
static void main(String[] args){
	long start = 1;
	long end = 1000000000000;
	int s_len = (int)Math.Floor(Math.log(start)+1);
	int e_len = (int)Math.Floor(Math.log(end) + 1);
	for(int l=s_len;l<=e_len;l++){
		for(int i=1;i<10;i++){
			printStepNumber(start, end, l, i);
		}
	}
}

void printStepNumber(long start, long end, int len, int num){
	int last = num % 10;
	if(len == 0){
		if(num >= start && num <= end)
			System.out.println(num);
	}else if(last == 9)
		printStepNumber(start, end, len-1, num*10+last-1);
	else if(last == 0)
		printStepNumber(start, end, len-1, num*10+last+1);
	else{
		printStepNumber(start, end, len-1, num*10+last-1);
		printStepNumber(start, end, len-1, num*10+last+1);
	}
}