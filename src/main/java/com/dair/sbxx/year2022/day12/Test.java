package com.dair.sbxx.year2022.day12;

/**
 * @author Dair
 * @since
 */
public class Test {
	
	/**
	 * 斐波那契数（通常用F(n) 表示）形成的序列称为 斐波那契数列 。该数列由0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
	 * <p>
	 * F(0) = 0，F(1)= 1
	 * F(n) = F(n - 1) + F(n - 2)，其中 n > 1
	 * 给定n ，请计算 F(n) 。
	 * <p>
	 * 来源：力扣（LeetCode）
	 * 链接：https://leetcode-cn.com/problems/fibonacci-number
	 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 *
	 * @param n
	 * @return
	 */
	public int fib(int n) {
		int[] arr = new int[n + 1];
		arr[0] = 0;
		arr[1] = 1;
		for (int i = 2; i < arr.length; i++) {
			arr[i] = arr[i - 1] + arr[i - 2];
		}
		return arr[n];
	}
}
