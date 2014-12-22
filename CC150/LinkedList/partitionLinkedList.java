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
public void partitionLinkedList(Node head, int x){
	Node iter1 = head; 
	Node iter2 = head;
	if(head.next != null)
		iter2 = head.next;
	
}
/** BOOK SOLUTION
*/