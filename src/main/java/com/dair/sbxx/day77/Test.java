package com.dair.sbxx.day77;

/**
 * @author Dair
 * @since
 */
public class Test {
	
	public int dominantIndex(int[] nums) {
		int b = 0;
		int a = -1;
		if (nums.length == 1) {
			return 0;
		}
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] > nums[b]) {
				a=b;
				b = i;
			} else if (a == -1 || nums[i] > nums[a]) {
				a = i;
			}
		}
		return nums[b] >= nums[a] ? b : -1;
	}
}
