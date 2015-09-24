import java.util.*;

public class Solution12
{
	class TreeNode
	{
		public int data;
		public TreeNode left;
		public TreeNode right;
		public TreeNode(int val)
		{
			this.data = val;
			this.right = null;
			this.left = null;
		}
	}

	public static int countPathsWithSum(TreeNode root, int targetSum) 
	{
		if (root == null)
			return 0;
		HashMap<Integer, Integer> pathCount = new HashMap<Integer, Integer>();
		incrementHashTable(pathCount, 0, 1);
		return countPathsWithSum(root, targetSum, 0, pathCount);
	}

	public static int countPathsWithSum(TreeNode node, int targetSum, int runningSum, HashMap<Integer, Integer> pathCount) 
	{
		if (node == null) 
		{
			return 0;
		}
		runningSum += node.data;
		incrementHashTable(pathCount, runningSum, 1);

		//Count paths with sum ending at the current node.
		int sum = runningSum - targetSum;
		int totalPaths = pathCount.containsKey(sum) ? pathCount.get(sum) : 0;

		//Count paths with sum on the left and right.
		totalPaths += countPathsWithSum(node.left, targetSum, runningSum, pathCount);
		totalPaths += countPathsWithSum(node.right, targetSum, runningSum, pathCount);

		incrementHashTable(pathCount, runningSum, -1);
		return totalPaths;
	}

	public static void incrementHashTable(HashMap<Integer, Integer> hashTable, int key, int t) 
	{
		//Put the data needed into the HashMap<key, value>, key is the runningsum, value is the count
		if (!hashTable.containsKey(key)) 
		{
			hashTable.put(key, 1);
		}
		else
		{
			hashTable.put(key, hashTable.get(key) + t);
		}
	}
}

