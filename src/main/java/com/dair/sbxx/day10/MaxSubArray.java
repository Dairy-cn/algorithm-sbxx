package com.dair.sbxx.day10;

/**
 * @author Dair
 * @since
 */
public class MaxSubArray {
	public static int solution(int[] arr) {
		
		int ans = arr[0];
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			if (sum > 0) {
				sum += arr[i];
			} else {
				sum = arr[i];
			}
			 ans = Math.max(sum, ans);
		}
		return ans;
	}
	
	
	public static void main(String[] args) {
		int solution = solution(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
		System.out.println(solution);
	}
}