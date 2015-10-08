import java.util.*;

public class Solution04
{
	/**
	 *  Solution idea:
	 *  Use binary search to find the element
	**/

	public int search(Listy arr, int ele)
	{
		int i = 1;
		while(arr.elementAt(i) > -1 && arr.elementAt(i) < ele)
			i = i*2;

		int lo = i/2;
		int hi = i;
		while(lo + 1 < hi)
		{
			int mid = lo + (hi - lo)/2;
			if(ele == arr.elementAt(mid))
				return mid;

			if(ele < arr.elementAt(mid))
				hi = mid;
			else if(arr.elementAt(mid) == -1)
				hi = mid;
			else
				lo = mid;
		}

		if(ele == arr.elementAt(lo))
			return lo;
		if(ele == arr.elementAt(hi))
			return hi;

		return -1;
	}

}

