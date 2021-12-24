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
	
	
	
	public int visiblePoints2(List<List<Integer>> points, int angle, List<Integer> location) {
		// 算出每一个坐标相对于location位置与x轴的夹角（弧度制），扔到List中排序
		// 然后对于每一个点，使用二分或滑动窗口找出小于这个点+angle（转成弧度制）的最大坐标点
		// 两者之间的下标差就是从这个点出发，辐射angle角度的点数量
		// 注意，与location点相同的点的特殊处理
		
		int same = 0;
		List<Double> list = new ArrayList<>();
		int x = location.get(0), y = location.get(1);
		for (List<Integer> point : points) {
			int a = point.get(0), b = point.get(1);
			if (a == x && b == y) {
				// 与location同点
				same++;
			} else {
				// 计算角度（弧度制）
				list.add(Math.atan2(b - y, a - x));
			}
		}
		
		// 排序
		Collections.sort(list);
		
		// 把前面所有的数添加一遍到后面，类似于于循环数组的使用
		int size = list.size();
		for (int i = 0; i < size; i++) {
			// 加 360度，然后范围相当于变成了 [-pi, 3*pi]
			list.add(list.get(i) + 2 * Math.PI);
		}
		
		double angleDegree = angle * Math.PI / 180;
		int max = 0;
		int i = 0, j = 0;
		while (i < size) {
			// 滑动窗口，简单点，list是有序的，使用二分查找也是可以的
			while (j < 2 * size && list.get(j) - list.get(i) <= angleDegree) {
				j++;
			}
			max = Math.max(max, j - i);
			i++;
		}
		
		return max + same;
	}
	
	
	public static void main(String[] args) {
		ArrayList<List<Integer>> list = new ArrayList<>();
		List<Integer> list1=new ArrayList<>();
		list1.add(2);
		list1.add(1);
		list.add(list1);
		List<Integer> list2=new ArrayList<>();
		list2.add(2);
		list2.add(2);
		list.add(list2);
		
		List<Integer> list3=new ArrayList<>();
		list3.add(3);
		list3.add(3);
		list.add(list3);
		
		ArrayList<Integer> list4 = new ArrayList<>();
		list4.add(1);
		list4.add(2);
		new Test().visiblePoints(list,90,list4);
	}
	
}
