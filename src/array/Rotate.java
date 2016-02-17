package array;
import java.util.Arrays;


/**
 * 问题描述：返回将一维数组向右旋转k个位置的结果。
 * 比如，一维数组{1,2,3,4,5}，k=2时，返回结果是{4,5,1,2,3}。
 * 要求常数级空间复杂度，允许修改原有数组。
 * 
 * @author kesar
 *
 */
public class Rotate
{
	
	public static int[] rotateK(int[] datas,int k)
	{
		reverse(datas, 0, datas.length-1);
		reverse(datas, 0, k-1);
		reverse(datas,k,datas.length-1);
		return datas;
	}
	
	/**
	 * 反转start和end之间的数
	 * @param datas
	 * @param start
	 * @param end
	 */
	public static void reverse(int[] datas,int start,int end)
	{
		while(start<end)
		{
			// 交换两个数的值
			datas[start]^=datas[end];
			datas[end]^=datas[start];
			datas[start]^=datas[end];
			start++;
			end--;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		int[] datas={1,2,3,4,5};
		System.out.println(Arrays.toString(rotateK(datas, 2)));
	}

}
