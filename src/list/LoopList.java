package list;

/**
 * 问题描述：判断链表是否是环结构
 * @author kesar
 *
 */
public class LoopList
{
	/**
	 * 判断链表是否是环结构
	 * @param head
	 * @return
	 */
	public static boolean isLoop(ListNode head)
	{
		if(head==null||head.next==null)
		{
			return false;
		}
		ListNode pSlow=head;
		ListNode pFast=head.next;
		
		while (pFast.next!=null)
		{
			if(pFast.equals(pSlow))
			{
				return true;
			}
			pSlow=pSlow.next;
			pFast=pFast.next;
			pFast=pFast.next;
			if(pFast==null)
			{
				return false;
			}
		}
		return false;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		ListNode last=new ListNode(5);
		ListNode head=new ListNode(1,new ListNode(2,new ListNode(3,last)));
		last.next=head;
		System.out.println(isLoop(head));
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
