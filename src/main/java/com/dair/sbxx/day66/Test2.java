package com.dair.sbxx.day66;

import java.util.Arrays;

/**
 * @author Dair
 * @since
 */
public class Test2 {
	/**
	 * 冬季已经来临。 你的任务是设计一个有固定加热半径的供暖器向所有房屋供暖。
	 * <p>
	 * 在加热器的加热半径范围内的每个房屋都可以获得供暖。
	 * <p>
	 * 现在，给出位于一条水平线上的房屋 houses 和供暖器 heaters 的位置，请你找出并返回可以覆盖所有房屋的最小加热半径。
	 * <p>
	 * 说明：所有供暖器都遵循你的半径标准，加热的半径也一样。
	 * <p>
	 *  
	 * <p>
	 * 示例 1:
	 * <p>
	 * 输入: houses = [1,2,3], heaters = [2]
	 * 输出: 1
	 * 解释: 仅在位置2上有一个供暖器。如果我们将加热半径设为1，那么所有房屋就都能得到供暖。
	 * 示例 2:
	 * <p>
	 * 输入: houses = [1,2,3,4], heaters = [1,4]
	 * 输出: 1
	 * 解释: 在位置1, 4上有两个供暖器。我们需要将加热半径设为1，这样所有房屋就都能得到供暖。
	 * 示例 3：
	 * <p>
	 * 输入：houses = [1,5], heaters = [2]
	 * 输出：3
	 * <p>
	 * 来源：力扣（LeetCode）
	 * 链接：https://leetcode-cn.com/problems/heaters
	 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */
	
	public int findRadius(int[] houses, int[] heaters) {
		//1,8
		//2,6
		Arrays.sort(houses);
		Arrays.sort(heaters);
		int res = 0;
		for (int i = 0; i < houses.length; i++) {
			int house = houses[i];
			int a = binarySearch(heaters, house);
			res = Math.max(res, a);
		}
		return res;
	}
	
	private int binarySearch(int[] heaters, int target) {
		int right = heaters.length - 1;
		int left = 0;
		int res =Integer.MAX_VALUE;
		while (left <= right) {
			int mid = (right + left) / 2;
			if (heaters[mid] < target) {
				left = mid + 1;
			} else if (heaters[mid] > target) {
				right = mid - 1;
			} else {
				return 0;
			}
			int min =Math.abs( heaters[mid] - target);
			res=Math.min(res,min);
		}
		return res;
		
	}
	
	public static void main(String[] args) {
		System.out.println(new Test2().findRadius(new int[]{1, 5}, new int[]{10}));
	}
	
	
}
