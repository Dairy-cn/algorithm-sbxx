package com.dair.sbxx.year2021.day40;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*************************************************************
 * Description: 
 * Author: Dair
 * Date: year2021/10/20
 ************************************************************/
public class Test4 {
	
	public static void main(String[] args) {
		System.out.println(new Test4().jobScheduling(new int[]{1,2,3,3},new int[]{3,4,5,6},new int[]{50,10,40,70}));
	}
	
	public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
		int n = startTime.length;
		List<int[]> jobs = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			jobs.add(new int[]{startTime[i], endTime[i], profit[i]});
		}
		Collections.sort(jobs, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
		});
		int[] dp = new int[n];
		dp[0] = jobs.get(0)[2];
		for (int i = 1; i < n; i++) {
			dp[i] = Math.max(dp[i - 1], jobs.get(i)[2]);
			int l = 0, r = i - 1;
			while (l < r) {
				int mid = (r - l) / 2 + l + 1;
				if (jobs.get(mid)[1] <= jobs.get(i)[0]) {
					l = mid;
				} else {
					r = mid - 1;
				}
			}
			int j = l;
			if (jobs.get(j)[1] <= jobs.get(i)[0]) {
				dp[i] = Math.max(dp[i], dp[j] + jobs.get(i)[2]);
			}
		}
		return dp[n - 1];
	}
	
}
