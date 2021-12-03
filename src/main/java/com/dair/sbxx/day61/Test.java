package com.dair.sbxx.day61;

import java.util.Arrays;

/**
 * @author Dair
 * @since
 */
public class Test {
	
	/**
	 * 给你一个整数数组 nums 和一个整数 k ，按以下方法修改该数组：
	 * <p>
	 * 选择某个下标 i并将 nums[i] 替换为 -nums[i] 。
	 * 重复这个过程恰好 k 次。可以多次选择同一个下标 i 。
	 * <p>
	 * 以这种方式修改数组后，返回数组 可能的最大和 。
	 * <p>
	 * <p>
	 * <p>
	 * 示例 1：
	 * <p>
	 * 输入：nums = [4,2,3], k = 1
	 * 输出：5
	 * 解释：选择下标 1 ，nums 变为 [4,-2,3] 。
	 * 示例 2：
	 * <p>
	 * 输入：nums = [3,-1,0,2], k = 4
	 * 输出：6
	 * 解释：选择下标 (1, 2, 2) ，nums 变为 [3,1,0,2] 。
	 * 示例 3：
	 * <p>
	 * 输入：nums = [2,-3,-1,5,-4], k = 2
	 * 输出：13
	 * 解释：选择下标 (1, 4) ，nums 变为 [2,3,-1,5,4] 。
	 * <p>
	 * <p>
	 * 来源：力扣（LeetCode）
	 * 链接：https://leetcode-cn.com/problems/maximize-sum-of-array-after-k-negations
	 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */
	
	public int largestSumAfterKNegations(int[] nums, int k) {
		Arrays.sort(nums);
		int n = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] < 0) {
				n++;
			} else {
				break;
			}
		}
		if (n >= k) {
			for (int i = 0; i < k; i++) {
				nums[i] = -nums[i];
			}
		} else {
			if (n > 0) {
				for (int i = 0; i < n; i++) {
					nums[i] = -nums[i];
				}
			}
			int m = k - n;
			if (m % 2 != 0) {
				Arrays.sort(nums);
				nums[0] = -nums[0];
			}
		}
		int ans = 0;
		for (int i = 0; i < nums.length; i++) {
			ans += nums[i];
		}
		return ans;
	}
	
	public static void main(String[] args) {
		System.out.println(new Test().largestSumAfterKNegations(new int[]{-8,3,-5,-3,-5,-2}, 6));
	}
	
	
}
