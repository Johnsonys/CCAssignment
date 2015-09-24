import java.util.EmptyStackException;

public class Solution01<T>
{
	/**
	 *  Solution idea:
	 *
	 *  Use a constant space of array to store the value
	 *  of stacks. Each stack is allocated 1/3 space of 
	 *  the array.
	**/
	private Object[] value = new Object[30];
	private int[] top = {0,0,10,20};

	public boolean isEmpty(int index)
	{
		if(index == 1)
			return top[1] == 0;
		if(index == 2)
			return top[2] == 10;
		else
			return top[3] == 20;
	}

	public boolean isFull(int index)
	{
		return top[index]%10 == 0;
	}

	public T pop(int index)
	{	
		if(isEmpty(index))
			throw new EmptyStackException();
		return (T)value[--top[index]];
	}

	public void push(int index, T item)
	{
		if(isFull(index))
			return;//throw new FullStackException();
		value[top[index]++] = item;
	}

	public T peek(int index)
	{
		if(isEmpty(index))
			throw new EmptyStackException();
		return (T)value[top[index]];
	}
}