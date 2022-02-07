package com.dair.sbxx.year2021.day41;

/**
 * @author Dair
 * @since
 */
public class Test {
	
	public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
		
		int maxProfit = 0;
		int[] orderArr = new int[profit.length];
		//startTime = [1,2,3,4,6], endTime = [3,5,10,6,9], profit = [20,20,100,70,60]
		
		for (int i = 0; i < profit.length; i++) {
			for (int j = i + 1; j < profit.length; j++) {
				if (profit[j] > profit[i]) {
					int temp = profit[j];
					profit[j] = profit[i];
					profit[i] = temp;
					orderArr[i] = j;
					orderArr[j]=i;
				}
			}
		}
		//orderArr={2,3,4,0,1}
		for (int i = 0; i < orderArr.length; i++) {
		
		}
		//3,4,5,1,2
		//3-10,1-3=100+20;
		//4-6,6-9,1-3=70+60+20=150
		//4,1,3,2
		//3-6,1-3,3-5,2-4
		return 1;
	}
	
	public static void main(String[] args) {
		System.out.println(new Test().jobScheduling(new int[]{1,2,3,4,6},new int[]{3,5,10,6,9},new int[]{20,20,100,70,60}));
	}
	
}
	
	
