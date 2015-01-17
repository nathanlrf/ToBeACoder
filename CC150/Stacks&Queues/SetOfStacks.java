/** 3.3 Imagine a stack of plates. If the stack gets too high, it might topple. Therefor, in real life, we would
 *  likely start a new stack when the previous stack exceeds some threshold. Implement a data structure SetOfStacks that
 *  mimics this. SetOfStacks should be composed of several stacks and should create a new stack once the previous one
 *  exceeds capacity. SetOfStacks.push() and SetOfStacks.pop() should behave identically to a single stack(that is, pop()
 *  shoudl return the same values as it would if there were just a single stack).
 *  FOLLOW UP
 *  Implement a fucntion popAt(int index) which performs a pop operation on a specific sub-stack.
 */

/** I think:
 *  divide a stack into fixed length sub-stacks. use a element cnt to track elements(which stack they are in) and a stack cnt
 *  SetOfStacks: top 
 *  push(): first find which stack to use: element_cnt%MAX_SIZE, if element_cnt%MAX_SIZE> sub_stack_cnt, create a new one
 *  pop(): if a sub_stack is empty, remove it
 *  use arraylist to store sub_stacks
 *  FOLLOW UP
 *  use the index for ArrayList get() then pop()
 *  problem is we have to rearrange the elements: pop() on stack 1, there is one empty space on the top, stack 2 elements have to 
 *  be used to fill the gap.
 *  Since stack is implemented in linked list, this is not hard: add a field bottom
 *  	first element pushed is bottom;
 *  	stack1.pop();
 *  	stack1.top.next = stack2.bottom;
 *  	stack2.bottom = stack2.bottom.next;
 *  	element_cnt--;
 */
//double linked list for follow up
class Stack{
	private Node top;
	private Node bottom;//follow up
	void push(Object item){
	//if exceed STACK_SIZE throws FullStackException
		if (top == null){
			top = new Node(item);
			bottom = top;
		}
	}
	Object pop();
	Object peek();
}

class SetOfStacks{
	private int element_cnt = 0;
	private Node top = null;
	private ArrayList<Stack> sub_stacks;
	
	public SetOfStacks(){}
	
	public void push(Object item){
		element_cnt++;
		int stack_ptr = element_cnt/STACK_SIZE;
		if(stack_ptr > sub_stack.size())
			sub_stacks.add(new Stack());
		Stack stack = sub_stacks.get(stack_ptr-1);
		stack.push(item);
	}
	
	public Object pop(){
		int stack_ptr = element_cnt/STACK_SIZE;
		Stack stack = sub_stacks.get(stack_ptr-1);
		Object result = stack.pop();
		if(stack.top == null)
			sub_stacks.remove(stack_ptr-1);
		element_cnt--;
		return result;
	}
	
	public Object peek(){
		int stack_ptr = element_cnt/STACK_SIZE;
		Stack stack = sub_stacks.get(stack_ptr-1);
		return stack.peek();
	}
	
	//FOLLOW UP
	public Object popAt(int index){
		Stack sub = sub_stacks.get(index);
		Object result = sub.pop();
		element_cnt--;
		while(index < sub_stacks.size()){
			Stack curr = sub_stacks.get(index);
			Stack next = sub_stacks.get(index+1);
			if(next == null)
				break;
			//shift elements from next stack bottom to current top
			curr.top.next = next.bottom;
			next.bottom = next.bottom.prev;
			index++;
		}
		return result;
	}
}

/** BOOK SOLUTION
 *  Use ArrayList<Stack>, call push() & pop() on the last stack: 
 *  	in my code I should use last = getLastStack();
 *  For push(): if empty or need more stacks, add() new stack
 *  For pop(): if stack empty, remove() it
 *  Basically the same. 
 *  For follow up:
 *  	To make every sub stack full:
 *  		roll over system which shift next stack element to current one;
 *  		large time complexity, talk to interviewer about this;
 *  	Allow not-full stack:
 *  		just pop stack at indexs
 *  Should seperate code into other methods!! More modular!
 */

