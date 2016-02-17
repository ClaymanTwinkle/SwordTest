package array;

/**
 * 问题描述：二维数组中的查找
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样一个二维数组和一个整数，判断数组中是否包含该整数
 * 例如：
 * {
 * 	{1,2,3,4}
 *  {2,4,6,7}
 *  {4,5,7,8}
 *  {6,7,8,9}
 * }
 * 
 * @author kesar
 *
 */
public class TwoDArray
{
	/**
	 * 查找。我们从二维数组左下角找起会很快。(以下计算过程画个二维数组图，然后一行一行代码看会很容易理解的)
	 * @param nums 二维数组
	 * @param target 目标整数
	 * @param column 取小列
	 * @param row 取最大行
	 * @return
	 */
	public static boolean findNum(int[][] nums,int target,int column,int row)
	{
		if(nums==null)
		{// 防止 null异常
			return false;
		}
		while (column>0&&row>0)
		{
			int current=nums[row-1][column-1]; //当前值
			
			if(current>target)
			{// 当前值太大，缩行(向上面一行走,因为上面一行值会小一点)
				--row;
			}
			else if(current<target)
			{// 当前值太小，缩列(向右边一列走,因为右边一列值会大一点)
				++column;
			}
			else
			{// 找到值
				return true;
			}
		}
		
		return false;
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		int[][] nums={
				{1,2,8,9},
				{2,4,9,12},
				{4,7,10,13},
				{6,8,11,15}
		};
		System.out.println(findNum(nums, 15, 1, nums.length));
	}

}
