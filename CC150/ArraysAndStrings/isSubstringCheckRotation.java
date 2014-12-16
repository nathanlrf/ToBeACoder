/** 1.8 Assume you have a method isSubstring which checks if one word is a substring of another. Given two strings, s1 and s2,
	write code to check if s2 is a rotation of s1 using only one call to isSubstring(eg. "waterbottle" is a rotation of "erbottlewat")
*/

/** I think:
	I read the answer before. Try something new:
	This could be done using word_cnt: 
	NO. Rotation requires the original order in the substring not changed. "ter" is OK, "waert" is not
	But it requires use of isSubstring,

	Other ways involving find the rotation point. This requires longest matching.
*/

public boolean isRotationOfAnother(String s1, String s2){
	String str = s2 + s2;
	if(s1.isSubstring(s2))
		return true;
	else
		return false;
}

/**	BOOK SOLUTION
	suppose s becomes x+y, and afer rotation it is y+x
	then s'+s' is always y+x+y+x
	if s is substring of s'+s' then s' is rotation of s
*/