package com.dair.sbxx.year2022.day07;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Dair
 * @since
 */
public class Test2 {
	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		if (nums.length <= 0) {
			return res;
		}
		ArrayDeque<Integer> deque = new ArrayDeque<>();
		boolean[] used = new boolean[nums.length];
		Arrays.sort(nums);
		dfs(nums, 0, nums.length, deque, res, used);
		return res;
	}
	
	private void dfs(int[] nums, int depath, int length, ArrayDeque<Integer> deque, List<List<Integer>> res, boolean[] used) {
		if (depath == length) {
			res.add(new ArrayList<>(deque));
			return;
		}
		for (int i = 0; i < length; i++) {
			if (used[i]) {
				continue;
			}
			if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
				continue;
			}
			used[i] = true;
			deque.addLast(nums[i]);
			dfs(nums, depath + 1, length, deque, res, used);
			deque.removeLast();
			used[i] = false;
		}
	}
}
