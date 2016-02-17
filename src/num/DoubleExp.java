package num;

/**
 * 问题描述：实现一个指数运算
 * @author kesar
 *
 */
public class DoubleExp
{
	public static double power(double base,int exp)
	{
		if(equal(base, 0.0))
		{
			return 0.0;
		}
		double result =0.0;
		
		if(exp<0)
		{
			result=1.0/unSignedPower(base, -exp);
		}
		else
		{
			result=unSignedPower(base, exp);
		}
		
		return result;
	}
	
	private static double unSignedPower(double base,int exp)
	{
		if(exp==0)
		{
			return 1.0;
		}
		if(exp==1)
		{
			return base;
		}
		double result=unSignedPower(base, exp>>1);
		result*=result;
		if((exp&1)==1)
		{
			result*=base;
		}
		return result;
	}

	public static boolean equal(double num1,double num2)
	{
		if((num1-num2>-0.0000001)&&(num1-num2<0.0000001))
		{
			return true;
		}
		return false;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		System.out.println(power(-2, -2));
	}

}
