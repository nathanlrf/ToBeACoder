/** 2.5 You have two numers represented by a linked list, where each node contains a single digit.
	The digits are stored in reverse order, such that the 1's digit is at the head of the list. Write 
	a fucntion that adds the two numbers and returns the sum as a linked list.
	Eg.
	Input: (7-> 1-> 6) + (5-> 9-> 2). That is, 617+295.
	Output: 2-> 1-> 9. That is 912.
	FOLLOW UP
	Suppose the digits are stored in forward order. Repeat the above problem.
	Eg.
	Input: (6-> 1-> 7) + (2-> 9-> 5). That is 617+ 295.
	Output: 9-> 1-> 2. That is 912.
*/

/** I think:
	use 2 iterator for each list, iterate them at the same time.
	(iter1.value + iter2.value)%10 = iter.value, sum/10 = carry
	not same length? shorter list element becomes 0: 
		Condition: iter1.next != null && iter2.next == null 
		set a boolean: list1_end or list2_end = true;
		if list1_end:
			iter.value = iter2.value + carry;
	outmost termination condition: iter1.next = null && iter2.next = null
	
	For follow up:
	first traverse to the tail
		condition: iter.next = null
	reverse the two list? O(n)
*/

public Node sumTwoLinkedList(Node head1, Node head2){
	Node head = null;
	Node iter = head;
	list1_end = false;
	list2_end = false;
	int carry = 0;
	while(head1 != null || head2 != null){
		if(head1 == null)
			list1_end = true;
		if(head2 == null)
			list2_end = true;
		Node node = new Node();
		if(list1_end){
			node.value = (head2.value + carry)%10;
			carry = (head2.value + carry)/10;
			head2 = head2.next;
		}
		else{
			if(list2_end){
				node.value = (head1.value + carry)%10;
				carry = (head1.value + carry)/10;
				head1 = head1.next;
			}
			else{
				node.value = (head1.value + head2.value + carry)%10;
				carry = (head1.value + head2.value + carry)/10;
				head1 = head1.next;
				head2 = head2.next;
			}
		}
		if(head == null){
			head = node;
			iter = node;
		}
		else{
			iter.next = node;
			iter = iter.next;
		}
	}
	return head;
}

//FOLLOW UP
public Node sumTwoLinkedListFollowUp(Node head1, Node head2){
	Node head = null;
	Node rev_head1 = reverseLinkedList(head1);
	Node rev_head2 = reverseLinkedList(head2);
	return sumTwoLinkedList(rev_head1, rev_head2);
}

public Node reverseLinkedList(Node head){
	Node rev_head = null;
	while(head.next != null){
		Node next = head.next;
		head.next = rev_head;
		rev_head = head;
		head = next;
	}
	return rev_head;
}

/** BOOK SOLUTION
	use recursion:
		There may be sth wrong about the book solution: there is no assignment for the value
*/
//my version of the recursive sum of 2 linked list
public Node sumTwoLinkedList(Node head1, Node head2, int carry = 0){
	int value = head1.data + head2.data + carry;
	carry = value/10;
	Node n = new Node(value%10);
	if(head1 != null || head2 != null)
		// n.next = sumTwoLinkedList(head1.next,head2.next, carry)
		// forget to check null ptr
		n.next = sumTwoLinkedList(head1 == null? null: head1.next: head2 == null? null: head2);
	return n;
}
/** For follow up:
	Book says that to make the match the number of two different length lists, it pads the shorter one with zeros.
	Compared with the first part, where results were added to tail(passed forward), here results are passed to head(backward)
	Use recursion to reach the tail of the linked list, then add backward:
		if(head1 == null && head2 == null)
			return new PartialSum()
		val = carry + head1.data + head2.data;
		
	One thing to remember:
	if there is carry= 1 for the sum of two head, have to insert a node before head:
	9->1->2 + 1->9->0
*/

