package com.dair.sbxx.year2022.day28;

/**
 * @author Dair
 * @since
 */
public class Test {
	
	
	public int[] minOperations(String boxes) {
		int[] res = new int[boxes.length()];
		for (int i = 0; i < res.length; i++) {
			int count = 0;
			for (int j = 0; j < res.length; j++) {
				if (i == j) {
					continue;
				}
				if (boxes.charAt(j)=='1') {
					count += Math.abs(j - i);
				}
			}
			res[i] = count;
		}
		return res;
	}
	
	
	public static void main(String[] args) {
		System.out.println(new Test().minOperations("001011"));
	}
	
}
