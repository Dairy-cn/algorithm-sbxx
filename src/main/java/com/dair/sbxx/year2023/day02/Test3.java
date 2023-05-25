package com.dair.sbxx.year2023.day02;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Dair
 * @since
 */
public class Test3 {
	
	private int n;
	private int k;
	private int ans;
	
	public int numWays(int _n, int[][] relation, int _k) {
		//深度优先算法
		// [[0,2],[2,1],[3,4],[2,3],[1,4],[2,0],[0,4]]
		HashMap<Integer, Set<Integer>> map = new HashMap<>();
		for (int i = 0; i < relation.length; i++) {
			Set<Integer> set = map.getOrDefault(relation[i][0], new HashSet<>());
			set.add(relation[i][1]);
			map.put(relation[i][0], set);
		}
		// 0 -> 2,4
		// 2->1,3,0,
		// 3->4
		k = _k;
		n = _n;
		findNumWays(0, 0, map);
		return ans;
	}
	
	public void findNumWays(int index, int sum, HashMap<Integer, Set<Integer>> map) {
		if (sum == k) {
			if (index == n - 1) {
				ans++;
			}
			return;
		}
		Set<Integer> set = map.get(index);
		if (set == null) {
			return;
		}
		for (Integer i : set) {
			findNumWays(i, sum + 1, map);
		}
	}
	
	
	public static void main(String[] args) {
		System.out.println(new Test3().numWays(5, new int[][]{{0, 2}, {2, 1}, {3, 4}, {2, 3}, {1, 4}, {2, 0}, {0, 4}}, 3));
		
	}
}
