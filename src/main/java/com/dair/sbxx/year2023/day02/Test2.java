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
public class Test2 {
	
	public int numWays(int n, int[][] relation, int k) {
		//广度优先算法
		// [[0,2],[2,1],[3,4],[2,3],[1,4],[2,0],[0,4]]
		HashMap<Integer, Set<Integer>> map = new HashMap<>();
		for (int i = 0; i < relation.length; i++) {
			Set<Integer> set = map.getOrDefault(relation[i][0], new HashSet<>());
			set.add(relation[i][1]);
			map.put(relation[i][0], set);
		}
		
		Deque<Integer> d = new ArrayDeque<>();
		d.addFirst(0);
		while (k-- > 0 && !d.isEmpty()) {
			int size = d.size();
			while (size-- > 0) {
				Integer first = d.pollFirst();
				Set<Integer> set = map.get(first);
				if (set == null) {
					continue;
				}
				for (Integer next : set) {
					d.addLast(next);
				}
			}
			
		}
		
		int ans = 0;
		while (!d.isEmpty()) {
			if (d.pollFirst() == n - 1) {
				++ans;
			}
		}
		return ans;
	}
	
	public static void main(String[] args) {
		System.out.println(new Test2().numWays(5, new int[][]{{0, 2}, {2, 1}, {3, 4}, {2, 3}, {1, 4}, {2, 0}, {0, 4}}, 3));
		
	}
}
