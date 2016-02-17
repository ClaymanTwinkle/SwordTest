package num;
import java.util.HashMap;
import java.util.Iterator;

/**
 * 问题描述：设计一个类，包含如下两个成员函数：
 * Save(int input) 插入一个整数到一个整数集合里。
 * Test(int target) 检查是否存在两个数和为输入值。如果存在着两个数，则返回true，否则返回false
 * 允许整数集合中存在相同值的元素
 * @author kesar
 * 
 */
public class TwoNumOfSum3
{
	// key：数值，value：数值对应的个数
	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

	/**
	 * 插入一个整数到一个整数集合里
	 * @param input
	 */
	public void Save(int input)
	{
		int count = 0;
		if (map.containsKey(input))
		{
			count = map.get(input);
		}
		map.put(input, count + 1);
	}

	/**
	 * 检查是否存在两个数和为输入值
	 * @param target
	 * @return 如果存在着两个数，则返回true，否则返回false
	 */
	public boolean Test(int target)
	{
		Iterator<Integer> iterator = map.keySet().iterator();
		while (iterator.hasNext())
		{
			int one = iterator.next();
			int two = target - one;
			System.out.println("one:"+one+" two:"+two);
			if (map.containsKey(two))
			{
				if (!(target ==two<<1 && map.get(two) == 1))
				{
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		TwoNumOfSum3 t=new TwoNumOfSum3();
		t.Save(5);
		t.Save(10);
		t.Save(4);
		t.Save(7);
		System.out.println(t.Test(10));
	}
}
