import java.util.*;

public class Solution01
{
	/**
	 *  Solution idea:
	 *  Since array A and B are both sorted, we can use binary search 
	 *  to insert element from B into A.
	 *  
	 *  Also, we can merge A and B backwards.
	**/

	public void merge(int[] a, int[] b, int len) //"len" represent the "true" length of array A
	{
		int start = 0;
		int count = 0;
		for(int i = 0; i < b.length; i++)
		{
			start = insert(a, b[i], start, len - 1 + count);
			for(int j = len - 1 + count; j >= start; j--)
				a[j + 1] = a[j];
			a[start] = b[i];
			count++;
		}
	}

	public int insert(int[] a, int ele, int start, int end)
	{
		int middle;
		while(start < end)
		{
			middle = start + (end - start)/2;
			if(ele < a[middle])
				end = middle - 1;
			else if(ele > a[middle])
				start = middle + 1;
			else
				return middle;
		}
		if(ele > a[start])
			return start + 1;
		return start;
	}

	public static void main(String[] args)
	{
		Solution01 solu = new Solution01();

		int[] a = {1,3,5,7,9,0,0,0,0,0};
		int[] b = {2,4,6,8,10};

		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(b));
		solu.merge(a,b,5);
		System.out.println(Arrays.toString(a));
	}
}

