/**Implement LookAndSay function. For example, first, let user input a number, say 1. 
 *  Then, the function will generate the next 10 numbers which satisfy this condition:
 *  1, 11,21,1211,111221,312211...
 *  explanation: first number 1, second number is one 1, so 11. 
 *  Third number is two 1(previous number), so 21. next number one 2 one 1, so 1211 and so on...
 */

/** I think
 *  1. initial input: a number 0~9
 *  2. generate next number[i]: count the distinct digits for number[i-1], make it cnt+digit
 *  3. do this for 10 times 
 */
 
public static void main(String[] args){
	LookAndSay(1);
}

public static void LookAndSay(int input){
	String str= String.valueOf(input);
	System.out.println(str);
	if(str.length() == 10){
		return;
	}
	else{
		String result = "";
		int cnt = 1;
		char cur = str.charAt(0);
		for(int i=1; i<str.length(); i++){
			if(str.charAt(i) == cur)
				cnt++;
			else{
				result = result + String.valueOf(cnt) + cur;
				cur = str.charAt(i);
				cnt = 1;
			}				
		}
		result = result + String.valueOf(cnt) + cur; 
		LookAndSay(Integer.parseInt(result));
	}
}
