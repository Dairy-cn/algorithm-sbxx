package com.dair.sbxx.year2022.day14;

import java.util.HashMap;

/**
 * @author Dair
 * @since
 */
public class Test3 {
	/**
	 * 你需要制定一份d天的工作计划表。工作之间存在依赖，要想执行第i项工作，你必须完成全部j项工作（0 <= j < i）。
	 * <p>
	 * 你每天 至少需要完成一项任务。工作计划的总难度是这d天每一天的难度之和，而一天的工作难度是当天应该完成工作的最大难度。
	 * <p>
	 * 给你一个整数数组jobDifficulty和一个整数d，分别代表工作难度和需要计划的天数。第i项工作的难度是jobDifficulty[i]。
	 * <p>
	 * 返回整个工作计划的 最小难度 。如果无法制定工作计划，则返回-1。
	 * <p>
	 */
	
	public int minDifficulty(int[] jobDifficulty, int d) {
		if (jobDifficulty.length < d) {
			return -1;
		}
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		return helper(jobDifficulty, 0, d, map, jobDifficulty.length);
	}
	
	private int helper(int[] jobDifficulty, int index, int count, HashMap<Integer, Integer> map, int length) {
		int key = index * 100 + count;
		if (!map.containsKey(key)) {
			if (count == 1) {
				int max = 0;
				for (int j = index; j < length; j++) {
					max = Math.max(max, jobDifficulty[j]);
				}
				return max;
			}
			
			int min = Integer.MAX_VALUE;
			int currMax = 0;
			for (int j = index; j <= length - count; j++) {
				if (jobDifficulty[j] > currMax) {
					currMax = jobDifficulty[j];
				}
				min = Math.min(min, currMax+helper(jobDifficulty, j + 1, count - 1, map, length));
			}
			map.put(key, min);
		}
		return map.get(key);
	}
	
	public static void main(String[] args) {
		System.out.println(new Test3().minDifficulty(new int[]{6,5,4,3,2,1}, 2));
	}
}
