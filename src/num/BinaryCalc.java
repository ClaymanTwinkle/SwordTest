package num;


/**
 * 问题描述：二进制计算
 * @author kesar
 *
 */
public class BinaryCalc
{
	/**
	 * 判断一个整数是不是2的整数次方
	 * @param num
	 * @return
	 */
	public static boolean is2Exp(int num)
	{
		if(num==0)
		{
			return false;
		}
		return (num&(num-1))==0;
	}
	
	/**
	 * 计算二进制m需要改变多少位才会变成n
	 * @param m
	 * @param n
	 * @return
	 */
	public static int calcEqualBit(int m,int n)
	{
		int num=m^n;
		int count=0;
		while (num!=0)
		{
			count++;
			num=num&(num-1);
		}
		return count;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		System.out.println(calcEqualBit(10,13));
	}

}
