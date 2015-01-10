/** Find the seed of a number.
 *  Eg : 1716 = 143*1*4*3 =1716 so 143 is the seed of 1716. 
 *  find all possible seed for a given number.
 */
 
/** I think
 *  start with the biggest factor of the number, then get the digit product of the factor
 *  if the product * factor == number, factor is seed
 */
 
void findSeed(int number){
	boolean isPrime = false;
	for(int i = (int)Math.sqrt(number); i> 0; i++){
		if(number % i == 0 || isSeed(number, factor))
			System.out.println(i);
	}
}

boolean isSeed(int number, int factor){
	int product = 1;
	String str = String.valueOf(factor);
	for(int i=0;i<str.length(); i++){
		product *= Integer.parseInt(str.substring(i,1));
	}
	return number == factor*product;
}