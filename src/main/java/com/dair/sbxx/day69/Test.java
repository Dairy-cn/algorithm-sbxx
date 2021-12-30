package com.dair.sbxx.day69;

/**
 * @author Dair
 * @since
 */
public class Test {
	/**
	 * 给你一个 下标从 0 开始 的整数数组 nums ，返回满足下述条件的 不同 四元组 (a, b, c, d) 的 数目 ：
	 * <p>
	 * nums[a] + nums[b] + nums[c] == nums[d] ，且
	 * a < b < c < d
	 *  
	 * <p>
	 * 示例 1：
	 * <p>
	 * 输入：nums = [1,2,3,6]
	 * 输出：1
	 * 解释：满足要求的唯一一个四元组是 (0, 1, 2, 3) 因为 1 + 2 + 3 == 6 。
	 * 示例 2：
	 * <p>
	 * 输入：nums = [3,3,6,4,5]
	 * 输出：0
	 * 解释：[3,3,6,4,5] 中不存在满足要求的四元组。
	 * 示例 3：
	 * <p>
	 * 输入：nums = [1,1,1,3,5]
	 * 输出：4
	 * 解释：满足要求的 4 个四元组如下：
	 * - (0, 1, 2, 3): 1 + 1 + 1 == 3
	 * - (0, 1, 3, 4): 1 + 1 + 3 == 5
	 * - (0, 2, 3, 4): 1 + 1 + 3 == 5
	 * - (1, 2, 3, 4): 1 + 1 + 3 == 5
	 * <p>
	 * 来源：力扣（LeetCode）
	 * 链接：https://leetcode-cn.com/problems/count-special-quadruplets
	 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */
	
	
	public int countQuadruplets(int[] nums) {
		int n = nums.length;
		int res = 0;
		int[] arr = new int[410];
		for (int b = n - 3; b > 0; b--) {
			for (int d = b + 2; d < n; d++) {
				if(nums[d] - nums[b + 1]>0){
					arr[nums[d] - nums[b + 1] ]++;
				}
			}
			for (int a = 0; a < b; a++) {
				res += arr[nums[a] + nums[b]];
			}
		}
		return res;
		
	}
	
	public static void main(String[] args) {
		System.out.println(new Test().countQuadruplets(new int[]{28, 8, 49, 85, 37, 90, 20, 8}));
	}
	
	
}
