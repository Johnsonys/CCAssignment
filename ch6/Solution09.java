public class Solution09
{
	/**
	 *  Solution idea:
	 *  Search from left-down to right-up.
	**/

	public boolean search(int[][] matrix, int M, int N, int ele)
	{
		int row = M - 1;
		int col = 0;

		while(row >= 0 && col < N)
		{
			if(matrix[row][col] == ele)
				return true;

			if(matrix[row][col] < ele)
				col++;
			else
				row--;
		}
		return false;
	}

}

