import java.util.*;

public class Solution04
{
	/**
	 *  Solution idea:
	 *
	 *  We need to implement a reverse function
	 *  to reverse the order of stack. When remove
	 *  or peek the queue, we just need to pop or 
	 *  peek the reversed stack.
	**/
	public Stack stack;
	public Stack queue;

	public Solution04()
	{
		stack = new Stack();
		queue = new Stack();
	}

	public void add(int item)
	{
		stack.push(item);
	}

	public int remove()
	{
		reverse();
		return queue.pop();
	}

	public int peek()
	{
		reverse();
		return queue.peek();
	}

	public void reverse()
	{
		if(queue.isEmpty())
			while(!stack.isEmpty())
			{
				int item = stack.pop();
				queue.push(item);
			}
	}
}

