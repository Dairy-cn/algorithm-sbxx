package com.dair.sbxx.day51;

/**
 * @author Dair
 * @since
 */
public class Test {
	/**
	 * 给定一个 正整数 num ，编写一个函数，如果 num 是一个完全平方数，则返回 true ，否则返回 false 。
	 * <p>
	 * 进阶：不要 使用任何内置的库函数，如  sqrt 。
	 * <p>
	 * 来源：力扣（LeetCode）
	 * 链接：https://leetcode-cn.com/problems/valid-perfect-square
	 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 *
	 * @param num
	 * @return
	 */
	public boolean isPerfectSquare(int num) {
		if (num == 1) {
			return true;
		}
		int temp = num >> 1;
		while (temp > 0) {
			if (temp * temp == num) {
				return true;
			}
			temp--;
		}
		return false;
	}
	
	public static void main(String[] args) {
		System.out.println(new Test().isPerfectSquare(9));
	}
	
}
