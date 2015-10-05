import java.util.*;

public class Solution03 
{
	/**
	 *  Solution idea:
	 *
	 *  We assume that the capacity of each stack is 10
	 *  element. 
	 *  For the follow up question, we assume that stacks 
	 *  before the last stack can operate at unfull capacity.
	**/
	ArrayList<Stack> set = new ArrayList<Stack>();
	Stack stack;

	//use a pointer to store the last stack index
	private int cur = 0;

	public Solution03()
	{
		stack = new Stack();
		set.add(stack);
	}

	public void push(int item)
	{
		Stack stack = set.get(cur);
		if(stack.isFull())
		{
			cur++;
			Stack newStack = new Stack();
			newStack.push(item);
			set.add(cur, newStack);
			return;
		}
		stack.push(item);
		set.add(cur, stack);
	}

	public int pop()
	{
		Stack stack = set.get(cur);
		if(stack.isEmpty())
			throw new EmptyStackException();
		int result = stack.pop();
		while(set.get(cur).isEmpty())
		{
			set.remove(cur);
			cur = Math.min(0, --cur);
		}
		return result;
	}
	//follow up
	public int popAt(int index)
	{
		Stack stack = set.get(index);
		if(stack.isEmpty())
			throw new EmptyStackException();
		int result = stack.pop();
		if(index == cur)
		{
			while(set.get(cur).isEmpty())
			{
				set.remove(cur);
				cur = Math.min(0, --cur);
			}
		}
		return result;
	}
}

