import java.util.*;

public class Solution03
{
	/**
	 *  Solution idea:
	 *  Use binary search to find the element
	**/

	public int search(int[] arr, int ele)
	{
		int lo = 0;
		int hi = arr.length - 1;
		int mid;

		while(lo + 1 < hi)
		{
			mid = lo + (hi - lo)/2;
			if(ele == arr[mid])
				return mid;
			if(arr[lo] < arr[mid])
			{
				if(arr[lo] < ele && ele <= arr[mid])
					hi = mid;
				else
					lo = mid;
			}
			else
			{
				if(arr[mid] <= ele && ele <= arr[hi])
					lo = mid;
				else
					hi = mid;
			}
		}
		if(ele == arr[lo])
			return lo;
		else if(ele == arr[hi])
			return hi;
		else 
			return -1;
	}

	public static void main(String[] args)
	{
		Solution03 solu = new Solution03();

		int[] a = {7,8,1,2,3,4,5,6};

		System.out.println(Arrays.toString(a));
		System.out.print("The index of 8 is: ");
		System.out.println(solu.search(a, 8));
		System.out.print("The index of 1 is: ");
		System.out.println(solu.search(a, 1));
	}
}

