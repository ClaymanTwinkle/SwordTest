package list;

import java.util.Arrays;

import list.LastList.ListNode;

/**
 * 
 * ClassName: CenterNodeList 
 * @Description: 返回链表的中间结点（如果是偶数个则返回两个）
 * @author kesar
 */
public class CenterNodeList
{
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
	 * @param @param args   
	 * @return void  
	 * @throws
	 * @author kesar
	 */
	public static void main(String[] args)
	{
		System.out.println(Arrays.toString(getCenterNode(new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4)))))));
	}

}
