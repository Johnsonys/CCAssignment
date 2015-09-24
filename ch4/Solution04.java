import java.util.*;

public class Solution04
{
	/**
	 *  Solution idea:
	 *  We can use a class to store the lowest height and the 
	 *  highest height of each node through a recursive way.
	 *
	 *  P.S. "isBanlanced" function implement this algorithm. 
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
		public int low;
		public int high;
		public Result(int lo, int hi)
		{
			this.low = lo;
			this.high = hi;
		}
	}

	public boolean isBanlanced(TreeNode root)
	{
		Result rootResult = checkBanlanced(root);
		return (rootResult.high - rootResult.low) <= 1;
	}

	public Result checkBanlanced(TreeNode root)
	{
		if(root == null)
			return new Result(0, 0);

		Result left = checkBanlanced(root.left);
		Result right = checkBanlanced(root.right);
		Result rootResult = new Result(Math.min(left.low, right.low) + 1, Math.max(left.high, right.high) + 1);
		return rootResult;
	}
}

