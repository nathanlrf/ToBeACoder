Chap5 Bit Manipulation
===

- Java Bitwise and Bit Shift Operators

	- ~	Unary bitwise complement
	- <<      Signed left shift
	- >>      Signed right shift
	- >>>     Unsigned right shift
	- &       Bitwise AND
	- ^       Bitwise exclusive OR
	- |       Bitwise inclusive OR

- Get bit
	use & and 0
	
- Set bit
	use | and 1
	
- Clear bit
	use 1, shift and &
	
- Update bit
	clear bit, then set bit
	
- When want to combine binary A and binary B to result like A + B, use |:
	A|B
	
- About shift bits: 
	- to point to bit[i]: shift <<i
	- to preserve bit[j:i]: bit<<(j+1) | bit<<i
