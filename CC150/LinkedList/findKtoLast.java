/** 2.2 Implement an alg to find the k-th to last element of a singly linked list
*/

/** I think:
	1st version: very simple, traverse the list until end to get length, then compute the position with length-k, revisit the list
*/

public Node findKtoLast(Node head, int k){
	int index = 0;
	Node node = head;
	while(node.next!= null){
		index += 1;
		node = node.next;
	}
	index -= k;
	node = head;
	while(index != 0){
		node = node.next;
	}
	return node;
}

/** recursion:
	use a func to find end: findEnd(Node head), return length;
*/
public Node main(Node head, int k){
	int length = findEnd(Node head, 0);
	return findKtoLast(head,length - k);
}
public Node findKtoLast(Node head,int k){
	if(k == 0)
		return head;
	return findKtoLast(head.next, k -1);
}
public int findEnd(Node head, int cnt){
	if(head.next == null)
		return cnt;
	return findEnd(head.next, cnt + 1);
}
/** BOOK SOLUTION:
	1. recursively find the end and set the cnt = 0, every parent call adds 1 to cnt:
	int findKtoLast(head,K){
		if(head == null)
			return 0;
		int cnt = findKtoLast(head.next,K)+1;
		if(cnt == K)
			System.out.println(head.value);
		return cnt;
	}
	
	the idea that every parent call adds 1 is very cool!
	Problem is can only return index, not the node
	
	2. To solve cannot simultaneously return a cnt and an index, wrap cnt with class
	class IntWrap{
		public int value = 0;
	}
	Node findKtoLast(Node head, int K, IntWrap i){
		if(head == null)
			return null;
		Node node = findKtoLast(head.next, K, i);
		i.value += 1;
		if(i.value == K)
			return head;
		return node;
	}
	
	3. An iterative method: first iter1 and second iter2, while iter2 = iter1 + k, if iter2 == end, iter1 is the node
*/
// iterative
public Node findKtoLast(Node head, int k){
	Node iter1 = head;
	Node iter2 = head;
	for(int i= 0;i<k;i++){
		if(iter2.next == null)
			return null;
		iter2 = iter2.next;
	}
	while(iter2.next != null){
		iter1 = iter1.next;
		iter2 = iter2.next;
	}
	return iter1;
} 