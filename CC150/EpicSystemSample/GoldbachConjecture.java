/** Goldbach's conjecture : Every even integer greater than 2 can be expressed as the sum of two primes.
 *  Write a function which takes a number as input, verify if is an even number greater than 2 and also 
 *  print at least one pair of prime numbers.
 */
 
/** I think
 *  
 */

void printPrimePair(int number){
	if(number > 2 && number %2 == 0){
		for(i = 3;i<number;i += 2){// notice i increase by 2 to be only odd number
			if(isPrime(i) && isPrime(number - i))
				System.out.println("pair is: "+ i+" ;"+(number-i));
		}
	}
}

boolean isPrime(int number){
	if(number % 2 == 0)
		return false
	for(int i=3;i< sqrt(number);i+=2){// termination condition is sqrt(number)
		if(number%i == 0)
			return false;
	}
	return true;
}