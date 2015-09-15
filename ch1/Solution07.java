import java.util.*;

public class Solution07
{
	/**
	 *  Solution idea:
	 *
	 *  Rotate every 4 elements which are in relative
	 *  position at a time
	**/
	public void rotate(int[][] matrix, int n)
	{
		int col = n/2;
		int row = (n + 1)/2;
		int temp;
		for(int i = 0; i < col; i++)
		{
			for(int j = 0; j < row; j++)
			{
				temp = matrix[i][j];

				//right -> top
				matrix[i][j] = matrix[j][n - 1 - i];

				//bottom -> right
				matrix[j][n - 1 - i] = matrix[n - 1 - i][n - 1 - j];

				//left -> bottom
				matrix[n - 1 - i][n - 1 - j] = matrix[n - 1 - j][i];

				//top -> left
				matrix[n - 1 - j][i] = temp;
			}
		}
	}		

	//test case
	public static void main(String[] args)
	{
		Solution07 solu = new Solution07();

		int[][] matrix4 = {{1,1,1,1,},{2,2,2,2},{3,3,3,3},{4,4,4,4}};

		System.out.println("Before rotate:");
		for(int i = 0; i < 4; i++)
		{
			System.out.println(Arrays.toString(matrix4[i]));
		}
		solu.rotate(matrix4, 4);
		System.out.println("After rotate:");
		for(int i = 0; i < 4; i++)
		{
			System.out.println(Arrays.toString(matrix4[i]));
		}

		System.out.println();
		System.out.println("***************");
		System.out.println();

		int[][] matrix5 = {{1,1,1,1,1},{2,2,2,2,2},{3,3,3,3,3},{4,4,4,4,4},{5,5,5,5,5}};

		System.out.println("Before rotate:");
		for(int i = 0; i < 5; i++)
		{
			System.out.println(Arrays.toString(matrix5[i]));
		}
		solu.rotate(matrix5, 5);
		System.out.println("After rotate:");
		for(int i = 0; i < 5; i++)
		{
			System.out.println(Arrays.toString(matrix5[i]));
		}
	}
}