package array;
import java.util.Arrays;

/**
 * 问题描述：输入一组序列，奇数在前，偶数在后，输出整理后的序列。
 * 
 * @author kesar
 *
 */
public class OddEven
{
	/**
	 * 解法：使用二分法
	 * @param nums
	 */
	public static void reorderOddEven(int[] nums)
	{
		if(nums==null)
		{
			return;
		}
		int left=0;
		int right=nums.length-1;
		while (left<right)
		{
			while (left<right&&nums[left]%2==1)
			{
				left++;
			}
			while (left<right&&nums[right]%2==0)
			{
				right--;
			}
			if(left>=right)
			{
				break;
			}
			exch(nums, left, right);
		}
	}
	
	private static void exch(int[] nums,int index1,int index2)
	{
		if(index1==index2)
		{
			return;
		}
		nums[index1]^=nums[index2];
		nums[index2]^=nums[index1];
		nums[index1]^=nums[index2];
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		int[] nums={2,1,2,-5,2};
		reorderOddEven(nums);
		System.out.println(Arrays.toString(nums));
	}

}
