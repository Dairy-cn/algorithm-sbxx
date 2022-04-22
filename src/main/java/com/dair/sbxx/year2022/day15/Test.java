package com.dair.sbxx.year2022.day15;

import java.util.HashMap;

/**
 * @author Dair
 * @since
 */
public class Test {
	
	
	public int minDifficulty(int[] jobDifficulty, int d) {
		if (jobDifficulty.length < d) {
			return -1;
		}
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		return helper(jobDifficulty, 0, d, map, jobDifficulty.length);
	}
	
	private int helper(int[] jobDifficulty, int i, int d, HashMap<Integer, Integer> map, int length) {
		//6、5、4、3、2、1  2
		int key = i * 100 + d;
		if (!map.containsKey(key)) {
			if (d == 1) {
				int max = 0;
				for (int j = i; j < length; j++) {
					if (max < jobDifficulty[j]) {
						max = jobDifficulty[j];
					}
				}
				return max;
			}
			int min = Integer.MAX_VALUE;
			int currMax = 0;
			for (int j = i; j <= length-d; j++) {
				if (jobDifficulty[j] > currMax) {
					currMax = jobDifficulty[j];
				}
				min =  Math.min(min, currMax+helper(jobDifficulty, j + 1, d - 1, map, length));
			}
			map.put(key,min);
		}
		return map.get(key);
	}
	
	public static void main(String[] args) {
		System.out.println(new Test().minDifficulty(new int[]{5,4,3,2,1},2));
	}
}
