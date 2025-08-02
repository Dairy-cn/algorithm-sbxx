package com.dair.sbxx.year2022.day36;

/**
 * @author Dair
 * @since
 */
public class Test {
	
	
	public int minCostClimbingStairs(int[] cost) {
		int a = 0;
		int b = 0;
		for (int i = 2; i <= cost.length; i++) {
			int next = Math.min(cost[i - 1] + a, cost[i - 2] + b);
			b = a;
			a = next;
		}
		return a;
	}
	
	
	public static void main(String[] args) {
		System.out.println(new Test().minCostClimbingStairs(new int[]{0, 2, 3}));
	}
}
