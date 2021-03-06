Chap 2 Linked List
===

Key point:

1. creating a linked list: 
	```java
	//single linked list
	class Node{
		Node next = null;//initialized to null
		int data;
	}
	//Node tail 
	tail.next = null;
	//head != null
	//for a node
	node.data = data;
	
	appendToTail(int d){
		node.data = d;
		Node tail = new Node(d);
		//traverse linked list
		while(n.next != null){// this condition for visiting all nodes except tail before null
			n = n.next;
		}
		n.next = tail;
	}
	
	//double linked list
	class Node{
		Node next = null;
		Node prev = null;
		int data;
	}
	```
2. delete a node 
	
	the node is head/tail?
	the node is a normal node
	check for null ptr

	```java
	//single linked list
	Node deleteNode(Node head, int d){//return new linked list head
		Node n = head;
		if(n.data == data)//delete head
			return head.next;
		while(n != null){
			if(n.next.data == d){
				n.next = n.next.next;
				/** for double linked list
					n<->n.next<->n.next.next
					n.next.prev = n;
				*/
				return head;
			}
			n = n.next;
		}
		return head;
	}
	```

3. "Runner" technique

	iterating through the linked list with two ptrs simultaneously
	"fast" iterator might be ahead of the "slow" one: by a fixed amount; hopping multiple nodes for each node the "slow" one iterates through
	
	- when traversing a single linked list, the fast oen can hop two nodes/step: fast = fast.next.next; in this manner the slow will reach the 
	middle node of the linked list when fast == null;
	
4. recursive prlbems:
	takes at least O(n) space -- n is depth of recursion
	find the last node, 
	find kth-to-last node: see 2.2, use recursive call to reach tail, then add 1 to a cnt to every return result
	
	- I can use recursion to reach the tail, then deal with the return result:
	remember the recursion store the result like a stack: 
		- for palindrome use recursion to reach the middle node, then compare with node next to it
		- for get kth-to-last, when get the tail, every return node means 1 node further from tail
	
	
Problems:

1. For 2.5 the solution on book is not clear or even wrong, no assignment for the value on book, rewrite it in my own way 
