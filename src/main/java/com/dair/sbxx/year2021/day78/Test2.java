package com.dair.sbxx.year2021.day78;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Dair
 * @since
 */
public class Test2 {
	
	public int findMinDifference(List<String> timePoints) {
		int n = timePoints.size();
		int[] arr = new int[n * 2];
		for (int i = 0, index = 0; i < n; i++, index += 2) {
			String s = timePoints.get(i);
			String[] split = s.split(":");
			int h = Integer.parseInt(split[0]);
			int m = Integer.parseInt(split[1]);
			arr[index] = h * 60 + m;
			arr[index + 1] = arr[index] + 1440;
		}
		Arrays.sort(arr);
		int ans = arr[1] - arr[0];
		for (int i = 0; i < n * 2 - 1; i++) ans = Math.min(ans, arr[i + 1] - arr[i]);
		return ans;
	}
	
	public int findMinDifference2(List<String> timePoints) {
		//将timePoints排序
		Collections.sort(timePoints);
		String s = timePoints.get(0);
		int firstTime = getMintues(timePoints.get(0));
		int preTime = firstTime;
		int ans = Integer.MAX_VALUE;
		for (int i = 1; i < timePoints.size(); i++) {
			int mintues = getMintues(timePoints.get(i));
			ans = Math.min(ans, mintues - preTime);
			preTime = mintues;
		}
		ans = Math.min(ans, firstTime - preTime + 1440);
		return ans;
	}
	
	private int getMintues(String s) {
		String[] split = s.split(":");
		int h = Integer.parseInt(split[0]);
		int m = Integer.parseInt(split[1]);
		return h * 60 + m;
	}
	
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
		list.add("23:59");
		list.add("00:00");
		System.out.println(new Test2().findMinDifference(list));
	}
}
