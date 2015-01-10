/** Write a program to generate all palindrome dates by taking the beginning and the ending dates 
 *  as an input from the user. The format of the date is given as MMDDYYYY.
 */

/** I think:
 *  to check a date later than a given on:
 *  	compare year YYYY, then MM, then DD
 *  palindrome dates:
 *  	should start with YYYY: suppose it is abcd, then dc should within 12, cd should between 28~31 depends on MM
 */

static void generatePalindromeDate(String start, String end){
	int year_start = Integer.parseInt(start.substring(start.length()-4, start.length()));
	int year_end = Integer.parseInt(end.substring(end.length()-4, end.length()));
	for(int i=year_start; i<= year_end; i++){
		int month = getMonth(year);
		int date = getDate(year);
		if(isValid(month, date))
			print(month+date+year)
	}
}