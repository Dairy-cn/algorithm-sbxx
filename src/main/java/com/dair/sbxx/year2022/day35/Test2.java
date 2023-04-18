package com.dair.sbxx.year2022.day35;

/**
 * @author Dair
 * @since
 */
public class Test2 {
	
	public int maxProfit(int[] prices) {
		//比较今天前的最大收益
		//记录今天前的最小值
		
		int max = 0;
		int min = prices[0];
		for (int i = 1; i < prices.length; i++) {
			max = Math.max(max, prices[i] - min);
			min = Math.min(min, prices[i]);
		}
		return max;
	}
}
