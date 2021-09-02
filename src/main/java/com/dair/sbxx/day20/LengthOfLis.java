package com.dair.sbxx.day20;

import java.util.Arrays;

/**
 * @author Dair
 * @since
 */
public class LengthOfLis {
	
	
	/**
	 * 计算出最长子序列长度
	 * @param nums
	 * @return
	 */
	public int sulotion(int[] nums) {
		
		int len = nums.length;
		int d[] = new int[len];
		Arrays.fill(d, 1);
		int res = 0;
		for (int i = 1; i < len; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) {
					d[i] = Math.max(d[i], d[j] + 1);
				}
			}
			res = Math.max(res, d[i]);
		}
		generateLIS(nums, d);
		return res;
	}
	
	
	/**
	 * 计算最长递增子序列
	 * @param arr
	 * @param dp
	 */
	public void generateLIS(int arr[], int dp[]) {
		
		int index = 0;
		int len = dp[0];
		for (int i = 1; i < dp.length; i++) {
			if (dp[i] > dp[i - 1]) {
				index = i;
				len = dp[i];
			}
		}
		int[] resultArr = new int[len];
		int k = 0;
		resultArr[k++] = arr[index];
		for (int i = index - 1; i >= 0; i--) {
			if (dp[index] == dp[i] + 1 && arr[index] > arr[i]) {
				resultArr[k++] = arr[i];
				--index;
			}
		}
		Arrays.sort(resultArr);
		for (int i : resultArr) {
			System.out.println("--" + i);
		}
		
	}
	
	public static void main(String[] args) {
		System.out.println(new LengthOfLis().sulotion(new int[]{0,1,0,3,2,3}));
	}
}
