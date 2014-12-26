/** 2.7 Implement a func to check if a linked list is a palindrome
*/

/** I think:
	if it is a double linked list:
		reach end, one iter from head, one iter from tail
	for single linked list:
		use recursion to get to tail, then compare from the head?
		may reference to get kth-to-last node:
		getKthToLast(Node node, int n, CountClass i){
			if(node.next == null)
				return node;
			node2 = getKthToLast(node.next, n, i);
			i.cnt += 1;
			if(i.cnt == n)
				return node;
			return node2;
		}
		
		dumb way: create a double linked list from the single one
*/

// inspired by solution 2
public boolean checkPalindrome(Node head){
	Node fast = head;
	Node slow = head;
	Stack stack = new Stack();
	while( fast != null && fast.next != null){// slow should reach length/2 when out of loop
		stack.push(slow.data);//push first half in stack, reverse their order to compare with last half
		fast = fast.next.next;
		slow = slow.next;
	}
	if(fast != null)//odd number, no need to check number in the middle 
		slow = slow.next;
	fast = head;//compare first half and second half
	while(slow != null){
		int data = stack.pop();
		if(!slow.data.equals(data))
			return false;
		slow = slow.next;
	}
	return true;
}

/** BOOK SOLUTION:
	1. reverse the linked list and compare their first half
	2. use a stack: node pushed is in reverse order when popped, then compare with last half with the list:
		fast iter and slow iter
		while(fast != null && fast.next != null){
			fast = fast.next.next;
			stack.push(slow.data);
			slow = slow.next;
		}
		if(fast != null){// odd length 1->2->3->4->5: 1, 3, 5 fast.next == null;
			slow = slow.next;
		}
		while(slow != null){
			if(stack.pop() != slow.data)
				return false;
			slow = slow.data;
		}
		return true;
	3. recursion: compare element 0 with element n, 1 with n-1, ...: lenght -= 2, each time
		base case: odd number length = 1, even length = 0;
		recurse(n.next, length - 2);
		list: 0(1(2(3)2)1)0 length: 7, 0 VS 0, 
				1(2(3)2)1)0, length = 5, 1 VS 1, return node.next
				  2(3)2)1)0, length = 3, 2 VS 2, return node.next
				    3)2)1)0, length = 1, 3 VS 3: base case, return node.next
		list head VS compare_node
		every recursion: compare head and nodes, if not same return false, else return node.next => wrap boolean and node in a class Wrapper
*/
class Wrapper{
	public boolean result; 
	public Node node;
	
	public Wrapper(res, n){
		result = res;
		node = n;
	}
}

Wrapper isPalindromeRecurse(Node head, int length){
	//base case, always return compare_node.next
	if(length == 0 || head == null)//empty list
		return new Wrapper(true, null);
	else if (length == 1)
		return new Wrapper(true, head.next);
	else if (length == 2)//??? is this case for the even length? but should be included in length == 0?
		return new Wrapper(head.data == head.next.data, head.next.next);
	Wrapper res = isPalindromeRecurse(head.next, length-2);//length -2 makes sure the recursion stops at the middle of the list
	
	if(!res.result || result == null)//if return result is false or it is a null list
		return res;// return the result directly
	else{
		res.result = res.node.data == head.data;
		res.node = res.node.next;
		return res;
	}
}

boolean isPalindrome(Node head, int length){
	Wrapper res = isPalindromeRecurse(head, length);
	return res.result;
}