/** 3.2 How would you design a stack which, in addition to push and pop, also has a function min which returns
 *  the minimum element? Push, pop and min should all opearte in O(1) time.
 */
 
/** I think: maintain an additional field min
 *  class Stack{
 *  	Object min;
 *  	
 *  	void push(Object item){
 *  		if(min == null)
 *  			min = item;
 *  		else{
 *  			if(item.data < min)
 *  				min = item;
 *			}
 *		}
 *  }
 *  
 *  only worked for push:
 *  	if popped the minimum one, have to find the next smallest one
 *  	maintain a sorted stack for min: from largest to smallest
 *  	but insert a element in the right order requires O(n) time!
 */
  
// my first thought of adding one field or an ArrayList is wrong
// the book suggests track the minimum below each stack element
class StackNode{
	private Node node;
	private Object minimum;
	
	public StackNode(n, min){
		node = n;
		minimum = min;
	}
} 

class Stack{
	private StackNode top;
	
	void push(Object item){
		Node node = new Node(item);
		if(top == null){
			top = new StackNode(node, item);
		}	
		else{
			node.next = top.node;
			if(!item.compareTo(top.minimum))
				StackNode sn = new StackNode(node, item);
			else
				StackNode sn = new StackNode(node, top.minimum);
			top = sn;
		}		
	}
	
	Object min(){
		return top.minimum;
	}
}

/** BOOK SOLUTION
 *  1. add a min field to record the minimum of the stack:
 *  	problem: if the minimum is popped, require O(n) time to find next minimum
 *  2. track the minimum for stack of n, when push a new element, record the minimum for stack of n+1:
 *  	have a wrapper class for the element and the minimum from this element to the bottom of the stack
 *  3. for a large stack, there will be the same minimum for many nodes and takes much space: 
 *  	just need to check if the minimum is popped:
 *  	in push() maintain another stack for minimum: min_stack 
 *  		push() new elements;
 *  		if(new elements < min_stack.peek())
 *  			min_stack.push(new element)
 *  	check if minimum is popped in pop():
 *  		if(stack.pop() == min_stack.peek())
 *  			min_stack.pop();	 
 *  	min():
 *  		return min_stack.peek()
 */