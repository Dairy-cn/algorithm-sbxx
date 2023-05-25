package com.dair.sbxx.year2023.day03;

/**
 * @author Dair
 * @since
 */
public class Test5 {
	
	public int massage(int[] nums) {
		int dp0 = 0, dp1 = 0;
		for (int i = 0; i < nums.length; i++) {
			//i不接 看上一个哪个最大
			int a = Math.max(dp0, dp1);
			//i接
			int b = Math.max(dp0, dp0 + nums[i]);
			dp0 = a;
			dp1 = b;
		}
		return Math.max(dp0, dp1);
	}
	
	public static void main(String[] args) {
		// 0 2
		//
		System.out.println(new Test5().massage(new int[]{2, 1, 4, 5, 3, 1, 1, 3}));
	}
}
