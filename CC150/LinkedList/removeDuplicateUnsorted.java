/** 2.1 write code to remove duplicate froma an unsorted linked list.
	FOLLOW UP
	How would you sove this problem if a temporary buffer is not allowed?
*/

/** I think
	sort it first!
	If the next is the same as current remove next.
	But how to sort? O(nlogn), but requires temporary buffer?
	Could use Java Set: it is hashset so add is O(1)
	Then convert it to linked list.
*/
public void deleteDuplicate(LinkedListNode n){
	HashSet<T> set = new HashSet<T>();//T is the n.data type
	while(n.next!=null){
		if(!set.contains(n.data))
			set.add(n.data);
		else{//suppose this is a single linked list
			n.prev.next = n.next;
			/**
			for double linked list
			n.prev.next = n.next;
			n.next.prev = n.prev;
			*/
		}
		n = n.next;
	}
}


/** BOOK SOLUTION
	do requires a hashtable, but don't need to store in hashset and convert it back: just remove duplicate
	for FOLLOW UP 原来FOLLOW UP是后续一题的意思。。。。
	use two iterators: it is O(n^2)
	while(n.next!=null){
		node second_iter = n.next;
		while(second_iter.next != null){
			if (n.data == second_iter.data)
				delete second_iter
			second_iter = second_iter.next;
		}
		n = n.next;
	}
*/