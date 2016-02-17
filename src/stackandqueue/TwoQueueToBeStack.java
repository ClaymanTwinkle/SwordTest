package stackandqueue;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 两个队列实现一个栈
 * @author kesar
 *
 */
public class TwoQueueToBeStack
{
	Queue<Integer> queue1 = new LinkedList<Integer>();
	Queue<Integer> queue2 = new LinkedList<Integer>();

	public void push(int item)
	{
		if (queue2.isEmpty())
		{
			queue1.offer(item);
		}
		else
		{
			queue2.offer(item);
		}
	}

	public int pop() throws Exception
	{
		boolean isQueue1Empty = queue1.isEmpty();
		boolean isQueue2Empty = queue2.isEmpty();

		if (isQueue1Empty && isQueue2Empty)
		{
			throw new Exception("队列为空！");
		}
		int item = 0;
		if (isQueue2Empty)
		{
			while (!queue1.isEmpty())
			{
				item = queue1.poll();
				if (queue1.isEmpty())
				{
					return item;
				}
				queue2.offer(item);
			}
		}
		else
		{
			while (!queue2.isEmpty())
			{
				item = queue2.poll();
				if (queue2.isEmpty())
				{
					return item;
				}
				queue1.offer(item);
			}
		}
		return item;
	}

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception
	{
		TwoQueueToBeStack beStack = new TwoQueueToBeStack();
		for (int i = 0; i < 10; i++)
		{
			beStack.push(i);
		}
		for (int i = 0; i < 9; i++)
		{
			System.out.println(beStack.pop());
			;
		}
	}

}
