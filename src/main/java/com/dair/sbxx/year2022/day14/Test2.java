package com.dair.sbxx.year2022.day14;

/**
 * @author Dair
 * @since
 */
public class Test2 {
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
		//6、5、4、3、2 6 1   //2
		//arr[2]
		int[] arr = new int[d + 1];
		for (int i = 0, j = 1; i < jobDifficulty.length; i++) {
			int max = jobDifficulty[i];
			while ((jobDifficulty.length - 1 - i) > (d - j) && i + 1 < jobDifficulty.length) {
				if (jobDifficulty[i + 1] > jobDifficulty[i]) {
					max = jobDifficulty[i + 1];
				}
				i++;
			}
			arr[j] = max + arr[j - 1];
			++j;
		}
		return arr[d];
	}
	
	public static void main(String[] args) {
		System.out.println(new Test2().minDifficulty(new int[]{11, 111, 22, 222, 33, 333, 44, 444}, 6));
	}
}
