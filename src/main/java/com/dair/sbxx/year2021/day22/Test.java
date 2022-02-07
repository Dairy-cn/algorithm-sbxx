package com.dair.sbxx.year2021.day22;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Dair
 * @since
 */
public class Test {
	public List<List<Integer>> threeSum(int[] nums) {
		List list = new ArrayList();
		Arrays.sort(nums);
		if (nums.length < 3) {
			return list;
		}
		Arrays.sort(nums);
		if (nums[0] > 0) {
			return list;
		}
		
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 0) {
				return list;
			}
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			int l = i + 1;
			int r = nums.length - 1;
			while (l < r) {
				if (nums[i] + nums[l] + nums[r] == 0) {
					List list1 = new ArrayList();
					list1.add(nums[i]);
					list1.add(nums[l]);
					list1.add(nums[r]);
					list.add(list1);
					while (l < r && nums[l] == nums[l + 1]) {
						l = l + 1;
					}
					while (l < r && nums[r] == nums[r - 1]) {
						r = r - 1;
					}
					++l;
					--r;
				} else if (nums[i] + nums[l] + nums[r] > 0) {
					--r;
				} else {
					++l;
				}
			}
			
		}
		return list;
	}
	
	public static void main(String[] args) {
		System.out.println(new Test().threeSum(new int[]{-2,0,0,2,2}));
	}
}
