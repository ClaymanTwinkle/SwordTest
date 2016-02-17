package tree;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 问题描述：从上层向下层遍历，从左向右打印出一棵树
 * @author kesar
 *
 */
public class PrintTree
{
	/**
	 * 从上层向下层遍历，从左向右
	 * @param root
	 */
	public static void printTreeFromTopTOBottom(TreeNode root)
	{
		if (root == null)
		{
			return;
		}
		Queue<TreeNode> queue = new LinkedList<PrintTree.TreeNode>();
		queue.offer(root);
		while (!queue.isEmpty())
		{
			TreeNode node = queue.poll();
			System.out.print(node.val + " ");
			if (node.left != null)
			{
				queue.offer(node.left);
			}
			if (node.right != null)
			{
				queue.offer(node.right);
			}
		}
		System.out.println();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		TreeNode root = new TreeNode(8, new TreeNode(6, new TreeNode(5),
				new TreeNode(7)), new TreeNode(10, new TreeNode(9),
				new TreeNode(11)));
		printTreeFromTopTOBottom(root);
	}

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
}
