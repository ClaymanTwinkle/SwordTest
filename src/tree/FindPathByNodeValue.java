package tree;
import java.util.Stack;
/**
 * 问题描述：输入一个整数sum和一棵二叉树，打印出二叉树中结点和为sum的所有路径。
 * （路径：从根结点往下一直到叶结点形成的一条路径。）
 * @author kesar
 *
 */
public class FindPathByNodeValue
{
	public static void findPath(TreeNode root, int sum)
	{
		if (root == null)
		{
			return;
		}
		Stack<Integer> paths = new Stack<Integer>();
		findPath(root, paths, sum, 0);
	}

	private static void findPath(TreeNode root, Stack<Integer> paths, int sum,
			int currentSum)
	{
		currentSum += root.val;
		boolean isLeaf = root.left == null && root.right == null;
		paths.push(root.val);
		if (isLeaf && currentSum == sum)
		{
			printPath(paths);
		}
		if (root.left != null)
		{
			findPath(root.left, paths, sum, currentSum);
		}
		if (root.right != null)
		{
			findPath(root.right, paths, sum, currentSum);
		}
		paths.pop();
	}

	static void printPath(Stack<Integer> paths)
	{
		if (paths.isEmpty())
			return;
		for (Integer item : paths)
		{
			System.out.print(item + " - ");
		}
		System.out.println();
	}

	public static void main(String[] args)
	{
		TreeNode root=new TreeNode(10, new TreeNode(5, new TreeNode(4), new TreeNode(7)),new TreeNode(12));
		findPath(root, 100);
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
