/** 5.3 Given a positive integer, print the next smallest and the next largest number
 *  that have the same number of 1 bits in their binary representation.
 */
 
//10:01PM

/** I think:
 *  	1. decimal -> binary, count 1s
 *  	2. option 1: brutal force increase/decrease number until number of 1s are matched
 */
 
//brutal search

public static void printNext(int number){
	if(number < 0)
		return;
	int num_of_1 = countBinaryOnes(number);
	for(int i=number-1; ; i--){
		if(num_of_1 == countBinaryOnes(i)){
			System.out.println("next smallest: "+i);
			break;
		}
	}
	for(int j= number+1; ;j++){
		if(num_of_1 == countBinaryOnes(j)){
			System.out.println("next biggest: "+j);
			break;
		}
	}
}

private int countBinaryOnes(int number){
	int cnt = 0;
	String binary = Integer.toBinaryString(number);
	for(int i=0;i<binary.length();i++){
		if(binary.charAt(i) == '1')
			cnt++;
	}
	return cnt;
}
//10:15PM

/** think a better way
 *  10 -> 1010
 *  12 -> 1100
 *  smaller: 1010, 0110
 *  bigger: 10100
 *  may be to find the least significant bit [i] = 0 and [i+1] = 1
 *  	to smaller: i+1 right shift 1 bit,
 *  	to bigger: find the least significant bit [i] = 0 and [i-1] = 1, i-1 left shift
 *  8 -> 100
 *  	smaller: [2] shift to [1]
 *  	bigger: [2] shift to [3]
 *  Conclusion:
 *  	for 10110011:
 *  	next smaller: 1010111; find the rightmost bit [i] that [i]=1 && [i-1]=0, swap, then shift all the 1s in the right to left 
 *  	next larger: 1100111; find the rightmost bit [i] that [i]=1 && [i+1]=0, swap, then shift all the 1s in the right of [i] to right 
 *  	because we want the next larger
 */
 
//improved
public static void printNext(int number){
	if(number < 0)
		return;	
	String bin_str = Integer.toBinaryString(number);
	String larger = "";
	String smaller = "";
	//find rightmost bit with certain property
	//to get smaller find [i]=0 and [i+1]=1, swap
	//to get larger find [i]=1 and [i+1]=0, swap, also need to shift all the 1s to right
	for(int i=bin_str.length()-1; i>0; i--){
		if(!smaller.isEmpty() && !larger.isEmpty()){
			break;
		}
		else {
			if(smaller.isEmpty() && bin_str.charAt(i) == '0' && bin_str.charAt(i-1) == '1'){
				String smaller = bin_str.substring(0,i-1)+"01"+bin_str.substring(i+1);
				System.out.println(Integer.parseInt(smaller, 2));
			}if(bigger.isEmpty() && bin_str.charAt(i) == '1' && bin_str.charAt(i-1) == '0'){//
				String larger = bin_str.substring(0,i-1)+"10"+bin_str.substring(i+1);
				System.out.println(Integer.parseInt(larger, 2));
			}
		}
	}
	//for a binary like 11100, have to extend its bits to 101100
	if(larger.isEmpty()){
		larger = "10"+bin_str.substring(1);
		System.out.println(Integer.parseInt(larger, 2));
	}
}

/** Book solution
 *  improved inspired by the book
 */
public int getNextSmaller(int n){
	int c = n;
	int c0 = 0;
	int c1 = 0;
	while( c&1 == 1 ){//count 1s
		c1++;
		c>>=1;
	}
	if(c == 0)//cannot get smaller than 1....1 with no 0s
		return -1;
	while( (c != 0) && (c&1 == 0)){//count 0s
		c0++;
		c>>=1;
	}
	//reach the position of [i] = 1, [i-1] =0, here i = c0+c1
	//swap [i-1] and [i], shift c1 1s to left
	//clear [i:0]
	int p = c0 + c1;
	n &= ((~0)<<(p+1));//1...10...0, clear [p:0]
	//insert c1+1 1s next to p(count 1 on [p]), so left p - (c1-1) = c0-1 0s
	int mask = (1<<(c1+1)-1) << (c0-1);
	return n|mask;
	
}

public int getNextLarger(int n){
	int c = n;
	int c0 = 0;
	int c1 = 0;
	//find [p]=0 && [p-1] =1
	while( c&1 == 0 && (c != 0)){
		c0++;
		c >>= 1;
	}
	while( c&1 == 1){
		c1++;
		c >>= 1;
	}
	if( c0 + c1 == 31 || c0 + c1 == 0)//number is already 32-bit, cannot extend to get bigger or is 0
		return -1;
	int p = c0+c1;//[p]=0
	//set [p] = 1, left c1-1 1s, 
	n |= (1<<p);
	n &= ~((1<<p)-1);//clear [p-1:0]
	return n|((1<<c1-1)-1);
}