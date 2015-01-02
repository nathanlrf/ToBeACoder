/** Colorful Number:
 *  A number can be broken into different sub-sequence parts. Suppose, 
 *  a number 3245 can be broken into parts like 3 2 4 5 32 24 45 324 245. 
 *  And this number is a colorful number, since product of every digit of 
 *  a sub-sequence are different. That is, 3 2 4 5 (3*2)=6 (2*4)=8 (4*5)=20 (3*2*4)= 24 (2*4*5)= 40
 *  But 326 is not a colorful number as it generates 3 2 6 (3*2)=6 (2*6)=12.
 *  You have to write a function that tells if the given number is a colorful number or not.
 *  http://www.careercup.com/question?id=4863869499473920
 */

/** I think:
 *  convert number to strings, get substring with different length: 1~length-1
 */

boolean isColorfulNumber(int number){
	String num_str = String.valueOf(number);
	HashSet<Integer> product_set = new HashSet<Integer>();
	String sub;
	int product;
	
	for(int str_len = 1; str_len<num_str.length();str_len++){
		for(int index = 0; index + str_len<num_str.length(); index++){
			sub = num_str.substring(index, index+str_len);
			product = getProduct(Integer.parseInt(sub));
			if(product_set.contains(product))
				return false;
			product_set.add(product);
		}
	}
	return true;
}

int getProduct(int num){
	if(num<10 && num >=0)
		return num;
	int product = 1;
	int digit = 0;
	while(num > 0){
		digit = num%10;
		product *= digit;
		num = num/10;
	}
	return product;
}