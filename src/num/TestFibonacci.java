package num;
/**
 * 问题描述：输入一个数n，输出第n个斐波那契数
 * @author kesar
 *
 */
public class TestFibonacci
{
	public static long getFibonacci(int n)
	{
		if(n<=0)
		{
			return 0;
		}
		long sum1=0;
		long sum2=1;
		long temp;
		for(int i=2;i<=n;i++)
		{
			temp=sum2;
			sum2+=sum1;
			sum1=temp;
		}
		return sum2;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		System.out.println(getFibonacci(4));
	}

}
