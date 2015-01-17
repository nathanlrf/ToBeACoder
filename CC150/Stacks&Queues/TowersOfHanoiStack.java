/** In the classic problem of the Towers of Hanoi, you have 3 towers and N disks of
 *  different sizes which can slide onto any tower. The puzzle starts with disks sorted
 *  in ascending order of size from top to bottom(i.e. each disk sits on top of an even larger
 *  one). You have the following constraints:
 *  1. Only one disk can be moved at a time.
 *  2. A disk is slid off the top of one tower onto the next tower.
 *  3. A disk can only be placed on top of a larger disk.
 *  Write a program to move the disks from the first tower to the last using stacks.
 */
 
/** I think:
 *  -
 *  --
 *  ---
 *  A	B	C
 *  To move A to C:
 *  solving with recursion:
 *  	base case:
 *  		n = 1: A pop, C push
 *  		n = 2: A pop, B push; A pop, C push; B pop, C push;
 *  	n = 3: do n=2 A to B; A pop, C push; do n=2 B to C;
 *   	for n: move n-1 from A to B; move 1 from A to C; move n-1 B to C
 */
move(A, C, n){
	if(n == 1)
		C.push(A.pop());
	else if(n == 2){
		B.push(A.pop());
		C.push(A.pop());
		C.push(B.pop());
	}else{
		move(A, B, n-1);
		move(A, C, 1);
		move(B, C, n-1);
	}
}
class TowerOfHanoi{
	private ArrayList<Stack> towers = new ArrayList<Stack>();//size = 3, 0~2 corresponding to tower A~C
}
