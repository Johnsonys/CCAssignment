public class Solution05
{
	/**
	 *  Solution idea:
	 *
	 *  If two strings are one edit or zero edit away, the failure 
	 *  of character comparation must be no more than one time.
	**/
	public boolean isOneAway(String str1, String str2)
	{
		int len1 = str1.length();
		int len2 = str2.length();
		char[] ch1 = str1.toCharArray();
		char[] ch2 = str2.toCharArray();
		
		if(Math.abs(len1 - len2) > 1)
			return false;

		/**
		 *  Parameter "wrong" is used to count the failure of 
		 *  character comparation between two strings.
		**/
		int wrong = 0;
		if(len1 == len2)
		{
			for(int i = 0; i < len1; i++)
			{
				if(ch1[i] != ch2[i])
					wrong++;
			}
			return wrong <= 1;
		}
		else if(len1 > len2)
		{
			for(int i = 0; i < len1 - 1; i++)
			{
				if(wrong == 0)
				{
					if(ch1[i] != ch2[i])
						wrong++;
				}
				if(wrong == 1)
				{
					if(ch1[i + 1] != ch2[i])
						return false;
				}
			}
			return true;
		}
		else
		{
			for(int i = 0; i < len2 - 1; i++)
			{
				if(wrong == 0)
				{
					if(ch1[i] != ch2[i])
						wrong++;
				}
				if(wrong == 1)
				{
					if(ch1[i] != ch2[i + 1])
						return false;
				}
			}
			return true;
		}
	}

	//if two strings are one edit or zero edit away, print this sentence
	public void yes(String str1, String str2)
	{
		System.out.println(str1 + ", " + str2 + "   -> true");
	}

	//if two strings are more than one edit away, print this sentence
	public void no(String str1, String str2)
	{
		System.out.println(str1 + ", " + str2 + "   -> false");
	}

	//test case
	public static void main(String[] args)
	{
		Solution05 solu = new Solution05();

		String s1 = "CMU";
		String s2 = "CAU";
		String s3 = "CU";
		String s4 = "MCU";

		if(solu.isOneAway(s1, s2))
			solu.yes(s1, s2);
		else
			solu.no(s1, s2);
		if(solu.isOneAway(s1, s3))
			solu.yes(s1, s3);
		else
			solu.no(s1, s3);
		if(solu.isOneAway(s1, s4))
			solu.yes(s1, s4);
		else
			solu.no(s1, s4);
	}
}