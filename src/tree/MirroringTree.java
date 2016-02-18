package tree;

/**
 * 
 * 问题描述：输出树的镜像
 * @author kesar
 *
 */
public class MirroringTree
{	
	public static TreeNode mirror(TreeNode root)
	{
		if(root==null)
		{
			return null;
		}
		TreeNode left=root.left;
		TreeNode right=root.right;
		root.right=mirror(left);
		root.left=mirror(right);
		
		return root;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		TreeNode root=new TreeNode(8, new TreeNode(6,new TreeNode(5),new TreeNode(7)),null);
		System.out.println(root);
		System.out.println(mirror(root));
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
		public String toString()
		{
			return "TreeNode [value=" + value + ", left=" + left + ", right="
					+ right + "]";
		}
	}
}
