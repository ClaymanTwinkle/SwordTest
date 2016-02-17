package tree;

/**
 * 判断树A是否是树B的子结构
 * @author kesar
 *
 */
public class IncludeSonTree
{
	public static boolean isIncludeTree(TreeNode parent, TreeNode child)
	{
		boolean result = false;
		if (parent == null || child == null)
		{
			return result;
		}
		if (parent.equals(child))
		{
			result = hasTree(parent, child);
		}
		if (!result)
		{
			result = isIncludeTree(parent.left, child);
		}
		if (!result)
		{
			result = isIncludeTree(parent.right, child);
		}

		return result;
	}

	private static boolean hasTree(TreeNode parent, TreeNode child)
	{
		if (child == null)
		{
			return true;
		}
		if (parent == null)
		{
			return false;
		}
		if (!parent.equals(child))
		{
			return false;
		}
		return hasTree(parent.left, child.left)
				&& hasTree(parent.right, child.right);

	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		TreeNode parent = new TreeNode(8, new TreeNode(8, new TreeNode(9),
				new TreeNode(2, new TreeNode(4), new TreeNode(7))),
				new TreeNode(7));
		TreeNode child = new TreeNode(8,null,new TreeNode(7,new TreeNode(0),null));
		System.out.println(isIncludeTree(parent, child));
	}

	static class TreeNode
	{
		int value;
		TreeNode left;
		TreeNode right;

		public TreeNode(int value)
		{
			this.value = value;
		}

		public TreeNode(int value, TreeNode left, TreeNode right)
		{
			this.value = value;
			this.left = left;
			this.right = right;
		}

		@Override
		public boolean equals(Object obj)
		{
			if (obj != null && obj instanceof TreeNode)
			{
				TreeNode other = (TreeNode) obj;
				return other.value == value;
			}
			return false;
		}

		@Override
		public String toString()
		{
			return "TreeNode [value=" + value + ", left=" + left + ", right="
					+ right + "]";
		}
	}
}
