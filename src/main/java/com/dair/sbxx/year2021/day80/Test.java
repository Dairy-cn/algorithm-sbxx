package com.dair.sbxx.year2021.day80;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Dair
 * @since
 */
public class Test {
	
	
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		Set<Integer> set = new HashSet<>();
		//1,2,3,1 k=2
		for (int i = 0; i < nums.length; i++) {
			if (i > k) {
				set.remove(nums[i - k - 1]);
			}
			if (!set.add(nums[i])) {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		System.out.println(new Test().containsNearbyDuplicate(new int[]{1,2,3,2,3},2));
	}
}
