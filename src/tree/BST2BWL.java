package tree;

/**
 * 问题描述：将一棵二叉搜索树转成一条排序好的双向链表。要求不能创建新结点。
 * @author kesar
 *
 */
public class BST2BWL
{
	/**
	 * 树节点
	 */
	static class TreeNode
	{
		int val;
		TreeNode left;
		TreeNode right;
		
		public TreeNode(int val)
		{
			this.val = val;
		}
		
		public TreeNode(int val, TreeNode left, TreeNode right)
		{
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
	/**
	 * 解法：中序遍历的顺序，中间增加连接节点的操作。
	 * @param root
	 * @return
	 */
	public static TreeNode doBST2BWL(TreeNode root)
	{
		if(root==null) 
		{
			return null;
		}
		TreeNode head=root;
		// 整理左半边
		TreeNode left = doBST2BWL(root.left);
		// 连接左半边
		if(left!=null)
		{
			head=left;
			// 将left指针移动到左半边的最后(右)一个结点
			for(;left.right!=null;left=left.right);
			left.right=root;
		}
		root.left=left;
		// 整理右半边
		TreeNode right= doBST2BWL(root.right);
		// 连接右半边
		if(right!=null)
		{
			right.left=root;
		}
		root.right=right;
		// 返回头结点
		return head;
	}
	
	/**
	 * 打印双向链表
	 * @param head
	 */
	public static void printList(TreeNode head)
	{
		TreeNode tail=null;
		for(TreeNode move=head;move!=null;move=move.right)
		{
			System.out.print(move.val+" - ");
			tail=move;
		}
		System.out.println();
		for(;tail!=null;tail=tail.left)
		{
			System.out.print(tail.val+" - ");
		}
		System.out.println();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		TreeNode root=new TreeNode(10, new TreeNode(6, new TreeNode(4), new TreeNode(8)), new TreeNode(14, new TreeNode(12), new TreeNode(16)));
		TreeNode head = doBST2BWL(root);
		printList(head);
	}

}
