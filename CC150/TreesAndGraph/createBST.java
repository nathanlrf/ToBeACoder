/** 4.3 Given a sorted(increasing order) array with unique integer elements, wite an alg to create a binary search tree with minimal height.
*/

/**	BST with minimal height is log2(list.length)
	elements in the middle is root, traverse array from middle: middle to start and middle to end
	root = array[length/2]
	if(value>root.value)
		addNode(root.right)
	else
		addNode(root.left)
	need consider efficiency here:
	since I add number from biggest to smallest(middle to start) and smallest to biggest(middle to end), should record height:
	left_root = root;
	right_root = root;
	height = log2(length);
	left = middle- 1;
	right = middle +1;
	while(height>=0){
		if()
		height--;
		
	}
	Got a better idea! Use the heap array expression!
	root at i
	left at 2i+1;
	right at 2i+2;
	still start from middle
*/

public int[] createBST(int[] sorted){
	int[] bst = new int[sorted.size()];
	int root = sorted.size/2;
	int height = (int)Math.log(sorted.size())/Math.log(2);
	int index = 0;
	int leftnode = 0;
	int rightnode= 0;
	while(height > 0){
		leftnode = root -1;
		rightnode = root + 1;
		left = 2*index + 1;
		right = 2*index+ 2;
		bst[index] = sorted[root];
		bst[left] = sorted[leftnode];
		bst[right] = sorted[rightnode];
		height--;
	}
}