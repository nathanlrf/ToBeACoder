/** 12.1 find the mistake(s) in the following code:
 */

unsigned int i;
for(i = 100; i>=0; --i)
	printf("%d\n", i);

/** I think:
 *  this code print number from 100 to 0;
 *  termination condition: i < 0;
 *  but i is unsigned, --i will lead to overflow
 *  so loop never terminates.
 */
 
/** Book solution
 *  Beside what I though, the printf() format is wrong:
 *  	should be printf("%u\n", i)
 */