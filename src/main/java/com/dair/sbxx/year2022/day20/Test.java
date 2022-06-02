package com.dair.sbxx.year2022.day20;

import java.util.Arrays;

/**
 * @author Dair
 * @since
 */
public class Test {
	
	/**
	 * 给你一个区间数组 intervals ，其中 intervals[i] = [starti, endi] ，且每个 starti 都 不同 。
	 * <p>
	 * 区间 i 的 右侧区间 可以记作区间 j ，并满足 startj >= endi ，且 startj 最小化 。
	 * <p>
	 * 返回一个由每个区间 i 的 右侧区间 的最小起始位置组成的数组。如果某个区间 i 不存在对应的 右侧区间 ，则下标 i 处的值设为 -1 。
	 * <p>
	 * 来源：力扣（LeetCode）
	 * 链接：https://leetcode.cn/problems/find-right-interval
	 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 *
	 * @param its
	 * @return
	 */
	public int[] findRightInterval(int[][] its) {
		int[] ans = new int[its.length];
		int[][] clone = new int[its.length][2];
		for (int i = 0; i < its.length; i++) {
			clone[i] = new int[]{its[i][0], i};
		}
		Arrays.sort(clone, (a, b) -> a[0] - b[0]);
		for (int i = 0; i < its.length; i++) {
			int l = 0;
			int r = its.length - 1;
			while (l < r) {
				int mid = (l + r) >> 1;
				if (clone[mid][0] >= its[i][1]) {
					r = mid;
				} else {
					l = mid + 1;
				}
			}
			ans[i] = clone[r][0] >= its[i][1] ? clone[r][1] : -1;
		}
		return ans;
	}
	
	
	public static void main(String[] args) {
		System.out.println(new Test().findRightInterval(new int[][]{{3, 4}, {2, 3}, {1, 2}}));
	}
	
}
