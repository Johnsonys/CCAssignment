import java.util.*;

public class Solution05
{
	/**
	 *  Solution idea:
	 *  Binary search can be a choice, but maybe not the best solution.
	 *  "for loop" is a easier way to implement.
	 *  
	**/

	public int search(String[] str, String target)
	{
		for(int i = 0; i < str.length; i++)
		{
			if(str[i].equals(target))
				return i;
		}
		return -1;
	}
}

