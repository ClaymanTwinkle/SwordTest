package num;
/**
 * 输入n，从1依次打印到n进制最大值。比如n=3,依次打印从1到999.
 * @author kesar
 *
 */
public class PrintN_Num
{
	public static void printN(int n)
	{
		if (n <= 0)
		{
			System.out.println("n不能小于0或等于0");
			return;
		}
		StringBuilder sb = new StringBuilder(n);
		for(int i=0;i<n;i++)
		{
			sb.append('0');
		}
		for (int i = n - 1; i >= 0; i--)
		{
			while (sb.charAt(i) != '9')
			{
				int overTake = 0;
				if (sb.charAt(0) != '9')
				{
					sb.setCharAt(0, (char) (sb.charAt(0) + 1));
				}
				else
				{
					sb.setCharAt(0, '0');
					overTake++;
				}
				increaseNum(sb, 1, overTake);
			}
		}
	}

	/**
	 * 数的增加
	 * 使用递归
	 * @param sb
	 * @param index
	 * @param overTake
	 */
	private static void increaseNum(StringBuilder sb, int index, int overTake)
	{
		if (index > sb.length())
		{
			return;
		}
		if(overTake == 0)
		{
			printN(sb);
			return;
		}
		int zero='0';
		int result = (int) sb.charAt(index) - zero + overTake;
		overTake = result / 10;
		sb.setCharAt(index, (char)(zero+result%10));
		increaseNum(sb, index+1, overTake);
	}

	/**
	 * 打印数组
	 * 需要处理高位的0，还有需要逆序打印数组
	 * @param sb
	 */
	private static void printN(StringBuilder sb)
	{
		int i = sb.length() - 1;
		for (; i >= 0; i--)
		{
			char c = sb.charAt(i);
			if (c != '0')
			{
				break;
			}
		}
		StringBuilder copy_sb = new StringBuilder(sb.subSequence(0, i + 1));
		copy_sb.reverse();
		System.out.println(copy_sb);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		printN(10);
	}

}
