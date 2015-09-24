import java.util.*;

public class Solution06
{
	/**
	 *  Solution idea:
	 *  When we want to find the next node, we need to make three steps 
	 *  of judgement:
	 *  1) if the current node has a right subnode? if yes, traverse the 
	 *  right subnode
	 *  2) return the first ancestor node of current node which is the 
	 *  left subnode of its parent node
	 *  3) the current node is the last node, return null
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

	public TreeNode successor(TreeNode node)
	{
		if(node == null)
			return null;

		//step 1
		if(node.right != null)
		{
			TreeNode right = node.right;
			while(right.left != null)
				right = right.left;
			return right;
		}

		//step 2 and 3
		TreeNode n = node;
		TreeNode p = n.parent;
		while(p.left != n && p != null)
		{
			p = p.parent;
			node = node.parent;
		}
		return p;
	}
}

