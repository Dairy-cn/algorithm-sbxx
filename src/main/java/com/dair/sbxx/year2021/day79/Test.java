package com.dair.sbxx.year2021.day79;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Dair
 * @since
 */
public class Test {
	/**
	 * 给你一个整数数组 arr 。
	 * <p>
	 * 现需要从数组中取三个下标 i、j 和 k ，其中 (0 <= i < j <= k < arr.length) 。
	 * <p>
	 * a 和 b 定义如下：
	 * <p>
	 * a = arr[i] ^ arr[i + 1] ^ ... ^ arr[j - 1]
	 * b = arr[j] ^ arr[j + 1] ^ ... ^ arr[k]
	 * 注意：^ 表示 按位异或 操作。
	 * <p>
	 * 请返回能够令 a == b 成立的三元组 (i, j , k) 的数目。
	 * <p>
	 * 来源：力扣（LeetCode）
	 * 链接：https://leetcode-cn.com/problems/count-triplets-that-can-form-two-arrays-of-equal-xor
	 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */
	
	public int countTriplets(int[] arr) {
		int n = arr.length;
		int res = 0;
		Map<Integer, Integer> map = new HashMap<>();
		int val = 0;
		Map<Integer, Integer> totalMap = new HashMap<>();
		for (int i = 0; i < n; i++) {
			val ^= arr[i];
			res += map.getOrDefault(val,0) * i - totalMap.getOrDefault(val, 0);
			Integer mapCount = map.getOrDefault(val ^ arr[i], 0);
			map.put(val ^ arr[i], mapCount + 1);
			Integer totalCount = totalMap.getOrDefault(val ^ arr[i], 0);
			totalMap.put(val ^ arr[i], totalCount + i);
		}
		return res;
	}
	
	public static void main(String[] args) {
		System.out.println(new Test().countTriplets(new int[]{2, 3, 1, 6, 7}));
	}
}
