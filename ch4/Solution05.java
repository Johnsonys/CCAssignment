import java.util.*;

public class Solution05
{
	/**
	 *  Solution idea:
	 *  We can use a class to store the lowest and the 
	 *  highest element of subtree through a recursive way.
	 *
	 *  P.S. "isBST" function implement this algorithm. 
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

	class Result
	{
		public boolean flag;
		public int low;
		public int high;
		public Result(boolean flag, int low, int high)
		{
			this.flag = flag;
			this.low = low;
			this.high = high;
		}
	}

	public boolean isBST(TreeNode root)
	{
		Result result = checkBST(root);
		return result.flag;

	}

	public Result checkBST(TreeNode root)
	{
		if(root == null)
			return new Result(true, 0, 0);

		Result left = checkBST(root.left);
		Result right = checkBST(root.right);

		if(left.flag == false || right.flag == false)
			return new Result(false, 0, 0);

		int min = left.low;
		int max = right.high;

		if(root.left == null)
			min = root.value;
		if(root.right == null)
			max = root.value;

		if(root.left != null && left.high > root.value)
			return new Result(false, 0, 0);

		if(root.right != null && right.low <= root.value)
			return new Result(false, 0, 0);

		return new Result(true, min, max);
	}
}

