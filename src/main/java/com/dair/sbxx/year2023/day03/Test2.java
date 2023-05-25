package com.dair.sbxx.year2023.day03;

/**
 * @author Dair
 * @since
 */
public class Test2 {
	
	public int minCostClimbingStairs(int[] cost) {
		int a = 0;
		int b = 0;
		for (int i = 1; i < cost.length; i++) {
			int next = Math.min(cost[i] + a, cost[i - 1] + b);
			b = a;
			a = next;
		}
		return a;
	}
	
	public static void main(String[] args) {
		System.out.println(new Test2().minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
	}
}
