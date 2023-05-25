package com.dair.sbxx.year2023.day01;

/**
 * @author Dair
 * @since
 */
public class Test2 {
	/**
	 * 给你一个整数 n 。按下述规则生成一个长度为 n + 1 的数组 nums ：
	 * <p>
	 * nums[0] = 0
	 * nums[1] = 1
	 * nums[2] = 1
	 * nums[3] = 2
	 * nums[4] = 1
	 * nums[5] = 2
	 * nums[6] = 2
	 * nums[7] = 3
	 * nums[8] = 1
	 * nums[9] = 3
	 * nums[10] = 2
	 * nums[11] = 4
	 * <p>
	 * 当 2 <= 2 * i <= n 时，nums[2 * i] = nums[i]
	 * 当 2 <= 2 * i + 1 <= n 时，nums[2 * i + 1] = nums[i] + nums[i + 1]
	 * 返回生成数组 nums 中的 最大 值。 7/2
	 * <p>
	 * 来源：力扣（LeetCode）
	 * 链接：https://leetcode.cn/problems/get-maximum-in-generated-array
	 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 *
	 * @param n
	 * @return
	 */
	public int getMaximumGenerated(int n) {
		int max = 0;
		int[] arr = new int[n + 1];
		arr[0] = 0;
		if (n >= 1) {
			arr[1] = 1;
			max=1;
		}
		for (int i = 2; i <= n; i++) {
			if (i % 2 == 1) {
				arr[i] = arr[i / 2] + arr[i / 2 + 1];
			} else {
				arr[i] = arr[i / 2];
			}
			max = Math.max(max, arr[i]);
		}
		return max;
	}
	
	public static void main(String[] args) {
		System.out.println(new Test2().getMaximumGenerated(0));
		
	}
}
