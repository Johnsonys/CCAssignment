import java.util.*;

public class Solution08
{
	/**
	 *  Solution idea:
	 *
	 *  Make the first row and the first column as the signal
	 *  space to store the information of zero. So that we can
	 *  solve the question in O(1) space.
	**/
	public void zero(int[][] matrix, int row, int col)
	{
		boolean isRowZero = false;
		boolean isColZero = false;

		//find if the first column and first row has zero
		for(int j = 0; j < col; j++)
		{
			if(matrix[0][j] == 0)
			{
				isRowZero = true;
				break;
			}
		}
		for(int i = 0; i < row; i++)
		{
			if(matrix[i][0] == 0)
			{
				isColZero = true;
				break;
			}
		}

		/**
		 *  Traverse the rest matrix to find if there is
		 *  a zero element. If yes, mark the row and column of
		 *  this element by setting the first element to zero.
		**/
		for(int i = 1; i < row; i++)
		{
			for(int j = 1; j < col; j++)
			{
				if(matrix[i][j] == 0)
				{
					matrix[0][j] = 0;
					matrix[i][0] = 0;
				}
			}
		}

		//set the labled row and column to zero
		for(int j = 1; j < col; j++)
		{
			if(matrix[0][j] == 0)
			{
				for(int i = 0; i < row; i++)
					matrix[i][j] = 0;
			}
		}
		for(int i = 0; i < row; i++)
		{
			if(matrix[i][0] == 0)
			{
				for(int j = 0; j < col; j++)
					matrix[i][j] = 0;
			}
		}

		if(isRowZero)
			for(int j = 0; j < col; j++)
					matrix[0][j] = 0;
		else if(isColZero)
			for(int i = 0; i < row; i++)
					matrix[i][0] = 0;
	}

	//test case
	public static void main(String[] args)
	{
		Solution08 solu = new Solution08();

		int[][] matrix4 = {{1,0,1,1,},{2,2,2,2},{3,3,0,3},{4,4,4,4}};

		System.out.println("Before set to zero:");
		for(int i = 0; i < 4; i++)
		{
			System.out.println(Arrays.toString(matrix4[i]));
		}
		solu.zero(matrix4, 4, 4);
		System.out.println("After set to zero:");
		for(int i = 0; i < 4; i++)
		{
			System.out.println(Arrays.toString(matrix4[i]));
		}

		System.out.println();
		System.out.println("***************");
		System.out.println();

		int[][] matrix5 = {{1,1,1,1,1},{2,2,2,2,2},{3,3,0,3,3},{4,4,4,4,4}};

		System.out.println("Before set to zero:");
		for(int i = 0; i < 4; i++)
		{
			System.out.println(Arrays.toString(matrix5[i]));
		}
		solu.zero(matrix5, 4, 5);
		System.out.println("After set to zero:");
		for(int i = 0; i < 4; i++)
		{
			System.out.println(Arrays.toString(matrix5[i]));
		}
	}
}