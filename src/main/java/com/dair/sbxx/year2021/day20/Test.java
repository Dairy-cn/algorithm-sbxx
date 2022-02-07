package com.dair.sbxx.year2021.day20;

/**
 * @author Dair
 * @since
 */
public class Test {
	
	public static int solution(int a, int b) {
		if (a == Integer.MIN_VALUE && b == -1) {
			return Integer.MAX_VALUE;
		}
		boolean flag = true;
		if ((a < 0) != (b < 0)) {
			flag = false;
		}
		if (a < b) {
			return 0;
		}
		int index = 0;
		long dividend=Math.abs((long)a);
		long divisor=Math.abs((long)b);
		int leftIndex = 31;
		while (dividend >= divisor) {
			while (dividend < (divisor << leftIndex)) {
				leftIndex--;
			}
			index += 1<<leftIndex;
			dividend -= divisor << leftIndex;
		}
		return flag?index:-index;
	}
	
	public static void main(String[] args) {
		System.out.println(Test.solution(1, 1));
	}
	
}
