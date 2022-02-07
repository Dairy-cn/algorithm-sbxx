package com.dair.sbxx.year2021.day4;

/**
 * @author Dair
 * @since 爬楼梯
 */
public class Solution {
	
	public int climbStairs(int x) {
		int p = 0;
		int q = 0;
		int r = 1;
		for (int i = 1; i <= x; i++) {
			p = q;
			q = r;
			r = q + p;
		}
		return r;
		
	}
	
}
