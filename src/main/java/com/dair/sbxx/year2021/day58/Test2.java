package com.dair.sbxx.year2021.day58;

import java.util.Arrays;

/**
 * @author Dair
 * @since
 */
public class Test2 {
	
	/**
	 * 有一个自行车手打算进行一场公路骑行，这条路线总共由n + 1个不同海拔的点组成。自行车手从海拔为 0的点0开始骑行。
	 * <p>
	 * 给你一个长度为 n的整数数组gain，其中 gain[i]是点 i和点 i + 1的 净海拔高度差（0 <= i < n）。请你返回 最高点的海拔 。
	 * <p>
	 * <p>
	 * <p>
	 * 示例 1：
	 * <p>
	 * 输入：gain = [-5,1,5,0,-7]
	 * 输出：1
	 * 解释：海拔高度依次为 [0,-5,-4,1,1,-6] 。最高海拔为 1 。
	 * 示例 2：
	 * <p>
	 * 输入：gain = [-4,-3,-2,-1,4,3,2]
	 * 输出：0
	 * 解释：海拔高度依次为 [0,-4,-7,-9,-10,-6,-3,-1] 。最高海拔为 0 。
	 * <p>
	 * <p>
	 * 提示：
	 * <p>
	 * n == gain.length
	 * 1 <= n <= 100
	 * -100 <= gain[i] <= 100
	 * <p>
	 * 来源：力扣（LeetCode）
	 * 链接：https://leetcode-cn.com/problems/find-the-highest-altitude
	 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 *
	 * @param gain
	 * @return
	 */
	public int largestAltitude(int[] gain) {
		int n = gain.length;
		int[] arr = new int[n + 1];
		for (int i = 1; i < n + 1; i++) {
			arr[i] = gain[i - 1] + arr[i - 1];
		}
		Arrays.sort(arr);
		return arr[arr.length - 1];
	}
	
	public int largestAltitude2(int[] gain) {
		int max = 0;
		int currentMax = 0;
		for (int i = 0; i < gain.length; i++) {
			currentMax += gain[i];
			if (currentMax > max) {
				max = currentMax;
			}
		}
		return max;
	}
}
