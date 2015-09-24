import java.util.*;

public class Solution08
{
	/**
	 *  Solution idea:
	 *  We can test if a node is the ancestor of the other.
	 *  If not, try its parent node and do it iteratively 
	 *  until find the first common ancestor.
	 *
	 *  P.S. "fca" function implement this algorithm.
	**/

	class TreeNode
	{
		public int value;
		public TreeNode left;
		public TreeNode right;
		public TreeNode parent;
		public TreeNode(int val)
		{
			this.value = val;
			this.right = null;
			this.left = null;
			this.parent = null;
		}
	}

	public TreeNode fca(TreeNode n1, TreeNode n2)
	{
		TreeNode parent = n1;
		TreeNode child = n2;

		while(!isFCA(parent, child) && parent != null)
		{
			parent = parent.parent;
		}

		return parent;
	}

	public boolean isFCA(TreeNode parent, TreeNode child)
	{
		if(parent == null)
			return false;
		if(parent == child)
			return true;

		boolean left = isFCA(parent.left, child);
		boolean right = isFCA(parent.right, child);

		return (left || right);
	}
}

