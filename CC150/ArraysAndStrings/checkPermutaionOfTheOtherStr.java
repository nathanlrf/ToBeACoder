/**1.3 Given two strings, write a method to decide if one is a permutation of the other
*/

/** I think:
	it is the same as the 1.1 check if all unique chars in a string. store the word cnt in a list, check if two list same.
	O(n) for creating cnt list, O(n) for compare
	Assume all ASCII, length 128 
*/

public boolean checkPermutaionOfStr(String str1, String str2){
	ArrayList<Integer> word_cnt1 = new ArrayList<Integer>();
	ArrayList<Integer> word_cnt2 = new ArrayList<Integer>();
	
	if(str1.length() != str2.length())
		return false;
	for(int i = 0; i< 256; i++){
		word_cnt1.add(0);
		word_cnt2.add(0);
	}
	
	for(int i = 0; i< str1.length(); i++){
		cntStrChar(str1, word_cnt1, i);
		cntStrChar(str2, word_cnt2, i);
	}
	
	for(int i = 0; i< 256; i++){
		if (word_cnt1.get(i) != word_cnt2.get(i) )
			return false;
	}
	return true;
}

public void cntStrChar(String str, ArrayList<Integer> word_cnt, i){
	int index = str1.charAt(i) - 'a';
	int cnt = word_cnt1.get(index) + 1;
	word_cnt.set(index, cnt);
}
/** BOOK SOLUTION:
	1. use sort, then compare:
	use java Arrays.sort() : is quicksort O(nlogn)
	convert string to charArray first
	2. use word cnt, similar to mine. But mine has the deficit of traverse list of length 256. 
	could be improved:
	for(int i = 0; i<str2.length();i++){
		int index = str2.charAt(i)-'a';
		if(word_cnt1.get(i) != word_cnt2.get(i))
			return false;
	}
	return true;
*/