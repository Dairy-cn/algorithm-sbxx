package com.dair.sbxx.year2022.day25;


import java.util.ArrayList;
import java.util.List;

/**
 * @author Dair
 * @since
 */
public class Test1 {
	/**
	 * 给你两个整数x 和y，表示你在一个笛卡尔坐标系下的(x, y)处。
	 * <p>
	 * 同时，在同一个坐标系下给你一个数组points，
	 * 其中points[i] = [ai, bi]表示在(ai, bi)处有一个点。当一个点与你所在的位置有相同的 x 坐标或者相同的 y 坐标时，我们称这个点是 有效的。
	 * <p>
	 * 请返回距离你当前位置曼哈顿距离最近的有效点的下标（下标从 0 开始）。如果有多个最近的有效点，请返回下标最小的一个。如果没有有效点，请返回-1。
	 * <p>
	 * 两个点 (x1, y1)和 (x2, y2)之间的 曼哈顿距离为abs(x1 - x2) + abs(y1 - y2)。
	 * <p>
	 * 来源：力扣（LeetCode）
	 * 链接：https://leetcode.cn/problems/find-nearest-point-that-has-the-same-x-or-y-coordinate
	 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 * 1,2,2,2
	 */
	
	public int nearestValidPoint(int x, int y, int[][] points) {
		int res = -1;
		int minDistance = Integer.MAX_VALUE;
		int length = points.length;
		for (int l = 0; l < length; l++) {
			int[] point=points[l];
			int i = point[0];
			int j = point[1];
			if (x == i || j == y) {
				int distance = Math.abs(x - i) + Math.abs(y - j);
				if (distance < minDistance) {
					res=l;
					minDistance = distance;
				}
			}
			
		}
		return res;
	}
	
	public static void main(String[] args) {
		System.out.println(new Test1().nearestValidPoint(3, 4, new int[][]{{1,2},{3,1},{2,4},{2,3},{4,4}}));
	}
}
