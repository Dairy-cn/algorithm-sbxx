package com.dair.sbxx.day64;

/**
 * @author Dair
 * @since
 */
public class Test {
	
	
	/**
	 * 换酒问题
	 *
	 * @param numBottles  酒瓶数
	 * @param numExchange 空瓶换一瓶酒的数量
	 * @return
	 */
	public int numWaterBottles(int numBottles, int numExchange) {
		int n = numBottles;
		int res = 0;
		while (n > numExchange) {
			n -= numExchange;
			n++;
			res++;
		}
		return res + numBottles;
	}
	
	/**
	 * 换酒问题 方法二
	 *
	 * @param numBottles  酒瓶数
	 * @param numExchange 空瓶换一瓶酒的数量
	 * @return
	 */
	public int numWaterBottles2(int numBottles, int numExchange) {
		
		//需要numExchange-1个空瓶，换1瓶酒水
		
		//初始有numBottles酒瓶数,全部喝完，留下一个空瓶，用numBottles-1个空瓶去换酒
		
		//能换到numBottles-1/numExchange-1瓶酒水
		
		return numBottles + (numBottles - 1) / (numExchange - 1);
		
		
	}
}
