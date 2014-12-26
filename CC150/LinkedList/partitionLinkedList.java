/** 2.4 Write code to partition a linked list around a value x, such that all nodes less than x come before all nodes greater than or equal to x
*/

/** I think
	in arrays: 
	i = 0; j = length - 1;
	while(i<j){
		while(arr[i]<x)
			i++;
		while(arr[j]>x)
			j--;
		swap i and j;
	}
	
	for double linked list:
	I can get the end then use the same way as array: iter2 to get end O(n), iter1 and iter2 partition O(n)
	for single linked list:
	I can selection sort the whole array O(n^2) => why not quick sort? and here involves partition!
*/

// implement according to book solution
// if the element bigger than x, add to bigger
// there is a bigger_head and bigger_end, I originally use head and iter: head remain unchanged, iter initialized to head, then iter = iter.next
// in book the head of a linked list is not null
// This is a stable partition(see stable sort), another cleaner solution with unstable partition is at the bottom
public Node partitionLinkedList(Node head, int x){
	// Node smaller_head = new Node();
	// Node bigger_head = new Node();
	Node smaller_head = null;
	Node bigger_head = null;
	// Node smaller_iter = smaller_head;
	// Node bigger_iter = bigger_head;
	Node smaller_end = smaller_head;
	Node bigger_end = bigger_head;
	while(head != null){
		if(head.value> x){
			if(bigger_head == null){
				bigger_head = head;
				bigger_end = bigger_head;
			}
			// bigger_iter = head;
			// bigger_iter = bigger_iter.next;
			else{
				bigger_end.next = node;
				bigger_end = bigger_end.next;
			}
		}
		else{
			// smaller_iter = head;
			// smaller_iter = smaller_iter.next;
			if(smaller_head == null){
				smaller_head = head;
				smaller_end = smaller_head;
			}
			else{
				smaller_end.next = node;
				smaller_end = smaller_end.next;
			}
		}
		head = head.next;
	}
	//new linked list is smaller_head->smaller_iter->bigger_head->bigger_iter
	if(smaller_head == null)
		return bigger_head;
	smaller_end.next = bigger_head;
	bigger_end.next = null;
	return smaller_head;
}
/** BOOK SOLUTION:
	This is not done in space: creating two sub-linked list from the original one.
	Smaller-than-X and bigger-than-X are two sub-list then link these two together. 
*/

// maintain a head and a tail, bigger-than-X added to tail, smaller-than-X added to head
// this time smaller-than-X added before head and bigger-than-X added after tail, finally linked head to tail
public Node partitionLinkedList(Node head, int x){
	// Node new_head = null;
	
	// smaller -> new_head -> bigger
	Node new_head = head;
	Node new_tail = new_head;
	
	while(head != null){
		Node next = head.next;
		if(head.value < x){
			if(new_head == null)
				new_head = head;
			else{
				// added before new_head
				head.next = new_head;// head.next is changed, have to copy head.next to next
				new_head = head;
			}
		}
		else{
			// added after tail
			if(new_tail == null)
				new_tail = head;
			else{
				new_tail.next = head;
				new_tail = new_tail.next;
			}	
		}
		head = next;
	}
	new_tail.next = null;
	return new_head;
	
}