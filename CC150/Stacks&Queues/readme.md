chap3 stacks and queues
===

- Key point:
	- Implemented in linked list
	
	1. stack: LIFO
		```java
		class Stack{
			Node top;
			
			Object pop();//delete the top: top = top.next
			void push();
			Object peek();//read only, no deletion: return top.data
		}
		```
		can be used to reverse order
		
	2. queue: FIFO
		```java
		class Queue{
			Node first, last;
			
			void enqueue(Object item){
				if(first == null){//check if empty queue
					first.data = item;
					first = last;
				}else{
					last.next = new Node(item);
					last = last.next;
				}
			}
			
			object dequeue(){
				if(first == null)
					return null;
				Object data = first.data;
				first = first.next;
				if(first == null)
					last = null;
				return data;
			}
		}
		```
