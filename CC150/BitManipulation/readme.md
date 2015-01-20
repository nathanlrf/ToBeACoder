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
	
- Generate 0..01..1
	```java
	//to generate mask with p 1s
	int mask = 1<<p - 1;
	```

- Count 1s in a binary
	- for binary C, can use C&(C-1) to flip last bit and count 1s in C
	```java
	for(; C!=0; C= C&(C-1)){
		cnt++;
	}
	```
		- if C last bit C[0] = 1, this operation will consume the last bit
		- if C last bit C[0] = 0, C-1 will flip all the bit until [p], where C[p] = 1, so this operation will also consume one 1 in C