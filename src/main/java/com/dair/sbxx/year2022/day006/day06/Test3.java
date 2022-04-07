package com.dair.sbxx.year2022.day006.day06;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dair
 * @since
 */
public class Test3 {
	private List<List<Integer>> list = new ArrayList<>();
	
	public List<List<Integer>> permuteUnique(int[] nums) {
		
		List<List<Integer>> usedList = new ArrayList<>();
		permuting(nums, 0,usedList);
		return list;
	}
	
	private void permuting(int[] arr, int index,List<List<Integer>> usedList) {
		if (index == arr.length) {
			List<Integer> arrList = new ArrayList<>();
			for (int i : arr) {
				arrList.add(i);
			}
			if(!usedList.contains(arrList)){
				list.add(arrList);
			}
			return;
		} else {
			for (int i = index; i < arr.length; i++) {
				swap(arr, index, i);
				permuting(arr, index + 1,usedList);
				swap(arr, index, i);
			}
		}
	}
	
	private void swap(int[] arr, int index, int i) {
		int temp = arr[index];
		arr[index] = arr[i];
		arr[i] = temp;
	}
}
