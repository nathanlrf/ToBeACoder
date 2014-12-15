/**1.1 implement an alg to determine if a string has all unique characters.
what if you cannot use a dditional data structure?
*/

/** I think:
traverse the string, cnt the char, O(n): have to create an arraylist?  index?
use a long arraylist of str.length(), scan arraylist when add a char, O(n^2);
or use hashcode() to map each word to the index of arraylist; 
or I can use a set, if set.size() == str.length(), they are all unique;
*/
class CharCnt{
	private char ch;
	private int cnt;
	
	public CharCnt(){
		ch = '';
		cnt = 0;
	}
	/**O(n)+O(1)
	*/
	public boolean checkAllUniqueChar(string str){
		ArrayList<Integer> cnt = new ArrayList<Integer>();
		
		for(int j = 0; j< str.length(); j++) {
			cnt.add(0);
		}
		
		for(int i = 0; i< str.length(); i++){
			int index = hashcode(str.charAt(i));
			int char_cnt = cnt.get(index);
			if (char_cnt!= 0)
				return false;
			char_cnt += 1;
			cnt.set(index, char_cnt);
		}
	}
}
/** use Java Set
*/
public boolean checkAllUniqueChar(string str){
	Set<Character> charset = new HashSet<Character>();
	for(int i = 0; i< str.length(); i++){
		charset.add(str.charAt(i));
	}
	if(charset.size() == str.length())
		return true;
	else
		return false
}

/** BOOK SOLUTION
	1. Assume ASCII characters. Remember to ask if Unicode or ASCII!
	use a list with length of all ASCII chars, list[i] is a boolean, if visited boolean is set to true 
	2. use bit vector? Pretty strange.... actually is use bit vector the same way as an arraylist:
		checker = 0 => checker: 0000...000
		val = charAt(i) - 'a'
		record a char: checker |= (1<<val): set ith bit to 1, checker: 00...010...
		check uniqueness: checker & (1<<val) 
	3. compare every character to others in string O(n^2) 
	4. sort first and see if there is two same adjacent chars: O(nlogn)
		curr = charAt(i);
		next = charAt(i+1);
		while(curr != next && i < str.length())
			i++;
		if(i == str.length());
			return true;
		else
			return false;
*/
