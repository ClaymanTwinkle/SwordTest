package array;

import java.util.Arrays;

/**
 * 
 * ClassName: EightQueen
 * 
 * @Description: 
 *               国际象棋的“8皇后问题”：在8x8的国际象棋上摆放8个皇后，使其不能互相攻击，即8个皇后中任意两个不得处在同一行、同一列或同一对角线上
 *               。共有多少种符合条件的摆法？
 * @author kesar
 */
public class EightQueen
{
	/**
	 * 
	 * @Description: 打印所有"8皇后"的可能位置
	 * @param    
	 * @return void  
	 * @throws
	 * @author kesar
	 * @date 2016-2-19
	 */
	public static void eightQueen()
	{
		int[] queens = { 0, 1, 2, 3, 4, 5, 6, 7};
		getAllArrange(queens, 0, queens.length - 1);
	}

	/**
	 * 
	 * @Description: 数组全排列筛选
	 * @param @param nums
	 * @return void
	 */
	private static void getAllArrange(int[] nums, int start, int end)
	{
		if (start > end)
		{
			System.out.println(Arrays.toString(nums));
			return;
		}
		boolean isContinue = false;
		for (int i = start; i <= end; isContinue=false,i++)
		{
			exch(nums, start, i);
			for (int a = start - 1; a >= 0; a--)
			{
				if (isDiagonal(nums, a, start))
				{
					exch(nums, start, i);
					isContinue=true;
					break;
				}
			}
			if(isContinue)
			{
				continue;
			}
			getAllArrange(nums, start + 1, end);
			exch(nums, start, i);
		}
	}

	/**
	 * 
	 * @Description: 判断两个位置是否在同一对角线上
	 * @param @param nums
	 * @param @param i
	 * @param @param j
	 * @param @return
	 * @return boolean
	 */
	private static boolean isDiagonal(int[] nums, int i, int j)
	{
		int result = nums[i] - nums[j];
		return (i - j) == result || (j - i) == result;
	}

	/**
	 * 
	 * @Description: 交换数组中的两个数的值
	 * @param @param nums
	 * @param @param i
	 * @param @param j
	 * @return void
	 */
	private static void exch(int[] nums, int i, int j)
	{
		if (i == j)
			return;
		nums[i] ^= nums[j];
		nums[j] ^= nums[i];
		nums[i] ^= nums[j];
	}

	public static void main(String[] args)
	{
		eightQueen();
	}
}