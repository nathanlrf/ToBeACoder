/** 3.6 Write a program to sort a stack in ascending order(with biggest items on top). 
 *  You may use at most one addtitional stack to hold items, but you may not copy the 
 *  elements into any other data structure(such as an array). The stack supports the following 
 *  operations: push, pop. and isEmpty.
 */
 
//4:19PM

/** I think:
 *  a tmp variant? Object min?
 *  pop stack A to stack B, find min, then push min
 *  traverse stack elements like this?
 */
 
public static void sortStack(Stack<T> to_sort){
	Stack<T> sorted = new Stack<T>();
	int to_sort_size = to_sort.size();//if not supported, can use a loop to implement
	Object min;
	Object item;
	//find min of to_sorted, push it to sorted
	while(!to_sort.isEmpty){
		while(!to_sort.isEmpty){
			item = to_sort.pop();
			sorted.push(item);
			if(min == null)
				min = item;
			else{
				if(min.compareTo(item))
					min = item;
			}
		}
		sorted.push(min);
		min = null;
		//remove the min, push else back to to_sort
		while(!to_sort.isEmpty){
			item = to_sort.pop();
			if(item != min)
				sorted.push(item);
		}
		to_sort_size--;
		int cnt = to_sort_size;
		while(cnt>0){
			to_sort.push(sorted.pop());
			cnt--;
		}
	}
}

//4:37

/** Book solution
 *  to_sort.pop(), then put the popped one item in the right place:
 *  pop all elements bigger than item in stack B to stack A,
 *  repeat
 */
 
public Stack<T> sortStack(Stack<T> unsorted){
	Stack<T> sorted = new Stack<T>();
	while(!unsorted.isEmpty()){
		Object item = unsorted.pop();
		while(!sorted.isEmpty() && item.compareTo(sorted.peek())){
			unsorted.push(sorted.pop());
		}
		sorted.push(item);
	}
	return sorted;
}

private T peek(){
	Object item = stack.pop();
	stack.push(item);
	return item;
}