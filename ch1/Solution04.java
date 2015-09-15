public class Solution04
{
	/**
	 *  Solution idea:
	 *
	 *  All we need to know is that no more than one character appears odd times.
	 *  So we can use boolean array to store the count of each character.
	 *  If the character appears odd times, the boolean result is true.
	 *  If the character appears even times, the boolean result is false.
	 *  Then, we just need to count the number of "true".
	**/
	public boolean isPermutation(String str)
	{	
		//assume the alphabet is 256 characters
		boolean[] isOdd = new boolean[256];			
		char[] ch = str.toCharArray();
		int count = 0;		
		
		for(int i = 0; i < str.length(); i++)
		{
			isOdd[(int)ch[i]] = !isOdd[(int)ch[i]];
		}
		char space = ' ';
		isOdd[(int)space] = false;
		for(int i = 0; i < 256; i++)
		{
			if(isOdd[i])
				count++;
		}
		return count <= 1;
	}

	//if the string is a permutation of palindrome, print this sentence
	public void yes(String str)
	{
		System.out.println("\"" + str + "\" is a permutation of palindrome");
	}

	//if the string is not a permutation of palindrome, print this sentence
	public void no(String str)
	{
		System.out.println("\"" + str + "\" is not a permutation of palindrome");
	}

	//test case
	public static void main(String[] args)
	{
		Solution04 solu = new Solution04();

		String s1 = "CMU";
		String s2 = "CNN";
		String s3 = "CNN ";
		String s4 = "    ";

		if(solu.isPermutation(s1))
			solu.yes(s1);
		else
			solu.no(s1);
		if(solu.isPermutation(s2))
			solu.yes(s2);
		else
			solu.no(s2);
		if(solu.isPermutation(s3))
			solu.yes(s3);
		else
			solu.no(s3);
		if(solu.isPermutation(s4))
			solu.yes(s4);
		else
			solu.no(s4);
	}
}