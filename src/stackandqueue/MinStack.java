package stackandqueue;
import java.util.EmptyStackException;
import java.util.Stack;

/**
 * 问题描述：实现栈的pop、push、min(得到栈中最小值)方法
 * 
 * @author kesar
 * 
 */
public class MinStack
{
	private Stack<Integer> dataStack = new Stack<Integer>();
	private Stack<Integer> minStack = new Stack<Integer>();

	/**
	 * 出栈
	 * @return
	 */
	public int pop()
	{
		if (minStack.isEmpty() && dataStack.isEmpty())
		{
			throw new EmptyStackException();
		}
		minStack.pop();
		return dataStack.pop();
	}

	/**
	 * 压栈
	 * @param item
	 */
	public void push(int item)
	{
		dataStack.push(item);
		if(minStack.isEmpty()||item<minStack.peek())
		{
			minStack.push(item);
		}
		else
		{
			minStack.push(minStack.peek());
		}
	}
	
	/**
	 * 取最小值
	 * @return
	 */
	public int min()
	{
		if(minStack.isEmpty())
		{
			throw new EmptyStackException();
		}
		return minStack.peek();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

}
