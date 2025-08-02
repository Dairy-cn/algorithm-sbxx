package com.dair.sbxx.year2023.day03;

/**
 * @author Dair
 * @since
 */
public class Test4 {
	
	public int maxSubArray(int[] nums) {
		//[-2,1,-3,4,-1,2,1,-5,4]
		int[] arr = new int[nums.length + 1];
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			arr[i + 1] = Math.max(nums[i], arr[i] + nums[i]);
			max = Math.max(max, arr[i + 1]);
		}
		return max;
	}
	
	public static void main(String[] args) {
		System.out.println(new Test4().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
	}
}
