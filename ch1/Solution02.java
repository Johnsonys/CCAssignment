public class Solution02
{
	/**
	 *  Solution idea:
	 *
	 *  If two strings have same characters, they are
	 *  permutation to each other.
	**/
	public boolean isPermute(String str1, String str2)
	{
		if(str1.length() != str2.length())
			return false;

		for(int i = 0; i < str1.length(); i++)
		{
			char c1 = str1.charAt(i);
			boolean flag = false;
			for(int j = 0; j < str2.length(); j++)
			{
				char c2 = str2.charAt(j);
				/**
				 *  If str1 and str2 have same character,
				 *  then remove this character from str2
				 *  and jump out of the loop.
				**/
				if(c1 == c2)
				{
					flag = true;
					str2 = str2.substring(0, j) + str2.substring(j + 1);
					continue;
				}
			}
			if(flag == false)
				return false;
		}
		return true;
	}	

	//If the string is permutation, print this sentence.
	public void yes(String str1, String str2)
	{
		System.out.println("\"" + str2 + "\"" + " is a permutaiton of " + "\"" + str1 + "\"");
	}

	//If not permutation, print this sentence.
	public void no(String str1, String str2)
	{
		System.out.println("\"" + str2 + "\"" + " is not a permutaiton of " + "\"" + str1 + "\"");
	}

	//Test case
	public static void main(String[] args)
	{
		Solution02 solu = new Solution02();

		String s1 = "CMU";
		String s2 = "cmu";
		String s3 = "CAU";
		String s4 = "MCU";
		String s5 = "";

		boolean f1 = solu.isPermute(s1, s2);
		boolean f2 = solu.isPermute(s1, s3);
		boolean f3 = solu.isPermute(s1, s4);
		boolean f4 = solu.isPermute(s1, s5);

		if(f1)
			solu.yes(s1, s2);
		else
			solu.no(s1, s2);
		if(f2)
			solu.yes(s1, s3);
		else
			solu.no(s1, s3);
		if(f3)
			solu.yes(s1, s4);
		else
			solu.no(s1, s4);
		if(f4)
			solu.yes(s1, s5);
		else
			solu.no(s1, s5);
	}
}