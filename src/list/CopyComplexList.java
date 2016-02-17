package list;
import java.util.HashMap;

/**
 * 问题描述：复制一个复杂链表。 在复杂链表中，每个结点除了有一个指向下一个结点的next指针外，还有一个sibing指向链表中任意结点或者NULL。
 * 
 * @author kesar
 * 
 */
public class CopyComplexList
{
	/**
	 * 复杂链表的结点
	 * 
	 * @author kesar
	 * 
	 */
	static class Node
	{
		int val;
		Node next;
		Node slibing;

		public Node()
		{
		}

		public Node(int val)
		{
			this.val = val;
		}

		@Override
		public String toString()
		{
			return "Node [val=" + val + "]";
		}
	}

	/**
	 * 第一种解法：暴力复制。复制一遍next的，再每个结点遍历一遍进行slibing的比较。 时间复杂度是：O(n^2)，空间复杂度是：O(1)
	 * 
	 * @param oHead
	 * @return
	 */
	public static Node copy1(Node oHead)
	{
		if (oHead == null)
		{
			return null;
		}
		// 复制的链表的头结点
		Node cHead = new Node(oHead.val);

		// oMove是原链表上遍历用的移动指针，cMove是复制链表上遍历用的移动指针
		// 复制Node结点的值以及next链关系
		for (Node oMove = oHead.next, cMove = cHead; oMove != null; cMove = cMove.next, oMove = oMove.next)
		{
			cMove.next = new Node(oMove.val);
		}

		// 复制slibing的链关系
		for (Node oMove = oHead, cMove = cHead; oMove != null; cMove = cMove.next, oMove = oMove.next)
		{
			if (oMove.slibing == null)
				continue;
			// 查找开始： 遍历查找slibing所指原链表结点对应在copy链表中的结点
			Node findNode = cHead;
			for (; findNode != null && findNode.val != oMove.slibing.val; findNode = findNode.next)
				;
			// 查找结束：findNode就是结果
			cMove.slibing = findNode;
		}

		return cHead;
	}

	/**
	 * 第二种解法：利用HashMap的O(1)的高效率查找来取代第一中解法中的一个for循环。用O(n)的空间换来O(n)的时间。时间复杂度O(n)，
	 * 空间复杂度：O(n)
	 * 
	 * @param oHead
	 * @return
	 */
	public static Node copy2(Node oHead)
	{
		if (oHead == null)
		{
			return null;
		}
		// 辅助空间：Key：原链表上的结点，Value：复制链表上的结点
		HashMap<Node, Node> map = new HashMap<Node, Node>();

		// 初始化复制链表的头结点
		Node cHead = new Node(oHead.val);
		map.put(oHead, cHead);
		if (oHead.slibing != null)
		{
			cHead.slibing = new Node(oHead.slibing.val);
			map.put(oHead.slibing, cHead.slibing);
		}
		// 作用：遍历原链表，复制结点到复制链表中。
		// 思路是这样：先从map找原结点对应的复制结点，如果没找到，就创建一个，然后连接到复制链表中，然后put入map中，便于其他时候使用
		for (Node oMove = oHead.next, cMove = cHead; oMove != null; oMove = oMove.next, cMove = cMove.next)
		{
			if (map.containsKey(oMove))
			{
				cMove.next = map.get(oMove);
			}
			else
			{
				cMove.next = new Node(oMove.val);
				map.put(oMove, cMove.next);
			}
			Node slibing = oMove.slibing;
			if (slibing == null)
			{
				continue;
			}
			if (map.containsKey(slibing))
			{
				cMove.next.slibing = map.get(slibing);
			}
			else
			{
				cMove.next.slibing = new Node(slibing.val);
				map.put(slibing, cMove.next.slibing);
			}
		}
		return cHead;
	}

	/**
	 * 第三种解法：我们把这种解法叫“伸长分裂法”。 
	 * 1.遍历原链表。在原链表的每个结点的后面插入对应复制结点，将原链表“伸长”1倍。
	 * 2.遍历原链表。将复制结点的slibing连接好。 
	 * 3.遍历原链表。将原结点和复制结点“分裂”开，将next连接好。
	 * 时间复杂度是O(n)，空间复杂度是O(1)
	 * 
	 * @param oHead
	 * @return
	 */
	public static Node copy3(Node oHead)
	{
		if (oHead == null)
		{
			return null;
		}
		// 1."伸长"
		for (Node oMove = oHead; oMove != null; oMove = oMove.next)
		{
			// 复制结点
			Node copy = new Node(oMove.val);
			// 插入复制结点到原结点的后面
			copy.next = oMove.next;
			oMove.next = copy;
			// 移动到复制结点处
			oMove = copy;
		}
		// 2.连接好slibing
		for (Node oMove = oHead; oMove != null; oMove = oMove.next)
		{
			if (oMove.slibing == null)
			{
				continue;
			}
			Node copy = oMove.next;
			copy.slibing = oMove.slibing.next;
			oMove = copy;
		}
		// 3."分裂"，连接好原链表的next和复制链表中的next
		Node cHead = oHead.next;
		oHead.next = cHead.next;
		cHead.next = null;
		for (Node oMove = oHead.next, cMove = cHead; oMove != null; oMove = oMove.next, cMove = cMove.next)
		{
			Node copy = oMove.next;
			oMove.next = copy.next;
			copy.next = null;
			cMove.next = copy;
		}
		return cHead;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Node A = new Node(1);
		Node B = new Node(2);
		Node C = new Node(3);
		Node D = new Node(4);
		Node E = new Node(5);
		A.next = B;
		B.next = C;
		C.next = D;
		D.next = E;
		A.slibing = C;
		B.slibing = E;
		D.slibing = B;

		printList(A);
		System.out.println("-------------- kesar万恶的分割线 ---------------");
		printList(copy3(A));
	}

	/**
	 * 打印链表
	 * 
	 * @param head
	 */
	public static void printList(Node head)
	{
		Node move = head;
		System.out.println("next");
		while (move != null)
		{
			System.out.print(move.val + "-");
			move = move.next;
		}
		System.out.println();
		System.out.println("slibing");
		move = head;
		while (move != null)
		{
			if (move.slibing != null)
			{
				System.out.println(move.val + "-" + move.slibing.val);
			}
			move = move.next;
		}
	}

}
