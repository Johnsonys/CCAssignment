import java.util.*;

public class Stack
{
	/**
	 *  Solution idea:
	 *
	 *  Use a variable to store the minimum element.
	 *  Each element has a "current" minimum value when
	 *  pushed to the stack.
	**/
	public class StackNode
	{
		private int value;
		private StackNode next;
		public StackNode(int value)
		{
			this.value = value;
		}
	}

	public StackNode top;
	public int count = 0;

	public int pop()
	{	
		if(isEmpty())
			throw new EmptyStackException();
		int item = top.value;
		top = top.next;
		count--;
		return item;
	}

	public void push(int item)
	{
		StackNode newNode = new StackNode(item);
		newNode.next = top;
		top = newNode;
		count++;
	}

	public int peek()
	{
		if(isEmpty())
			throw new EmptyStackException();
		return top.value;
	}

	public boolean isEmpty()
	{
		return top == null;
	}

	public boolean isFull()
	{
		return count >= 10;
	}
}