package num;

/**
 * 计算出二进制数中1的个数
 * @author kesar
 *
 */
public class NumberOf1InBinary
{
	/**
	 * num右移作为循环，1与num最右一位，若不为0，则1的个数++
	 * 难点：需要处理负数的情况，将num取反后计算，得到原码num的0个数，然后用32减去0个数就可以得到1的个数
	 * @param num
	 * @return
	 */
	public static int calc1(int num)
	{
		int count=0;
		boolean isNeg=false;
		if(num<0)
		{
			num=~num;
			isNeg=true;
		}
		while (num!=0)
		{
			if((num&1)==1)
			{
				count++;
			}
			num>>=1;
		}
		if(isNeg)
		{
			count=32-count;
		}
		return count;
	}
	
	/**
	 * 通过flag左移做一周的循环来与num的每一位，若与计算的结果不为0，则1的个数++
	 * @param num
	 * @return
	 */
	public static int calc2(int num)
	{
		int count=0;
		int flag=1;
		while (flag!=0)
		{
			if((num&flag)!=0)
			{
				count++;
			}
			flag<<=1;
		}
		
		return count;
	}
	
	/**
	 * num不为0时，num-1后的值与num相与都会消除一个1，按照这一点，可以很快计算出1个个数，最佳算法
	 * @param num
	 * @return
	 */
	public static int calc3(int num)
	{
		int count=0;
		while (num!=0)
		{
			num=num&(num-1);
			count++;
		}
		return count;
	}
	
	
	
	public static void main(String[] args)
	{
		System.out.println(calc1(0x80000000));
		System.out.println(calc2(0x80000000));
		System.out.println(calc3(0x80000000));
	}
}
