/**In 1-9 keypad one key is not working. If some one enters a password then 
 *  not working key will not be entered. You have given expected password and entered password. 
 *  Check that entered password is valid or not
 *  Ex: entered 164, expected 18684 (you need to take care as when u enter 18684 and 164 only both will be taken as 164 input) 
 */
 
/** I think:
 *  find pattern in text;
 *  if char not match for the first time, take it as not working key 
 *  if char not match && char != not working key => return false
 */

static boolean isValidPassword(String input, String expected){
	String not_working = "";
	int i=0;
	int j = 0;
	while(i<expected.length() && j<input.length()){
		if(input.charAt(j) != expected.charAt(j)){
			not_working += expected.charAt(j);
			break;
		}
		i++;
		j++;
	}
	expected = expected.replace(not_working, "");
	return expected == input;
}