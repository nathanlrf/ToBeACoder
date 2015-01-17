/**
 *  3.5 Implement a MyQueue class which implements a queue using two stacks
 */

//3:56PM

/** I think:
 *  1 stack: LIFO 
 *  2 stack: one pushes input: last element at the top; then pop into another: last element first pushed in, become a queue?
 *  data: a b c d e 
 *  enqueue:
 *  	1. push to input: e->d->c->b->a
 *  	2. pop input into output: a->b->c->d->e
 * 	dequeue:
		pop output
	linked list implementation for stack:
	Node head
	new Node node, node.next = head;
	head = node;
 */

//using linked list
class MyQueue{
	Node first, last;
	Stack stack1, stack2;
	void enqueue(Object item){
		while(!stack2.isEmpty()){
			stack1.push(stack2.pop());
		}
		stack1.push(item);
	}
	
	Object dequeue(){
		while(!stack1.isEmpty()){
			stack2.push(stack1.pop());
		}
		return stack2.pop();
	}
	
}
//4:08

/** Book solution:
 *  Pretty similar to mine. Use two stack to reverse order.
 *  But they have peek() and remove()
 */

 //book code
public class MyQueue<T>{
	Stack<T> stackNewest, stackOldest;// better name 
	 
	public MyQueue(){
		stackNewest = new Stack<T>();
		stackOldest = new Stack<T>();
	}
	
	public int size(){
		return stackNewest.size() + stackOldest.size();
	}
	
	public void add(T value){
		stackNewest.push(value);
	}
	
	public T peek(){//reverse order in peek
		shiftStacks();
		return stackOldest.peek();
	}
	
	public T remove(){
		shiftStacks();
		stackOldest.pop();
	}
	
	private void shiftStacks(){
		if(stackOldest.isEmpty){
			while(!stackNewest.isEmpty()){
				stackOldest.push(stackNewest.pop());
			}
		}
	}
}