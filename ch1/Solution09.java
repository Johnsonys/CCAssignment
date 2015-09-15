public class Solution09
{
	/**
	 *  Solution idea:
	 *
	 *  Because str1 + str1 includes all possible 
	 *  rotation of str1, we can check if str2 is 
	 *  a rotation of str1 by checking if str2 is
	 *  a substring of str1.
	**/
	public boolean isRotation(String str1, String str2)
	{
		if(str1.length() != str2.length())
			return false;
		else
		{
			String str3 = str1 + str1;
			return isSubstring(str3, str2);
		}
	}
}