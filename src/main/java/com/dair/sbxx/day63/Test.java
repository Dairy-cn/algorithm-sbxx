package com.dair.sbxx.day63;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Dair
 * @since
 */
public class Test {
	
	
	public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
		List<Double> angleList = new ArrayList<>();
		int locationX = location.get(0);
		int locationy = location.get(1);
		int sameCnt = 0;
		for (List<Integer> point : points) {
			int x = point.get(0);
			int y = point.get(1);
			if (x == locationX && y == locationy) {
				sameCnt++;
				continue;
			}
			double degree = Math.atan2(y - locationy, x - locationX);
			angleList.add(degree);
		}
		Collections.sort(angleList);
		int n = angleList.size();
		//使得可以分布到[-π，3π]，避免出现角度angle=20,一个点在第二象限，如170度，另一个点在第三象限（-170），无法统计出来
		for (int i = 0; i < n; i++) {
			angleList.add(angleList.get(i) + 2 * Math.PI);
		}
		int maxCnt = 0;
		double toDegree = angle * Math.PI / 180;
		//滑动窗口
//		while (i < n) {
//			while (j < 2*n && angleList.get(j) - angleList.get(i) <= toDegree) {
//				j++;
//			}
//			maxCnt = Math.max(maxCnt, j - i);
//		}
		//二分查找
		for (int j = 0; j < n; j++) {
			int interation = binarySearch(angleList, toDegree + angleList.get(j));
			maxCnt = Math.max(maxCnt, interation);
		}
		return maxCnt + sameCnt;
	}
	
	
	private int binarySearch(List<Double> nums, Double target) {
		int left = 0;
		int n = nums.size();
		int right = n - 1;
		int anr = n;
		
		//确定二分查找的边界
		while (left <= right) {
			int mid = (left + right) / 2;
			
			if (nums.get(mid) > target) {
				right = mid - 1;
				anr = mid;
			} else {
				left = mid + 1;
			}
		}
		return anr;
	}
}
