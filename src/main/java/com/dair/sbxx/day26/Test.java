package com.dair.sbxx.day26;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Dair
 * @since
 */
public class Test {
	
	//1,0,-1,0,-2,2
	//sort -2 -1 0 0 1 2
	public List<List<Integer>> fourSum(int[] nums, int target) {
		Arrays.sort(nums);
		List<List<Integer>> lists = new ArrayList<>();
		if (nums == null || nums.length < 4) {
			return lists;
		}
		int length = nums.length;
		for (int i = 0; i < length - 3; i++) {
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
				break;
			}
			if (nums[i] + nums[length - 1] + nums[length - 2] + nums[length - 3] < target) {
				continue;
			}
			for (int j = i + 1; j < length - 2; j++) {
				if (j > i + 1 && nums[j] == nums[j - 1]) {
					continue;
				}
				if (nums[i] + nums[j] + nums[i + 1] + nums[i + 2] > target) {
					break;
				}
				if (nums[i] + nums[length - 1] + nums[length - 2] + nums[j] < target) {
					continue;
				}
				
				int left = j + 1;
				int right = length - 1;
				while (left < right) {
					
					int sum = nums[i] + nums[j] + nums[left] + nums[right];
					if (sum == target) {
						lists.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
						
						while (left < right && nums[left] == nums[left + 1]) {
							++left;
						}
						++left;
						while (left < right && nums[right] == nums[right - 1]) {
							--right;
						}
						--right;
						
					} else if (sum > target) {
						--right;
					} else {
						++left;
					}
					
					
				}
				
				
			}
			
		}
		
		return lists;
	}
	
	public static void main(String[] args) {
		System.out.println(new Test().fourSum(new int[]{2,2,2,2},8));
	}
	
}
