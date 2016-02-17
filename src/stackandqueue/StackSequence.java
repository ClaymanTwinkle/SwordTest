package stackandqueue;
import java.util.Stack;

/**
 * 输入数字不重复的两个整数序列A,B，A是某栈的压栈的序列，B是某栈的出栈的序列，验证AB是否为同一栈的序列
 * @author kesar
 *
 */
public class StackSequence
{
	public static boolean isStackSeq(int[] pushSeq, int[] popSeq)
	{
		if (popSeq == null || pushSeq == null
				|| pushSeq.length != popSeq.length)
		{
			return false;
		}
		Stack<Integer> stack = new Stack<Integer>();
		int pushIndex = 0;
		int popIndex = 0;

		while (popIndex < popSeq.length)
		{
			if (pushIndex < pushSeq.length)
			{
				if (pushSeq[pushIndex] == popSeq[popIndex])
				{
					pushIndex++;
					popIndex++;
					continue;
				}
				if (!stack.isEmpty() && stack.peek() == popSeq[popIndex])
				{
					stack.pop();
					popIndex++;
				}
				else
				{
					stack.push(pushSeq[pushIndex++]);
				}
			}
			else if (!stack.isEmpty() && stack.pop() == popSeq[popIndex])
			{
				popIndex++;
			}
			else
			{
				return false;
			}
		}

		return stack.isEmpty();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		int[] pushSeq = { 1, 4, 3, 4 };
		int[] popSeq = { 4, 4, 3, 1 };

		System.out.println(isStackSeq(pushSeq, popSeq));
	}

}
