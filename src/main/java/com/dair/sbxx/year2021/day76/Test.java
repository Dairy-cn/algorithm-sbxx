package com.dair.sbxx.year2021.day76;

/**
 * @author Dair
 * @since
 */
public class Test {
	
	
	public boolean increasingTriplet(int[] nums) {
		//2,1,5,0,4,6
		if (nums.length < 3) {
			return false;
		}
		int first = nums[0];
		int second = Integer.MAX_VALUE;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] > second) {
				return true;
			} else {
				if (nums[i] > first) {
					second = nums[i];
				} else {
					first = nums[i];
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		System.out.println(new Test().increasingTriplet(new int[]{2, 1, 5, 0, 4, 6}));
	}
}
