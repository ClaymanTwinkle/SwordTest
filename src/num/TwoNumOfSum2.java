package num;
import java.util.Arrays;
import java.util.HashMap;


/**
 * 问题描述：
 * 给定一个整型的数组，找出其中的两个数使其和未指定的值，返回两个数的数组下标（假定是无序数组，数组元素各不相同，要求时间复杂度为O(n),n为数组长度,可以使用辅助空间）
 * @author kesar
 *
 */
public class TwoNumOfSum2
{

	/**
	 * 使用辅助空间(使用哈希表，时间复杂度是O(n),空间复杂度：O(n),n是数组大小)
	 * @param nums
	 * @param target
	 * @return 没有找到的话数组中数值就是{-1,-1}，否则找到，其实我想返回null的，但是觉得返回null不礼貌，因为null有毒
	 */
	public static int[] findTwo3(int[] nums, int target)
	{
		// 结果数组
		int[] result={-1,-1};
		// 目标是数组下标，所以键值对为<数值,数值对应数组下标>，这里要说一下，哈希表的查找的时间复杂度是O(1)
		HashMap<Integer, Integer> map=new HashMap<Integer, Integer>();
		// 1.扫描一遍数组，加入哈希表，时间复杂度是O(n)
		for(int i=0;i<nums.length;i++)
		{
			map.put(nums[i], i);
		}
		// 2.第二次扫描，目标值-当前值，差值作为key，看看map里有木有，没有就下一个循环，直到数组扫描完毕或找到value,所以最坏情况的时间复杂度是O(n)
		for(int i=0;i<nums.length;i++)
		{
			// 得到第二个数的值
			int two=target-nums[i];
			// 如果存在第二个数的数组下标&&结果的两个数不是同一个数的值
			if(map.containsValue(two)&&target!=2*two)
			{
				result[0]=i;
				result[1]=map.get(two);
				// 返回找到的两个数的数组下标
				return result;
			}
		}
		// 没有找到
		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		int[] nums = { 1, 5, 7, 3 };
		System.out.println(Arrays.toString(findTwo3(nums, 10)));;
	}

}
