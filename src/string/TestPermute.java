package string;
/**
 * 实现字符数组全排列
 * 
 * @author kesar
 * 
 */
public class TestPermute {

	public static void permute(String str) {

		char[] ca = str.toCharArray();
		permute(ca, 0, ca.length - 1);
	}

	/**
	 * 核心方法：用了递归的方式完成全排列，用递归的思路是要怎么开始，怎么结束，想想这两个临界点。
	 * @param str
	 * @param low
	 * @param hight
	 */
	public static void permute(char[] str, int low, int hight) {

		if (low == hight) {
			// 递归结束
			for (int i = 0; i <= hight; i++)
				System.out.print(str[i]);
			System.out.println();
		} else {
			for (int i = low; i <= hight; i++) {
				// 首先交换开始的字符位置(这里交换字符值不能用异或，会出现奇怪字符)，这个交换是思路的关键，因为不想用辅助空间(一用就很多浪费)，所以才选择交换位置。
				char temp = str[low];
				str[low] = str[i];
				str[i] = temp;

				// 递归开始
				permute(str, low + 1, hight);
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		permute("abc");
	}

}
