/** 3.1 Describe how you could use a single array to implement three stacks.
*/

/** I think:
	given array int[] arr = new int[10];
	ptr1 = ptr2 = ptr3 = 0; 
	0 1 2 3 4 5 6 7 8 9
	1. I can divide the array to 3 equal parts, for each ptr there is a start & end
	2. push elements, track each ptr respectively
		if 1 array for 1 stack:
			ptr = 0;
			push: arr[ptr] = data, ptr++;
		for 3 stacks:
			stack1 push: arr[ptr1] = data, 
			ptrs[][] track the position of each ptr
*/

class Stack{
	private int[] arr = new int[length];
	private int[][] ptr_track = new int[3][length];
	
	void push(int stack, Object item){
		int index = ptr_track[stack];
	}
	
	Object pop(){
		
	}
	
	Object peek(){
		
	}
}

/** BOOK SOLUTION:
	same as mine
	1. fixed length. stack1 [0,n/3); stack2 [n/3, 2n/3); stack3 [2n/3, n) simple, not space efficient
	2. flexible, array should be circular!
		Code for this is far more complex than would be appropriae for an interview
	
*/