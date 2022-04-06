package com.dair.sbxx.year2022.day07;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Dair
 * @since
 */
public class Test {
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		if (nums.length <= 0) {
			return res;
		}
		ArrayDeque<Integer> deque = new ArrayDeque<>();
		boolean[] used = new boolean[nums.length];
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
			used[i] = true;
			deque.addLast(nums[i]);
			dfs(nums, depath + 1, length, deque, res, used);
			deque.removeLast();
			used[i] = false;
		}
	}
}
