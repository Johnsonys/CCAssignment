public class Solution06
{
	/**
	 *  Solution idea:
	 *
	 *  Everytime the probe moves to a new character,
	 *  we should update the compressd string.
	**/
	public void compress(String str)
	{
		/**
		 *  If the string is less than three characters,
		 *  the "compressed" string could not be smaller
		 *  than the original string.
		**/
		if(str.length() < 3)
		{
			System.out.println(str);
			return;
		}

		StringBuilder result = new StringBuilder();
		char ch = str.charAt(0);
		int count = 1;

		for(int i = 1; i < str.length(); i++)
		{
			while(i < str.length() && str.charAt(i) == str.charAt(i - 1))
			{
				count++;
				i++;
			}
			result.append(ch);
			result.append(count);
			if(i < str.length())
			{
				ch = str.charAt(i);
				count = 1;
			}
		}
		
		/**
		 *  If the last character is different from the
		 *  former one, we should add it to the string.
		**/
		if(count == 1)
		{
			result.append(ch);
			result.append(count);
		}

		if(result.length() < str.length())
		{
			System.out.println(result);
			return;
		}
		else
			System.out.println(str);
	}	

	//test case
	public static void main(String[] args)
	{
		Solution06 solu = new Solution06();

		String s1 = "CMU";
		String s2 = "CMUUUUUUUUUUU";
		String s3 = "aabcccccaaa";

		System.out.print(s1 + "   ->   ");
		solu.compress(s1);
		System.out.print(s2 + "   ->   ");
		solu.compress(s2);
		System.out.print(s3 + "   ->   ");
		solu.compress(s3);
	}
}