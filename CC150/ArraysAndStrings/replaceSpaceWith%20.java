/** 1.4 replace all spaces in a string with '%20'. may assume that the string has sufficient space at the end of the string to hold
	the additional characters, and that you are given the "true" length of the string.(Note if in Java, use a character array so you can perform
	this operation in place.)
	eg. Input: "Mr John Smith     ", 13
		Output: "Mr%20John%20Smith";
*/

/** I think:
	scan the string, mark space index using ArrayList, use substring to copy substring to new str and append '%20'
*/

public String replaceSpace(String str){
	String result = '';
	String replace = '%20';
	ArrayList<Integer> space_index = new ArrayList<Integer>();
	
	for(int i=0;i<str.length();i++){
		if(str.charAt(i) == ' ')
			space_index.add(i);
	}
	
	int non_space_index = 0;
	for(int i=0;i<space_index.length();i++){
		int space_i = space_index.get(i);
		result += str.substring(non_space_index, space_i)+replace;
		non_space_index = space_i + replace.length();
	}
	
	return result;
}

/** BOOK SOLUTION: 
	they give the true string length, and compute the new string length using new_length = length + 2*space_cnt
	then copyt the str from end to start. end is new_length - 1
*/