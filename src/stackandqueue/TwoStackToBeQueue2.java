package stackandqueue;
import java.util.Stack;

/**
 * 最强优化版
 * @author kesar
 *
 */
public class TwoStackToBeQueue2
{
	Stack<Integer> enStack=new Stack<Integer>(); // 用于入队的表
	Stack<Integer> deStack=new Stack<Integer>(); // 用于出队的表
	
	public void appendTail(int item)
	{
		enStack.push(item);
	}
	
	public int deleteHead()
	{
		if(deStack.isEmpty())
		{// 当出队的栈为空，那就从入队栈中获取元素更新。
			while(!enStack.isEmpty())
			{
				deStack.push(enStack.pop());
			}
		}
		// 如果deStack为空会抛一个EmptyStackException异常，这我就不处理了。
		return deStack.pop();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		TwoStackToBeQueue2 queue2=new TwoStackToBeQueue2();
		for(int i=0;i<10;i++)
			queue2.appendTail(i);
		for(int i=0;i<10;i++)
			System.out.println(queue2.deleteHead());
	}

}
