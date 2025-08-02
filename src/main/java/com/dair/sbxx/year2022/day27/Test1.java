package com.dair.sbxx.year2022.day27;

import java.util.HashMap;

/**
 * @author Dair
 * @since
 */
public class Test1 {
	
	public int majorityElement(int[] nums) {
		int length = nums.length;
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int num : nums) {
			Integer count = map.getOrDefault(num, 0);
			if (count + 1 > length / 2) {
				return num;
			}
			map.put(num, count + 1);
		}
		return 0;
	}
}
