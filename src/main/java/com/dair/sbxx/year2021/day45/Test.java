package com.dair.sbxx.year2021.day45;

import java.util.HashMap;

/*************************************************************
 * Description: 
 * Author: Dair
 * Date: year2021/10/26
 ************************************************************/
public class Test {
	
	
	public int[] nextGreaterElement(int[] nums1, int[] nums2) {
		
		int n = nums1.length;
		int m = nums2.length;
		
		int[] resArr = new int[n];
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < m; i++) {
			map.put(nums2[i], i);
		}
		for (int i = 0; i < n; i++) {
			int temp = -1;
			Integer index = map.get(nums1[i]);
			for (int j = index + 1; j < m; j++) {
				if (nums2[j] > nums1[i]) {
					temp = nums2[j];
					break;
				}
				
			}
			
			resArr[i] = temp;
			
		}
		return resArr;
		
	}
	
}
