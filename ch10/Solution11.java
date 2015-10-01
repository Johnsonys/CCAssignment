public class Solution11
{
	/**
	 *  Solution idea:
	 *  When we traverse the array by each two element and set the peak 
	 *  value, then elements between peaks are valleys.
	**/

	public void sort(int[] arr)
	{
		for(int i = 1; i < arr.length; i += 2)
		{
			int max = maxValue(arr, i - 1, i, i + 1);
			if(max != i)
				swap(arr, i, max);
		}
	}

	public int maxValue(int[] arr, int pre, int cur, int post)
	{
		int prev = arr[pre];
		int curv = arr[cur];
		int postv = post < arr.length ? arr[post] : Integer.MIN_VALUE;

		int max = Math.max(prev, Math.max(curv, postv));
		if(max == prev)
			return pre;
		else if(max == curv)
			return cur;
		else
			return post;
	}

	public void swap(int[] arr, int a, int b)
	{
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
}

