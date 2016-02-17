package array;
/**
 * 问题描述：输入一个字符数组，打印出字符的全布组合。例如：输入{a,b,c}输出a、b、c、ab、ac、bc、abc
 * 
 * @author kesar
 * 
 */
public class AllSeqCombination
{
	/**
	 * 从C(1,n)计算到C(n,n)，时间复杂度是C(1,n)+...+C(n,n)=O(2^n)
	 * 应该有不用递归的更优解法吧，但是我一时也想不过来，只能用递归来解。
	 * @param cs
	 */
	public static void printAllSeqCombination(char[] cs)
	{
		if (cs == null || cs.length == 0)
			return;
		for (int i = 1; i <= cs.length; i++)
		{
			printAllSeqCombination(cs, 0, cs.length - 1, 0, i - 1);
		}
	}

	/**
	 * 
	 * @param cs 
	 * @param array_start 能被组合的数组元素开始第一个元素
	 * @param array_end 能被组合的数组元素最后一个元素
	 * @param print_start 要被打印出来的第一个index
	 * @param print_end 要被打印出来的最后一个一个index
	 */
	private static void printAllSeqCombination(char[] cs, int array_start,
			int array_end, int print_start, int print_end)
	{
		if (print_end == array_end)
		{
			System.out.println(new String(cs, print_start, print_end
					- print_start + 1));
			return;
		}
		if (array_start == print_end)
		{
			for (int i = array_start; i <= array_end; i++)
			{
				exch(cs, array_start, i);
				System.out.println(new String(cs, print_start, print_end
						- print_start + 1));
				exch(cs, array_start, i);
			}
			return;
		}
		while (print_end<=array_end)
		{
			printAllSeqCombination(cs, ++array_start, array_end, print_start++, print_end++);
		}
	}

	/**
	 * 
	 * @Description: 交换数组中两个数的值
	 * @param @param cs
	 * @param @param i
	 * @param @param j   
	 * @return void  
	 * @throws
	 */
	private static void exch(char[] cs, int i, int j)
	{
		if (i == j)
			return;
		char temp = cs[i];
		cs[i] = cs[j];
		cs[j] = temp;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		char[] cs = { 'a', 'b', 'c', 'd','e' };
		printAllSeqCombination(cs);
	}

}
