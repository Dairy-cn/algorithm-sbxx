package com.dair.sbxx.year2021.day35;

import java.util.*;

/*************************************************************
 * Description: 
 * Author: Dair
 * Date: year2021/10/6
 ************************************************************/
public class Test {
	
	
	public int thridMax(int[] nums) {
		
		Arrays.sort(nums);
		for (int i = nums.length - 1, index = 1; i > 0; i--) {
			
			if (nums[i] != nums[i - 1] && ++index == 3) {
				return nums[i - 1];
			}
			
		}
		return nums[nums.length - 1];
	}
	
	
	public int thridMax2(int[] nums) {
		HashSet<Integer> sortMap = new HashSet<>();
		for (int num : nums) {
			sortMap.add(num);
		}
		List<Integer> list=new ArrayList<>(sortMap);
		Collections.sort(list);
		return list.size()>=3?list.get(list.size()-3):list.get(list.size()-1);
	}
	
	
	public static void main(String[] args) {
		System.out.println(new Test().thridMax2(new int[]{3, 2, 1}));
	}
}
