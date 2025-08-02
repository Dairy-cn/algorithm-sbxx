package com.dair.sbxx.year2022.day35;

/**
 * @author Dair
 * @since
 */
public class Test3 {
	
	public int[] countBits(int n) {
		int[] res = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			int index = i;
			int count = 0;
			while (index > 0) {
				if (index % 2 == 1) {
					++count;
				}
				index = index / 2;
			}
			res[i] = count;
		}
		return res;
	}
	
	public static void main(String[] args) {
		int[] ints = new Test3().countBits(5);
		for (int i = 0; i < ints.length; i++) {
			System.out.println(ints[i]);
		}
	}
}
