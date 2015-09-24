import java.util.*;

public class Solution05
{
	/**
	 *  Solution idea:
	 *
	 *  When traverse the stack and move it 
	 *  to the sorted stack, we can use a 
	 *  variable to store the minimum element 
	 *  and then push it to the top of the stack.
	**/
	public Stack sort(Stack stack)
	{
		Stack result = new Stack();
		if(stack != null)
		{
			while(!stack.isEmpty())
			{
				int item = stack.pop();
				while(!result.isEmpty() && result.peek() < item)
				{
					stack.push(result.pop());
				}
				result.push(item);
			}
		}
		return result;
	}
}

