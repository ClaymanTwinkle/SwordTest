package stackandqueue;
import java.util.Stack;

/**
 * 用两个栈实现一个队列，实现两个方法：入队appendTail，出队deleteHead
 * 用两个做法，一种是入队麻烦出队容易，一种是入队容易出队麻烦，选择哪种方案就要看你是否是需要连续出队或连续入队咯。
 * 
 * @author kesar
 *
 */
public class TwoStackToBeQueue
{
	Stack<Integer> dataStack = new Stack<Integer>();
	Stack<Integer> tempStack = new Stack<Integer>();

	/**
	 * 入队
	 * @param item
	 */
	public void appendTail1(int item)
	{
		dataStack.push(item);
	}

	/**
	 * 出队
	 * @return
	 * @throws Exception
	 */
	public int deleteHead1() throws Exception
	{
		if(dataStack.isEmpty())
		{
			throw new Exception("队列为空！");
		}
		int head=0;
		while (!dataStack.isEmpty())
		{
			tempStack.push(dataStack.pop());
		}
		head=tempStack.pop();
		while (!tempStack.isEmpty())
		{
			dataStack.push(tempStack.pop());
		}
		return head;
	}

	public void appendTail2(int item)
	{
		while (!dataStack.isEmpty())
		{
			tempStack.push(dataStack.pop());
		}
		tempStack.push(item);
		while (!tempStack.isEmpty())
		{
			dataStack.push(tempStack.pop());
		}
	}
	
	public int deleteHead2()
	{
		return dataStack.pop();
	}	
	
	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception
	{
		TwoStackToBeQueue sq=new TwoStackToBeQueue();
		for(int i=0;i<10;i++)
		{
			sq.appendTail2(i);
		}
		for(int i=0;i<10;i++)
		{
			System.out.println(sq.deleteHead2());
		}
	}

}
