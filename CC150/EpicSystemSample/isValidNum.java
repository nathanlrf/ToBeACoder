/** Given the start and an ending integer as user input, generate all integers with the following property.
 *  Example : 123 , 1+2 = 3 , valid number
 *  121224 12+12 = 24 , valid number
 *  1235 1+2 = 3 , 2+3 = 5 , valid number
 *  125 1+2 <5 , invalid number
 *  http://www.careercup.com/question?id=13115667
 */
 
/** I think:
 *  start with substring of length 1, if the next substring is the same as current, test cur + next == next.next
 *  else increase the length of substring: if length * 3 + index > str.length() return
 *  can improve time complexity by:
 *  	- the string length must be n times substring length
 *  for(start, star<=end, start++){
 *  	for(int sub_len = 1; sub_len < str.length(); sub_len++){
 * 			if(isValid(number, sub_len))
 *				System.out.println(number);
 *		}		
 * 	}
 */
 
boolean isValid(int number, int len){
	String str = String.valueOf(number);
	if(str.length % len != 0)
		return false;
	for(int i=0;i<str.length()-3*len;i++){
		part1 = str.substring(i, i+len);
		part2 = str.substring(i+len, i+2*len);
		part3 = str.substring(i+2*len, i+3*len);
		if(part1 + part2 != part3)
			return false;
	}
	return true;
}