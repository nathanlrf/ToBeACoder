/**1.2 Implement a function void reverse(char* str) in C or C++ which reverses a null-terminatd string
*/

/** I think:
rebuild the string will null at first, then visit it backwards
*/
char* reverse_str(char* str){
	int i = strlen(str);
	char* reverse = [];
	while(i>0){
		strcat(reverse, str[i-1]);
		i--;
	}
	return reverse;
}

/** BOOK SOLUTION:
	use a second ptr end to find the position before null end, str point to the start, swap between end and str.
	wonder why don't just use strlen()?
*/