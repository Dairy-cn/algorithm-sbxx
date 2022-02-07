package com.dair.sbxx.year2021.day75;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Dair
 * @since
 */
public class Test4 {
	
	int EDGE = (int) 1e6, MAX = (int) 1e5;
	long BASE = 131L;
	Set<Long> set = new HashSet<>();
	int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	
	public boolean isEscapePossible(int[][] blocked, int[] s, int[] t) {
		
		for (int[] ints : blocked) {
			set.add(ints[0] * BASE + ints[1]);
		}
		int length = blocked.length;
		MAX = length * (length - 1) / 2;
		return check(s, t) && check(t, s);
	}
	
	private boolean check(int[] s, int[] t) {
		Set<Long> vis = new HashSet<>();
		Deque<int[]> deque = new ArrayDeque<>();
		deque.offer(s);
		while (!deque.isEmpty() && vis.size() <= MAX) {
			int[] arr = deque.poll();
			int x = arr[0];
			int y = arr[1];
			for (int i = 0; i < 4; i++) {
				int nx = x + dir[i][0];
				int ny = y + dir[i][1];
				Long hash = nx * BASE + ny;
				if (nx >= 0 && ny >= 0 && nx < EDGE && ny < EDGE && !vis.contains(hash) && !set.contains(hash)) {
					if (nx == t[0] && ny == t[1]) {
						return true;
					}
					deque.offer(new int[]{nx, ny});
					vis.add(hash);
				}
				
			}
			
		}
		return vis.size() > MAX;
	}
	
	
	public static void main(String[] args) {
		System.out.println(new Test4().isEscapePossible(new int[][]{{0,999991},{0,999993},{0,999996},{1,999996},{1,999997},{1,999998},{1,999999}},new int[]{0,999997},new int[]{0,2}));
	}
}
