package string;
import java.util.Arrays;

/**
 * 问题描述：在字符串中将空格替换为%20
 * @author kesar
 *
 */
public class ReplaceEmpty
{
	public static void replaceEmpty(String text)
	{
		if (text == null||"".equals(text))
		{
			return;
		}
		char[] cs = text.toCharArray();
		int increace_size = 0;
		for (int i = 0; i < cs.length; i++)
		{
			if (cs[i] == ' ')
			{
				increace_size += 2;
			}
		}
		if(increace_size==0)
		{
			return;
		}
		cs = Arrays.copyOf(cs, cs.length + increace_size);
		int last = 0;
		int rest = increace_size;
		for (int i = cs.length - 1 - increace_size; i >= 0; i--)
		{
			if (rest>0)
			{
				if(cs[i]==' ')
				{
					cs[i] = '%';
					cs[i + 1] = '2';
					cs[i + 2] = '0';
					rest -= 2;
					if(rest>0)
					{
						cs[cs.length - 1 - last] = cs[i + 2];
						cs[i + 2] = ' ';
						++last;
						cs[cs.length - 1 - last] = cs[i + 1];
						cs[i + 1] = ' ';
						++last;
						cs[cs.length - 1 - last] = cs[i];
						cs[i] = ' ';
						++last;
					}
				}
				else
				{
					cs[cs.length - 1 - last] = cs[i];
					cs[i] = ' ';
					++last;
				}
			}
			else
			{
				break;
			}
		}
		System.out.println(Arrays.toString(cs));
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		replaceEmpty("helloworld!");
	}

}
