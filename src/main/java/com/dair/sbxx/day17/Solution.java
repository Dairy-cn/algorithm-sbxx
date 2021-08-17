package com.dair.sbxx.day17;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dair
 * @since
 */
public class Solution {
	
	List<List<Integer>> res;
	
	
	public static void main(String[] args) {
		Solution solution=new Solution();
		List<List<Integer>> subsets = solution.subsets(new int[]{3, 5, 9});
		System.out.println(subsets);
	}
	public List<List<Integer>> subsets(int[] nums) {
		res = new ArrayList<>();
		backtrack(0, new ArrayList<Integer>(), nums, nums.length);
		return res;
	}
	
	private void backtrack(int index, ArrayList<Integer> tmp, int[] nums, int n){
		res.add(new ArrayList<Integer>(tmp));
		for(int i = index; i < n; i++){
			tmp.add(nums[i]);
			backtrack(i + 1, tmp, nums, n);
			tmp.remove(tmp.size() - 1);
		}
	}
	

	
}
