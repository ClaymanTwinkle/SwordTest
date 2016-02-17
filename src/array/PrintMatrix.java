package array;
/**
 * 问题描述：顺时针打印矩阵
 * 例如：
 * {
 * 	{1,2,3,4}
 * 	{5,6,7,8}
 *  {9,10,11,12}
 *  {13,14,15,16}
 * }
 * 打印结果：1、2、3、4、8、12、16、15、14、13、9、5、6、7、11、10
 * 
 * @author kesar
 * 
 */
public class PrintMatrix
{
	/**
	 * 顺时针打印矩阵
	 * 
	 * @param matrix
	 */
	public static void clockwisePrintMatrix(int[][] matrix)
	{
		// 1.test代码
		if (matrix == null)
		{
			System.err.println("输入矩阵有误");
			return;
		}
		int hight = matrix.length;
		if (hight == 0)
		{
			System.err.println("输入矩阵有误");
			return;
		}
		int width = matrix[0].length;
		for (int i = 1; i < hight; i++)
		{
			if (matrix[i].length != width)
			{
				System.err.println("输入矩阵有误");
				return;
			}
		}
		if (width == 0)
		{
			System.err.println("输入矩阵有误");
			return;
		}

		// 2.核心代码
		int loopNum = width > hight ? (hight + 1) / 2 : (width + 1) / 2;

		printMatrix(matrix, 0, 0, width, hight);
		for (int i = 1; i < loopNum; i++)
		{
			printMatrix(matrix, i, i, width - 2, hight - 2);
		}
		System.out.println();
	}

	/**
	 * 顺时针打印一圈矩阵
	 * 
	 * @param matrix
	 * @param x
	 * @param y
	 * @param xLen
	 * @param yLen
	 */
	private static void printMatrix(int[][] matrix, int x, int y, int xLen,
			int yLen)
	{
		for (int i = 0; i < xLen; i++)
		{
			System.out.print(matrix[y][x + i] + ",");
		}
		for (int i = 1; i < yLen; i++)
		{
			System.out.print(matrix[y + i][x + xLen-1] + ",");
		}
		for (int i = 2; i <=xLen&&yLen!=1; i++)
		{
			System.out.print(matrix[y + yLen-1][x + xLen - i] + ",");
		}
		for (int i = 2; i <yLen&&xLen!=1; i++)
		{
			System.out.print(matrix[y + yLen - i][x] + ",");
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		int[][] matrix = { 
				{ 1,2 ,3},
				{4,5,6},
				{7,8,9},
				{10,11,12},
		};
		clockwisePrintMatrix(matrix);
	}

}
