package array;
/**
 * 问题描述：输入一个字符串，打印出字符串的全排列
 * 
 * @author kesar
 * 
 */
public class AllSeqArrange
{
	/**
	 * test+递归
	 * @param seq
	 */
	public static void printAllSeq(String seq)
	{
		if (seq == null || "".equals(seq))
		{
			return;
		}
		char[] cs = seq.toCharArray();
		printAllSeq(cs, 0, cs.length - 1);
	}

	/**
	 * 解法：递归。遍历每个字符交换到第一位，第一位的后面剩下字符进入递归，当无剩下字符可以进入递归时，打印输出字符数组。
	 * @param cs
	 * @param start
	 * @param end
	 */
	private static void printAllSeq(char[] cs, int start, int end)
	{
		if (start > end)
		{
			System.out.println(cs);
			return;
		}
		for (int i = start; i <= end; i++)
		{
			exch(cs, start, i);
			printAllSeq(cs, start + 1, end);
		}
	}

	/**
	 * 交换字符数组中的两个字符
	 * @param cs
	 * @param i
	 * @param j
	 */
	private static void exch(char[] cs, int i, int j)
	{
		if (i == j)
		{
			return;
		}
		char temp = cs[i];
		cs[i] = cs[j];
		cs[j] = temp;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		printAllSeq("abcd");
	}

}
