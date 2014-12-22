/** 4.1 Implementa function to check if a binary tree is balanced. For the purpose of this question, a balanced tree
	is defined to be a tree such that the heights of the two subtrees of any node never differ by more than one.
*/

/** I think:
	do it recursviely:
	if(abs(height(left) - height(right))<1)
		return true;
	need to compute the height of the tree
	height of the tree is the longest path from root to leaf: DFS?
	base case:
	*  leaf : return true, height = 0
	
	*
   / \
  *   *
  
	reference the book for getHeight(root){
		if(root.left == null && root.right == null)
			return 0
		return max(getHeight(root.left)+1, getHeight(root.right)+1);
	}
  
*/

public boolean isBalancedTree(TreeNode root){
	if(root.left == null && root.right == null)
		return true;
	if(abs(getHeight(root.left)- getHeight(root.right))>1)
		return false;
	else
		return isBalancedTree(root.left) && isBalancedTree(root.right);
}

