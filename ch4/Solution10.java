import java.util.*;

public class Solution10
{
	/**
	 *  Solution idea:
	 *  We can traverse the tree T1 to find all nodes that 
	 *  have the same value as T2's root. Then, compare the 
	 *  subtree of each node with T2's subtree recursively.
	 *
	 *  P.S. "isSubtree" function implement this algorithm.
	**/

	class TreeNode
	{
		public int value;
		public TreeNode left;
		public TreeNode right;
		public TreeNode(int val)
		{
			this.value = val;
			this.right = null;
			this.left = null;
		}
	}

	public boolean isSubtree(TreeNode n1, TreeNode n2)
	{
		if(n2 == null)
			return true;
		else
			return subtree(n1, n2);
	}

	public boolean subtree(TreeNode n1, TreeNode n2)
	{
		if(n1 == null)
			return false;
		else if(n1.value == n2.value && isIdentical(n1, n2))
			return true;

		return subtree(n1.left, n2) || subtree(n1.right, n2);
	}

	public boolean isIdentical(TreeNode n1, TreeNode n2)
	{
		if(n1 == null && n2 == null)
			return true;
		if(n1.left.value != n2.left.value)
			return false;
		if(n1.right.value != n2.right.value)
			return false;

		boolean left = isIdentical(n1.left, n2.left);
		boolean right = isIdentical(n1.right, n2.right);
		return left && right;
	}
}

