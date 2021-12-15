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
					while (j - k >= 0) {
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
		System.out.println(new Test2().findNthDigit3(11));
	}
	
	public int findNthDigit2(int n) {
		
		int len = 1;
		int res = 0;
		//定位该数M的位数
		while (len * 9 * Math.pow(10, len - 1) < n) {
			n -= len * 9 * Math.pow(10, len - 1);
			len++;
		}
		//起始数字
		int m = (int) Math.pow(10, len - 1);
		
		int x = 1;
		while (x * len < n) {
			//该数M与起始位数的间隔数
			x++;
			//m即是找的数M
			m++;
		}
		// 在数M的第几位（从右到左）
		int i = x * len - n + 1;
		int l = m;
		while (i > 0) {
			res = l % 10;
			l /= 10;
			i--;
		}
		return res;
		
	}
	
	
	public int findNthDigit3(int n) {
		
		int len = 1;
		int res = 0;
		//定位该数M的位数
		while (len * 9 * Math.pow(10, len - 1) < n) {
			n -= len * 9 * Math.pow(10, len - 1);
			len++;
		}
		//起始数字
		int m = (int) Math.pow(10, len - 1);
		int x = n / len + m - 1;
		
		n = (x - m + 1) * len - n;
		return n == 0 ? (int)(x % 10) : (int)(x / Math.pow(10, n) % 10);
		
		
	}
	
}
