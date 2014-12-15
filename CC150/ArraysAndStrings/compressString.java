/** 1.5 Implement a method to perform basic string compression using the counts of repeated chars. For example, the string aabbccccaa would be
	a2b1c5a3. If the compressed string would not become smaller than the original string, your method should return the original string.
	you can assume the string has only upper and lower letters(a-z)
*/

/** I think:
	scan the string, if next != curr, replace scanned part with letter+cnt; at last need to check if compressed_str.length < str.length
*/

public String compressString(String str){
	char curr = '';
	int cnt = 0;
	curr = str.charAt(0);
	cnt = 1;
	String compressed = '';
	for(int i=1;i<str.length();i++){
		if(str.charAt(i)!= curr){
			compressed += curr + num2str(cnt);
			curr = str.charAt(i);
			cnt = 1;
		}
		else{
			cnt++;
		}
	}
	
	return (compressed.length()<str.length())?compressed:str;
}

/** BOOK SOLUTION
	1. Firt-glance solution same as mine: O(p+k^2) not efficient because String is immutable so have to copy String each time 
	I make a mistake: after the for loop there should be compressed+= curr + num2str(cnt); because these are not executed after loop ends
	2. use StringBuffer to save time, or can use char[] array = new char[size], setChar(array,last,index,coun)
*/

/** implement using charArray
*/
public String compressString(String str){
	int cnt = 1;
	char cur = str.get(0);
	int index = 0;
	char[] compressed = new char[str.length];
	for(int i=1;i<str.length();i++){
		if(str.charAt(i) == cur)
			cnt++;
		else{
			compressed[index++] = cur;
			compressed[index++] = cnt;
			cur = str.charAt(i);
			cnt = 1;
		}
	}
	compressed[index++] = cur;
	compressed[index++] = cnt;
	return String.valueOf(compressed);
}