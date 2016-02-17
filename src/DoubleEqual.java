
public class DoubleEqual
{
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
		double num1=1.000000000000000000000000001;
		double num2=1.000000000000001;
		System.out.println(num1);
		System.out.println(num2);
		System.out.println(num1==num2);
		System.out.println(equal(num1, num2));
	}

}
