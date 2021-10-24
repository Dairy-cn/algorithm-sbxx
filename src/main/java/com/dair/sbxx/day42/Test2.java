package com.dair.sbxx.day42;


import java.util.*;
import java.util.stream.Collectors;

/*************************************************************
 * Description: 
 * Author: Dair
 * Date: 2021/10/22
 ************************************************************/
public class Test2 {
	
	//求众数
	
	/**
	 * 哈希表和set
	 *
	 * @param nums
	 * @return
	 */
	public List<Integer> majorityElement(int[] nums) {
		
		int n = nums.length;
		HashMap<Integer, Integer> map = new HashMap<>();
		Set<Integer> resSet = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			Integer count = map.getOrDefault(nums[i], 0);
			if (count + 1 > n / 3 && count < n / 3) {
				resSet.add(nums[i]);
			}
			map.put(nums[i], count + 1);
			
		}
		return resSet.stream().collect(Collectors.toList());
	}
	
	
	public static void main(String[] args) {
		System.out.println(new Test2().majorityElement3(new int[]{1, 1, 1, 3, 3, 2, 2, 2}));
	}
	
	
	/**
	 * hash表和数组排序
	 *
	 * @param nums
	 * @return
	 */
	public List<Integer> majorityElement2(int[] nums) {
		
		int n = nums.length;
		Arrays.sort(nums);
		
		List<Integer> resList = new ArrayList<>();
		HashMap<Integer, Integer> map = new HashMap<>();
		
		for (int i = 0; i < n; i++) {
			Integer count = map.getOrDefault(nums[i], 0);
			if (count + 1 > n / 3) {
				resList.add(nums[i]);
				while (i + 1 < n && nums[i] == nums[i + 1]) {
					++i;
				}
			}
			map.put(nums[i], count + 1);
		}
		return resList;
		
	}
	
	
	public List<Integer> majorityElement3(int[] nums) {
		
		int n = nums.length;
		
		List<Integer> resList = new ArrayList<>();
		int cand1 = nums[0];
		int cand2 = nums[0];
		int count1 = 0;
		int count2 = 0;
		for (int i = 0; i < n; i++) {
			if (cand1 == nums[i]) {
				++count1;
				continue;
			}
			if (cand2 == nums[i]) {
				++count2;
				continue;
			}
			if (count1 == 0) {
				cand1 = nums[i];
				++count1;
				continue;
			}
			if (count2 == 0) {
				cand2 = nums[i];
				++count2;
				continue;
			}
			count1--;
			count2--;
			
		}
		count1=0;
		count2=0;
		for (int num : nums) {
			if(num==cand1){
				++count1;
			}else if(num==cand2){
				++count2;
			}
		}
		if(count1>n/3){
			resList.add(cand1);
		}
		if(count2>n/3){
			resList.add(cand2);
		}
		
		return resList;
		
		
	}
	
	
}
