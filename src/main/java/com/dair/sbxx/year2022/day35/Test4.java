package com.dair.sbxx.year2022.day35;

/**
 * @author Dair
 * @since
 */
public class Test4 {
	
	public int[] countBits(int n) {
		int[] res = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			if (i == 0) {
				res[i] = 0;
			}
			res[i] = res[i >> 1] + (i & 1);
		}
		return res;
	}
	
	public static void main(String[] args) {
		int[] ints = new Test4().countBits(5);
		for (int i = 0; i < ints.length; i++) {
			System.out.println(ints[i]);
		}
	}
}
