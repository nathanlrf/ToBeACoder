/** 2.6 Given a circular linked list, implement an alg which returns the node at the beginning of the loop.
	Definition:
	Circular linked list: A (corrupt) linked list损坏的链表 in which a node's next ptr points to an earlier node, so as to make a loop in 
	the linked list.
	Eg.
	Input: A -> B -> C -> D -> E -> C[the same C as earlier]
	Output: CDATASection
*/

/** I think
	use hashSet: O(n) time, O(n) space
		add every node visited to set Visited, if iterator revisit a node, return the node
*/

Node findCorruptedNode(Node head, HashSet visited){
	if(head == null)
		return null;
	if(visited.contains(head))
		return head;
	visited.add(head);
	return findCorruptedNode(head.next, visited);
}

/** BOOK SOLUTION:
	*->*->*->*
		 /	  \
		*	   *
		 \    /
		  *<-* 
	理解成一个追击问题:
	fast iter(2 nodes/step) VS slow iter(1 node/step)
	non-loop length: k
	loop size: S_loop
	fast and slow distance: k' 
	suppose they traverse the loop clockwise
	1. k = 0, slow iter at the head of circle:
		delta_v = 2 - 1 = 1 step/step;
		delta_v * t = S_loop - k';
		so t = S_loop - k' step, slow iter have traveled S_loop - k' and is k' away from head
	2. k != 0, slow at the head:
		if both start at the head of the linked list, then when slow iter reach loop head, k' = (2-1)*k = k
		according to the result above, slow iter is k away from head
	3. if now one iterator goes from linked list head and another one goes from the collision point, they will meet after k steps
	
	pseudo code:
	
	while(fast_iter not meet slow iter){
		fast_iter = fast_iter.next.next;
		slow_iter = slow_iter.next;
	}
	// iters meet
	iter = linked list head;
	while(iter and slow_iter not meet){
		iter = iter.next;
		slow_iter = slow_iter.next;
	}
	return iter;
*/

public Node findCorruptedNode(Node head){
	Node fast = head;
	Node slow = head;
	while(fast != null && fast.next != null){//check null ptr
		fast = fast.next.next;
		slow = slow.next;
		if(fast == slow)
			break;
	}
	if(fast == null || fast.next == null)// no loop
		return null;
	fast = head;
	while(fast != slow){
		fast = fast.next;
		slow = slow.next;
	}
	return slow;
}