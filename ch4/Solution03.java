import java.util.*;

public class Solution03
{
	/**
	 *  Solution idea:
	 *  Use a queue to store the TreeNode of each level. We can
	 *  distinguish two levels by adding a dummy node at the end
	 *  of each level.
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

	public ArrayList<LinkedList<TreeNode>> list(TreeNode root)
	{
		LinkedList<TreeNode> list = new LinkedList<TreeNode>();
		ArrayList<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();

		TreeNode dummy = new TreeNode(0);
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		queue.offer(dummy);

		while(!queue.isEmpty())
		{
			TreeNode node = queue.poll();
			if(node != dummy)
			{
				queue.offer(node.left);
				queue.offer(node.right);
				list.add(node);
			}
			else
			{
				queue.offer(node);
				result.add(list);
				list.clear();
			}
		}

		return result;
	}
}

