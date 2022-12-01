package com.dair.sbxx.year2022.day22;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Dair
 * @since
 */
public class Test3 {
	
	
	public int majorityElement(int[] nums) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
			if (map.get(nums[i]) > nums.length / 2) {
				return nums[i];
			}
		}
		return -1;
	}
}