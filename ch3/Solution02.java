import java.util.*;

public class Solution02
{
	/**
	 *  Solution idea:
	 *
	 *  Use a variable to store the minimum element.
	 *  Each element has a "current" minimum value when
	 *  pushed to the stack.
	**/
	private static class StackNode
	{
		private int value;
		private int minValue;
		private StackNode next;
		public StackNode(int value, int min)
		{
			this.value = value;
			this.minValue = min;
		}
	}

	private StackNode top;
	
	public boolean isEmpty()
	{
		return top == null;
	}

	public int pop()
	{	
		if(isEmpty())
			throw new EmptyStackException();
		int item = top.value;
		top = top.next;
		return item;
	}

	public void push(int item)
	{
		int minV = Math.min(item, min());
		StackNode newNode = new StackNode(item, minV);
		newNode.next = top;
		top = newNode;
	}

	public int peek()
	{
		if(isEmpty())
			throw new EmptyStackException();
		return top.value;
	}

	public int min()
	{
		if(isEmpty())
			throw new EmptyStackException();
		return top.minValue;
	}
}