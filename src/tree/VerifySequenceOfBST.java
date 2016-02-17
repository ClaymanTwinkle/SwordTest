package tree;
/**
 * 问题描述：假设序列中数字不重复，输入一个树的后序遍历序列，判断是否是二叉树搜索树的后序遍历序列。
 * 
 * @author kesar
 *
 */
public class VerifySequenceOfBST
{
	public static boolean isVerifySequenceOfBST(int[] seq)
	{
		if(seq==null||seq.length==0)
		{
			return false;
		}
		return isVerifySequenceOfBST(seq, 0, seq.length-1);
	}
	
	public static boolean isVerifySequenceOfBST(int[] seq,int start,int end)
	{
		if(start>=end) return true;
		int root_val=seq[end];
		int leftIndex=start-1;
		for(;leftIndex+1<end&&(root_val>seq[leftIndex+1]);leftIndex++);
		for(int rightIndex=leftIndex+1;rightIndex<end;rightIndex++)
		{
			if(root_val>seq[rightIndex]) return false;
		}
		return isVerifySequenceOfBST(seq,start,leftIndex)&&isVerifySequenceOfBST(seq, leftIndex+1, end-1);
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		int seq[]={3};
		System.out.println(isVerifySequenceOfBST(seq));
	}
}
