package tree;
import java.util.Arrays;

/**
 * 分别输入前序+中序，中序+后序，求出原二叉树
 * 
 * @author kesar
 * 
 */
public class TreeInput
{
	/**
	 * 
	 * 输入前序+中序
	 * 
	 * @param first
	 * @param center
	 * @return
	 */
	public static TreeNode inputFirstAndCenter(int[] first, int[] center)
	{
		if (first == null || center == null || first.length != center.length)
		{
			return null;
		}
		int root_val = first[0];
		TreeNode root = new TreeNode(root_val);

		for (int i = 0; i < center.length; i++)
		{
			if (center[i] == root_val)
			{// 这里要很小心，注意处理好边界判断

				// 当中序数组第一个为根节点时说明这个根节点没有左子树，如果不是就有左子树
				// 前序数组：0是根节点，1~i是左子树，i+1后是右子树
				// 中序数组：i是根节点，0~i-1是左子树，i+1后市右子树
				// 边界情况是：只有根节点，只有左子树，只有右子树
				if (i > 0)
				{
					root.left = inputFirstAndCenter(
							Arrays.copyOfRange(first, 1, i + 1),// 索引从1开始，因为0是根节点。i+1表示最后一个索引是i
							Arrays.copyOfRange(center, 0, i)); // 中序第一个不为根节点时，索引0就表示左孩子，所以从0开始，i表示最后一个索引时i-1
				}
				// 处理右边
				if (i < first.length - 1)
				{// 处理边界：中序数组中索引i的值是某一根节点，所以要i+1
					root.right = inputFirstAndCenter(
							Arrays.copyOfRange(first, i + 1, first.length),
							Arrays.copyOfRange(center, i + 1, center.length));
				}

				return root;
			}
		}
		// 输入的序列不匹配
		return null;
	}

	/**
	 * 输入中序和后序
	 * 
	 * @param center
	 * @param last
	 * @return
	 */
	public static TreeNode inputCenterAndLast(int[] center, int[] last)
	{
		if (last == null || center == null || last.length != center.length)
		{
			return null;
		}
		int root_val = last[last.length - 1];
		TreeNode root = new TreeNode(root_val);

		for (int i = 0; i < center.length; i++)
		{
			if (center[i] == root_val)
			{// 这里要很小心，注意处理好边界判断

				// 当中序数组第一个为根节点时说明这个根节点没有左子树，如果不是就有左子树
				// 后序数组：length-1是根节点，0~i-1是左子树，i~length-2后是右子树
				// 中序数组：i是根节点，0~i-1是左子树，i+1后市右子树
				// 边界情况是：只有根节点，只有左子树，只有右子树
				if (i > 0)
				{
					root.left = inputCenterAndLast(
							Arrays.copyOfRange(center, 0, i),
							Arrays.copyOfRange(last, 0, i));
				}
				// 处理右边
				if (i < center.length - 1 && center.length > 1)
				{
					root.right = inputCenterAndLast(
							Arrays.copyOfRange(center, i + 1, center.length),
							Arrays.copyOfRange(last, i, last.length - 1));
				}

				return root;
			}
		}
		// 输入的序列不匹配
		return null;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		int[] first = { 1, 2, 4, 7, 3, 5, 6, 8 };
		int[] center = { 4, 7, 2, 1, 5, 3, 8, 6 };
		int[] last = { 7, 4, 2, 5, 8, 6, 3, 1 };
		TreeNode root = inputFirstAndCenter(first, center);
		printAll(root);
		root = inputCenterAndLast(center, last);
		printAll(root);
	}

	/**
	 * 
	 * 树节点
	 * 
	 * @author kesar
	 * 
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
	 * 打印所有序
	 * 
	 * @param root
	 */
	public static void printAll(TreeNode root)
	{
		printFirst(root);
		System.out.println();
		printCenter(root);
		System.out.println();
		printLast(root);
		System.out.println();
	}

	/**
	 * 打印二叉树的前序到控制台
	 * 
	 * @param root
	 */
	public static void printFirst(TreeNode root)
	{
		if (root == null)
		{
			return;
		}
		System.out.print(root.val + " ");
		printFirst(root.left);
		printFirst(root.right);
	}

	/**
	 * 打印二叉树的中序到控制台
	 * 
	 * @param root
	 */
	public static void printCenter(TreeNode root)
	{
		if (root == null)
		{
			return;
		}
		printCenter(root.left);
		System.out.print(root.val + " ");
		printCenter(root.right);
	}

	/**
	 * 打印二叉树的后序道控制台
	 * 
	 * @param root
	 */
	public static void printLast(TreeNode root)
	{
		if (root == null)
		{
			return;
		}
		printLast(root.left);
		printLast(root.right);
		System.out.print(root.val + " ");
	}
}
