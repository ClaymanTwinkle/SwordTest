package list;
import java.util.Arrays;

/**
 * 求出链表中倒数第n个节点
 * 
 * @author kesar
 * 
 */
public class LastList
{
	public static ListNode getLastNode(ListNode head, int n)
	{
		if (head == null || n <= 0)
		{
			return null;
		}

		ListNode left = head;
		ListNode right = head;

		for (int i = 1; i < n; i++)
		{
			right = right.next;
			if (right == null)
			{
				return null;
			}
		}
		while (right.next != null)
		{
			left = left.next;
			right = right.next;
		}

		return left;
	}

	/**
	 * 返回中间节点
	 * 
	 * @param head
	 * @return
	 */
	public static ListNode[] getCenterNode(ListNode head)
	{
		ListNode[] results = { null, null };
		if (head == null)
		{
			return results;
		}
		ListNode left = head;
		ListNode right = head.next;
		// 如果只有一个节点
		if (right == null)
		{
			results[0] = left;
			return results;
		}
		// 如果不止有一个节点

		while (right.next != null)
		{
			left = left.next;
			right = right.next;
			right = right.next;
			if (right == null)
			{
				results[0] = left;
				return results;
			}
		}
		results[0] = left;
		results[1] = left.next;
		
		return results;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		System.out.println(Arrays.toString(getCenterNode(new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4)))))));
	}

	static class ListNode
	{
		int val;
		ListNode next;

		public ListNode(int val)
		{
			this.val = val;
		}

		public ListNode(int val, ListNode next)
		{
			this.val = val;
			this.next = next;
		}

		@Override
		public String toString()
		{
			return "ListNode [val=" + val + "]";
		}
	}
}
