package com.dair.sbxx.year2022.day35;

/**
 * @author Dair
 * @since
 */
public class Test {
	
	
	public int maxProfit(int[] prices) {
		
		return queryProfit(prices, 0, prices.length - 1);
	}
	
	public int queryProfit(int[] prices, int startIndex, int endIndex) {
		if (startIndex >= endIndex) {
			return 0;
		}
		int maxIndex = 0;
		int minIndex = 0;
		for (int i = startIndex; i < endIndex; i++) {
			minIndex = i;
			if (prices[i] >= prices[i + 1]) {
				continue;
			}
			break;
		}
		maxIndex = queryMaxProfit(minIndex + 1, endIndex, prices);
		for (int i = minIndex + 1; i < maxIndex; i++) {
			if (prices[minIndex] > prices[i]) {
				minIndex = i;
			}
		}
		int maxProfix = prices[maxIndex] - prices[minIndex];
		return Math.max(maxProfix, queryProfit(prices, maxIndex + 1, endIndex));
	}
	
	public int queryMaxProfit(int index, int endIndex, int[] prices) {
		int maxProfit = prices[index];
		int maxIndex = index;
		for (int i = index; i <= endIndex; i++) {
			if (prices[i] > maxProfit) {
				maxProfit = prices[i];
				maxIndex = i;
			}
		}
		return maxIndex;
	}
	
	public static void main(String[] args) {
		Test test = new Test();
		int maxProfit = test.maxProfit(new int[]{7,6,4,3,2,1});
		System.out.println(maxProfit);
	}
}
