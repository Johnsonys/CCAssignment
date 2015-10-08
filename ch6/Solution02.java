import java.util.*;

public class Solution02
{
	/**
	 *  Solution idea:
	 *  Traverse the whole string array with two nodes(cur, dummy)
	 *  The worst time complexity is O(n^2).
	**/

	public void sort(String[] str)
	{
		if(str.length < 3)
			return;

		int cur = 0;
		int dummy = 1;
		while(cur < str.length - 1)
		{
			while(dummy < str.length)
			{
				if(isAnagram(str[cur], str[dummy]))
				{
					String temp = str[cur + 1];
					str[cur + 1] = str[dummy];
					str[dummy] = temp;
					cur++;
				}
				dummy++;
			}
			cur++;
			dummy = cur + 1;
		}
	}

	public boolean isAnagram(String a, String b)
	{
		int[] str = new int[256];
		for(int i = 0; i < a.length(); i++)
			str[(int)a.charAt(i)]++;
		for(int i = 0; i < b.length(); i++)
		{
			if(--str[(int)b.charAt(i)] < 0)
				return false;
		}
		return true;
	}

	public static void main(String[] args)
	{
		Solution02 solu = new Solution02();

		String[] str = {"veil","hear","eel","listen","live","hare","lee","silent","evil"};
		System.out.println(Arrays.toString(str));
		solu.sort(str);
		System.out.println(Arrays.toString(str));
	}
}

