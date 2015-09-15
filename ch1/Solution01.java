import java.util.*;

public class Solution01
{
	//Version1: using HashSet
	public boolean isUniqueV1(String s)
	{
		int len = s.length();

		//Assume the alphabet is 256 characters.
		if(len > 256) 
			return false; 

		HashSet<Character> set = new HashSet<Character>();
		for(int i = 0; i < len; i++)
		{
			char c = s.charAt(i);
			/**
			 *  When the character is already in the Set,
			 *  then jump out of the loop and return false.
			**/
			if(!set.add(c))
				return false;		
		}
		return true;
	}

	//Version2: using boolean array, the space complexity is O(1) 
	public boolean isUniqueV2(String s)
	{
		int len = s.length();

		//Assume the alphabet is 256 characters.
		if(len > 256) 
			return false;

		boolean[] flag = new boolean[256];
		
		for(int i = 0; i < len; i++)
		{
			int chara = s.charAt(i);
			/**
			 *  When the character is already in the array,
			 *  then jump out of the loop and return false.
			**/
			if(flag[chara])
				return false;
			else
				flag[chara] = true;
		}

		return true;
	}

	//If the string is unique, print this sentence.
	public void yes(String s)
	{
		System.out.println("\"" + s + "\"" + " is a unique string");
	}

	//If not unique. print this sentence.
	public void no(String s)
	{
		System.out.println("\"" + s + "\"" + " is not a unique string");
	}

	//Test case
	public static void main(String[] args)
	{
		Solution01 str = new Solution01();

		String s1 = "12345";
		String s2 = "12321";
		String s3 = "Carnegie Mellon Unversity";
		String s4 = "CMU";
		String s5 = "";

		boolean f1 = str.isUniqueV2(s1);
		boolean f2 = str.isUniqueV2(s2);
		boolean f3 = str.isUniqueV2(s3);
		boolean f4 = str.isUniqueV2(s4);
		boolean f5 = str.isUniqueV2(s5);

		if(f1)
			str.yes(s1);
		else
			str.no(s1);
		if(f2)
			str.yes(s2);
		else
			str.no(s2);
		if(f3)
			str.yes(s3);
		else
			str.no(s3);
		if(f4)
			str.yes(s4);
		else
			str.no(s4);
		if(f5)
			str.yes(s5);
		else
			str.no(s5);
	}
}