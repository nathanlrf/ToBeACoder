/** 5.2 Given a real number between 0 and 1(eg, 0.72) that is passed in as a double,
 *  print the binary representation. If the number cannot be represented accurately in
 *  binary with at most 32 characters, print "ERROR"
 */
 
//11:01PM

/** I think:
 *  	decimal to binary:
 *  		do decimal = decimal - 2^(-i) until: decimal = 0; i =32
 *  
 */
 
public static void printRealNumberInBinary(double number){
	int bit_weight = -1;
	char c = '0';
	String bin_form = "0.";
	while(number > 0 && 32 >= bin_form.length()){
		c = '0';
		if(number >= Math.pow(2, bit_weight)){
			number -= Math.pow(2, bit_weight);
			c = '1';
		}
		bit_weight--;
		bin_form += c;
	}
	System.out.println(bin_form);
	if(number != 0)
		System.out.println("ERROR");
	else
		System.out.println(bin_form);
}

//11:23PM

/** Book solution
 *  	1.multiply by 2 and check if result > 1
 *  	2.same as mine
 */