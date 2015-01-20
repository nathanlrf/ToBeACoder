/** 5.4 explain what the following code does:
 *  ((n & (n-1)) == 0)
 */
 
//11:17am

/** I think
 *  n : 100111001  10
 *  n-1: 100111001  01
 *  
 *  n & (n-1) = 100111001 00
 *  to make them = 0, structure should be n = 10...0, then n-1 = 01...1
 *  so n should be like 10...0 = 2^n 
 */
 
//11:20am

/** book solution:
 *  suppose n = abcd1000
 *  		n-1 = abcd0111
 *  n & (n-1) = abcd0000, so abcd = 0000
 *  n = 1000
 *  so it checks if n is a power of 2
 */