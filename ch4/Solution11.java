import java.util.Random;

public class Solution11 
{
	public class Tree 
	{
		TreeNode root = null;
		public int size() 
		{
			return root == null ? 0 : root.size();
		}
		
		public TreeNode getRandomNode() 
		{
			if (root == null)
				return null;
			Random random = new Random();
			int i = random.nextInt(size());
			return root.getKthNode(i);
		}
	}

	public class TreeNode 
	{
		TreeNode left, right;
		int val;
		int size = 0;
		int size()
		{
			return size;
		}
		
		TreeNode(int x) 
		{
			val = x;
			size = 1;
		}
		
		public TreeNode getKthNode(int k) 
		{
			int leftSize = left == null ? 0 : left.size();
			if (k < leftSize) 
			{
				return left.getKthNode(k);
			} 
			else if (k == leftSize) 
			{
				return this;
			} 
			else 
			{
				return right.getKthNode(k - (leftSize + 1));
			}
		}

		public TreeNode find(int d) 
		{
			if (d == val) 
			{
				return this;
			} 
			else if (d <= val) 
			{
				return left != null ? left.find(d) : null;
			} 
			else if (d >= val) 
			{
				return right != null ? right.find(d) : null;
			}
			return null;
		}
		
		public void insertInOrder(int d) 
		{
			if (d <= val) 
			{
				if (left == null) 
				{
					left = new TreeNode(d);
				} 
				else 
				{
					left.insertInOrder(d);
				}
			} 
			else 
			{
				if (right == null) 
				{
					right = new TreeNode(0);
				} 
				else 
				{
					right.insertInOrder(d);
				}
			}
			size++;
		}
	}
}