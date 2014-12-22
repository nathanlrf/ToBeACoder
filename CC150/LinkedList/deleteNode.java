/** 2.3 Implement an alg to delete a node in the middle of a singly linked list, given only access to that node
	EXAMPLE
	Input: the node c from the linked list a->b->c->d->e
	Result: nothig is returned, but the new linked list looks like a->b->d->e
*/

/** I think:
	I can shift the node from d to c and e to d
*/

public void deleteNode(Node node){
	while(node.next!= null){
		Node next= node.next;
		node.value = next.value;
		node = next;
	}
	//node is the last node not null
	node = null;
}

/** BOOK SOLUTION:
	Just shift 1 node is enough!, delete node next to c after copying it to c
	deleteNode(Node node){
		Node next = node.next;
		node.value = next.value;
		node.next = next.next;
		
	}
*/