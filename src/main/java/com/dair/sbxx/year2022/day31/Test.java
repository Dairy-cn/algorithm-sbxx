package com.dair.sbxx.year2022.day31;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dair
 * @since
 */
public class Test {
	public static void main(String[] args) {
		int[] arr = new int[]{1, 2, 5, 2, 3};
		List<Integer> list = targetIndices(arr, 2);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
	
	public static List<Integer> targetIndices(int[] nums, int target) {
		int less = 0, same = 0;
		for (Integer i : nums) {
			if (i < target) less++;
			if (i == target) same++;
		}
		List<Integer> list = new ArrayList<>();
		for (int i = less; i < less + same; i++) {
			list.add(i);
		}
		return list;
	}
}
