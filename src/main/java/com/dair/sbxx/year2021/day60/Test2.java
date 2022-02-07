package com.dair.sbxx.year2021.day60;

import java.util.Arrays;

/**
 * @author Dair
 * @since
 */
public class Test2 {
	
	
	public String[] findRelativeRanks(int[] score) {
		
		int n = score.length;
		String[] strings = new String[]{"Gold Medal", "Silver Medal", "Bronze Medal"};
		String[] res = new String[n];
		int[][] arr = new int[n][2];
		
		for (int i = 0; i < n; i++) {
			arr[i][0] = score[i];
			arr[i][1] = i;
		}
		Arrays.sort(arr, (a, b) -> b[0] - a[0]);
		
		for (int i = 0; i < n; i++) {
			if (i < 3) {
				res[arr[i][1]] = strings[i];
			} else {
				res[arr[i][1]] = (i + 1) + "";
			}
		}
		return res;
		
	}
}
