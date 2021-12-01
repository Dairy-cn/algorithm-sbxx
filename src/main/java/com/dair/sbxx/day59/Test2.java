package com.dair.sbxx.day59;

/**
 * @author Dair
 * @since
 */
public class Test2 {
	/**
	 * 给你一个整数 n ，请你在无限的整数序列[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...] 中找出并返回第n 位上的数字。
	 * <p>
	 * <p>
	 * <p>
	 * 示例 1：
	 * <p>
	 * 输入：n = 3
	 * 输出：3
	 * 示例 2：
	 * <p>
	 * 输入：n = 11
	 * 输出：0
	 * 解释：第 11 位数字在序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... 里是 0 ，它是 10 的一部分。
	 * <p>
	 * <p>
	 * 提示：
	 * <p>
	 * 1 <= n <= 231 - 1
	 * 第 n 位上的数字是按计数单位（digit）从前往后数的第 n 个数，参见 示例 2 。
	 * <p>
	 * 来源：力扣（LeetCode）
	 * 链接：https://leetcode-cn.com/problems/nth-digit
	 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */
	
	public int findNthDigit(int n) {
		int m = 1;
		int num = 1;
		while (true) {
			if (n > num) {
				m++;
				int j = 0;
				int x = m;
				while (x > 0) {
					x /= 10;
					j++;
				}
				if (n <= num + j) {
					int k = n - num;
					int l = m;
					int res = 0;
					while (j-k>=0){
						res = l % 10;
						l /= 10;
						k++;
					}
					return res;
				}
				num += j;
			} else {
				return m;
			}
		}
	}
	
	public static void main(String[] args) {
		System.out.println(new Test2().findNthDigit(2147483647));
	}
}
