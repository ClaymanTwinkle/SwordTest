package list;
/**
 * 链表反转
 * @author kesar
 *
 */
public class ReverseList
{
	/**
	 * 递归
	 * @param head
	 * @return
	 */
	public static ListNode reverseList1(ListNode head)
	{
		if(head==null)
		{
			return null;
		}
		ListNode parent=head.next;
		if(parent==null)
		{
			return head;
		}
		head.next=null;
		return reverseList1(head,parent);
	}
	
	/**
	 * 递归，绑定父子节点关系
	 * @param child
	 * @param parent
	 * @return
	 */
	private static ListNode reverseList1(ListNode child,ListNode parent)
	{
		if(parent==null)
		{
			return child;
		}
		ListNode last=parent.next;
		parent.next=child;
		return reverseList1(parent, last);
	}
	
	/**
	 * 反转链表，返回新的头节点
	 * @param head
	 * @return
	 */
	public static ListNode reverseList(ListNode head)
	{
		if(head==null)
		{
			return null;
		}
		ListNode pChild=head;
		ListNode pParent=pChild.next;
		ListNode pLast=null;
		pChild.next=null;
		while (pParent!=null)
		{
			// 绑定关系
			pLast=pParent.next;
			pParent.next=pChild;
			// 设定关系
			pChild=pParent;
			pParent=pLast;
		}
		
		return pChild;
	}
	/**
	 * 链表倒序打印输出 
	 * @param head
	 */
	public static void reversePrintList(ListNode head)
	{
		if (head == null)
		{
			return;
		}
		reversePrintList(head.next);
		System.out.println(head.value+" ");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		//reversePrintList(new ListNode(0, new ListNode(1, new ListNode(2, new ListNode(3)))));
		System.out.println(reverseList1(new ListNode(0, new ListNode(1))));
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
