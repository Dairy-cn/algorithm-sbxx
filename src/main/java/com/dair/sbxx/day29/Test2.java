package com.dair.sbxx.day29;

//给定两个数组，编写一个函数来计算它们的交集。
//
//
//
// 示例 1：
//
// 输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2]
//
//
// 示例 2：
//
// 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[9,4]
//
//
//
// 说明：
//
//
// 输出结果中的每个元素一定是唯一的。
// 我们可以不考虑输出结果的顺序。
//
// Related Topics 数组 哈希表 双指针 二分查找 排序
// 👍 418 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Test2 {
	public int[] intersection(int[] nums1, int[] nums2) {
		
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		
		List<Integer> list = new ArrayList<>();
		
		for (int i = 0, j = 0; i < nums1.length && j < nums2.length; ) {
			if (nums1[i] == nums2[j]) {
				list.add(nums1[i]);
				while (i + 1 < nums1.length && nums1[i] == nums1[i + 1]) {
					++i;
				}
				while (j + 1 < nums2.length && nums2[j] == nums2[j + 1]) {
					++j;
				}
				++j;
			} else if (nums1[i] > nums2[j]) {
				++j;
			} else {
				++i;
			}
			
		}
		int[] resArr = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			resArr[i] = list.get(i);
		}
		return resArr;
		
	}
}
//leetcode submit region end(Prohibit modification and deletion)

