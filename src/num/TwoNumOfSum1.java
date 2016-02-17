package num;
import java.util.Arrays;

/**
 * 问题描述：给定一个整型数组，是否能找出其中的两个数使其和为某个指定的值？（假定是无序数组）
 * @author kesar
 *
 */
public class TwoNumOfSum1
{

	/**
	 * 暴力破解
	 * (穷举，时间复杂度：O(n^2)，正常是不会用这个滴，假如只是为了快速解题，对时间没有限制，用这个最简单)
	 * 
	 * @param nums
	 * @param target
	 */
	public static void findTwo1(int[] nums, int target)
	{
		int one, two;
		for (int i = 0; i < nums.length; i++)
		{
			one = nums[i];
			two = target - one;
			for (int j = 0; j < nums.length; j++)
			{
				if (i != j)
				{
					if (two == nums[j])
					{
						System.out.println("one:" + one + " two:" + two);
						return;
					}
				}
			}
		}
		System.out.println("找不到这两个数");
	}

	/**
	 * 两个指针二分查找
	 * (Arrays.sort排序用的是Dual-Pivot Quicksort(快速排序),时间复杂度为O(nlog(n)),while最多O(N)，所以最终程序的时间复杂度为：O(nlo(n)))
	 * 
	 * @param nums
	 * @param target
	 */
	public static void findTwo2(int[] nums, int target)
	{
		// 1.排列
		Arrays.sort(nums);
		// 2.类二分查找
		int left = 0;
		int right = nums.length - 1;
		while (left < right)
		{
			if (nums[left] + nums[right] > target)
			{// 太大 right减少
				right--;
			}
			else if (nums[left] + nums[right] < target)
			{// 太小left增加
				left++;
			}
			else
			{// 找到结果，结束查找
				System.out.println("one:" + nums[left] + " two:" + nums[right]);
				return;
			}
		}
		System.out.println("找不到这两个数");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		int[] nums = { 1, 5, 7, 3 };
		findTwo2(nums, 10);
	}

}
