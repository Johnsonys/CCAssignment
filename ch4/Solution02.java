public class Solution02
{
	/**
	 *  Solution idea:
	 *  Create the binary search tree through a recursive way.
	**/

	class TreeNode
	{
		int value;
		TreeNode left;
		TreeNode right;
		public TreeNode(int val)
		{
			this.value = val;
			this.right = null;
			this.left = null;
		}
	}

	public TreeNode minTree(int[] arr)
	{
		return minTree(arr, 0, arr.length - 1);
	}

	public TreeNode minTree(int[] arr, int lo, int hi)
	{
		if(lo > hi)
			return null;
		
		int middle = lo + (hi - lo)/2;
		TreeNode root = new TreeNode(arr[middle]);
		root.left = minTree(arr, lo, middle - 1);
		root.right = minTree(arr, middle + 1, hi);

		return root;
	}
}

