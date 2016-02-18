package tree;
import java.util.Stack;

/**
 * 问题描述：后缀表达式转二叉树
 * @author kesar
 *
 */
public class SuffixExpression
{
	/**
	 * 后缀表达式转二叉表达式树
	 * @param suffixStr
	 */
	public static void suffixExpression2Tree(String suffixStr)
	{
		if(isEmpty(suffixStr))
		{
			return;
		}
		char[] chs=suffixStr.toCharArray();
		// 用于临时存储节点的栈
		Stack<TreeNode> stack=new Stack<TreeNode>();
		// 遍历所有字符，不是运算符的入栈，是运算符的，将栈中两个节点取出，合成一颗树然后入栈
		for(int i=0;i<chs.length;i++)
		{
			if(isOperator(chs[i]))
			{
				if(stack.isEmpty()||stack.size()<2)
				{
					System.err.println("输入的后缀表达式不正确");
					return;
				}
				TreeNode root=new TreeNode(chs[i]);
				root.left=stack.pop();
				root.right=stack.pop();
				stack.push(root);
			}
			else
			{
				stack.push(new TreeNode(chs[i]));
			}
		}
		if(stack.isEmpty()||stack.size()>1)
		{
			System.err.println("输入的后缀表达式不正确");
			return;
		}
		stack.pop().printAll();
	}
	
	/**
	 * 判断字符是否是运算符
	 * @param c
	 * @return
	 */
	public static boolean isOperator(char c)
	{
		if(c=='*'||c=='/'||c=='+'||c=='-')
		{
			return true;
		}
		return false;
	}
	
	/**
	 * 判断字符串是否是空串
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str)
	{
		if(str==null||"".equals(str))
		{
			return true;
		}
		return false;
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		long start=System.currentTimeMillis();
		suffixExpression2Tree("ab+cde+**");
		System.out.println("执行时间："+(System.currentTimeMillis()-start)+"ms");
	}

	/**
	 * 树节点
	 * @author kesar
	 *
	 */
	private static class TreeNode
	{
		Object val;
		TreeNode left;
		TreeNode right;
		
		public TreeNode(Object val)
		{
			this.val = val;
		}
		
		/**
		 * 打印指定深度的数下节点
		 * @param d
		 */
		public void print(int d)
		{
			StringBuilder printStrBuilder=new StringBuilder("");
			for(int i=0;i<d;i++)
			{
				printStrBuilder.append("- ");
			}
			printStrBuilder.append(val);
			System.out.println(printStrBuilder);
			
			if(left!=null)
			{
				left.print(d+1);
			}
			if(right!=null)
			{
				right.print(d+1);
			}
		}
		
		/**
		 * 打印整棵树
		 */
		public void printAll()
		{
			print(0);
		}
	}
}
