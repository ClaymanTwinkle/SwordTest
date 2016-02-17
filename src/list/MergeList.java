package list;
/**
 * 合并两个排序的链表
 * 
 * @author kesar
 * 
 */
public class MergeList
{
	/**
	 * 用递归
	 * @param head1
	 * @param head2
	 * @return
	 */
	public static ListNode merge(ListNode head1, ListNode head2)
	{
		if(head1==null)
		{
			return head2;
		}
		if(head2==null)
		{
			return head1;
		}
		ListNode head;
		if(head1.value<head2.value)
		{
			head=head1;
			head.next=merge(head1.next, head2);
		}
		else
		{
			head=head2;
			head.next=merge(head1, head2.next);
		}
		return head;
	}
	
	/**
	 * 用循环
	 * @param head1
	 * @param head2
	 * @return
	 */
	public static ListNode merge1(ListNode head1, ListNode head2)
	{
		if (head1 == null)
		{
			return head2;
		}
		if (head2 == null)
		{
			return head1;
		}
		ListNode head;
		if (head1.value < head2.value)
		{
			head = head1;
			head1 = head1.next;
		}
		else
		{
			head = head2;
			head2 = head2.next;
		}
		ListNode move = head;
		while (head1 != null || head2 != null)
		{
			if (head1 == null)
			{
				move.next = head2;
				head2 = head2.next;
			}
			else if (head2 == null)
			{
				move.next = head1;
				head1 = head1.next;
			}
			else if (head1.value < head2.value)
			{
				move.next = head1;
				head1 = head1.next;
			}
			else
			{
				move.next = head2;
				head2 = head2.next;
			}
			if(move.value>move.next.value)
			{
				System.err.println("输入的链表不是有序的");
				return null;
			}
			move = move.next;
		}

		return head;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		ListNode head1=new ListNode(1, new ListNode(3, new ListNode(5)));
		ListNode head2=new ListNode(2, new ListNode(5, new ListNode(6)));
		System.out.println(merge(head1, head2));
	}

	private static class ListNode
	{
		int value;
		ListNode next;

		public ListNode(int value)
		{
			this.value = value;
		}

		public ListNode(int value, ListNode next)
		{
			this.value = value;
			this.next = next;
		}

		@Override
		public String toString()
		{
			return "ListNode [value=" + value + ", next=" + next + "]";
		}
	}
}
