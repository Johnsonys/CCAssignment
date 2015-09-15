public class Solution03
{
	public void replaceSpace(char[] ch, int len)
	{
		int space = 0, newlen;

		//find all spaces in the "true" length
		for(int i = 0; i < len; i++)
		{
			if(ch[i] == ' ')
				space++;
		}

		//the length of new string
		newlen = len + 2*space;

		//fullfill the new string, start from the end
		for(int i = newlen - 1; i >= 0; i--)
		{
			if(ch[len - 1] != ' ')
			{
				ch[i] = ch[len - 1];
				len--;
			}
			else
			{
				ch[i--] = '0';
				ch[i--] = '2';
				ch[i] = '%';
				len--;
			}
		}
	}

	//test case
	public static void main(String[] args)
	{
		Solution03 solu = new Solution03();

		char[] ch15 = {' ', ' ', 'C', ' ', 'M', ' ', 'U', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
		char[] ch18 = {' ', ' ', 'C', ' ', 'M', ' ', 'U', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
		
		System.out.print("Original String: \"");
		System.out.print(ch15);
		System.out.println("\"" + "   (true length is 7)");
		solu.replaceSpace(ch15, 7);
		System.out.print("After replace: \"");
		System.out.print(ch15);
		System.out.println("\"");

		System.out.print("Original String: \"");
		System.out.print(ch18);
		System.out.println("\"" + "   (true length is 8)");
		solu.replaceSpace(ch18, 8);
		System.out.print("After replace: \"");
		System.out.print(ch18);
		System.out.println("\"");
	}
}