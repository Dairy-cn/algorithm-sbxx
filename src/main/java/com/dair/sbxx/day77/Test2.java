package com.dair.sbxx.day77;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author Dair
 * @since
 */
public class Test2 {
	
	public int[][] construct2DArray(int[] original, int m, int n) {
		int length = original.length;
		if (length != m * n) {
			return new int[][]{};
		}
		int[][] ints = new int[m][n];
		int index = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				ints[i][j] = original[index++];
			}
		}
		return ints;
	}
	
	public int lastRemaining(int n) {
		int head = 1;
		int step = 1;
		boolean left = true;
		while (n > 1) {
			if (left || n % 2 != 0) {
				head += step;
			}
			step *= 2;
			left = !left;
			n /= 2;
		}
		return head;
	}
	
	/**
	 * 给定两个以升序排列的整数数组 nums1 和 nums2,以及一个整数 k。
	 * <p>
	 * 定义一对值(u,v)，其中第一个元素来自nums1，第二个元素来自 nums2。
	 * <p>
	 * 请找到和最小的 k个数对(u1,v1), (u2,v2) ... (uk,vk)。
	 *
	 * @param nums1
	 * @param nums2
	 * @param k
	 * @return
	 */
	public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		List<List<Integer>> ans = new ArrayList<>();
		
		PriorityQueue<int[]> queue = new PriorityQueue<>(k, (a, b) -> {
			return nums1[a[0]] + nums2[a[1]] - nums1[b[0]] - nums2[b[1]];
		});
		int m = nums1.length;
		int n = nums2.length;
		for (int i = 0; i < Math.min(m, k); i++) {
			queue.offer(new int[]{i, 0});
		}
		while (k-- > 0 && !queue.isEmpty()) {
			int[] ints = queue.poll();
			List<Integer> list = new ArrayList<>();
			list.add(nums1[ints[0]]);
			list.add(nums2[ints[1]]);
			ans.add(list);
			if (ints[1] + 1 < n) {
				queue.offer(new int[]{ints[0], ints[1] + 1});
			}
		}
		return ans;
	}
	
	public int kthSmallest(int[][] matrix, int k) {
		
		PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(k, (a, b) -> {
			return matrix[a[0]][a[1]] - matrix[b[0]][b[1]];
		});
		for (int i = 0; i < Math.min(matrix.length, k); i++) {
			priorityQueue.offer(new int[]{matrix[i][0]});
		}
		int res = 0;
		while (k-- > 0) {
		
		}
		return res;
	}
	
	public static void main(String[] args) {
		System.out.println(new Test2().kSmallestPairs(new int[]{3, 7, 11}, new int[]{2, 4, 6}, 3));
	}
}
