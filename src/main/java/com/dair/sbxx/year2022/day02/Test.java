package com.dair.sbxx.year2022.day02;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Dair
 * @since
 */
public class Test {
	
	public int[] gridIllumination(int n, int[][] lamps, int[][] queries) {
		int[][] arr = new int[n][n];
		for (int[] lamp : lamps) {
			int i = lamp[0];
			int j = lamp[1];
			//横坐标
			for (int i1 = 0; i1 < n; i1++) {
				arr[i1][j] = 1;
			}
			for (int j1 = 0; j1 < n; j1++) {
				arr[i][j1] = 1;
			}
			int a = i;
			int b = j;
			while (a - 1 >= 0 && b - 1 >= 0) {
				arr[a - 1][b - 1] = 1;
				a--;
				b--;
			}
			a = i;
			b = j;
			while (a + 1 < n && b + 1 < n) {
				arr[a + 1][b + 1] = 1;
				a++;
				b++;
			}
			a = i;
			b = j;
			while (a - 1 >= 0 && b + 1 < n) {
				arr[a - 1][b + 1] = 1;
				a--;
				b++;
			}
			a = i;
			b = j;
			while (a + 1 < n && b - 1 >= 0) {
				arr[a + 1][b - 1] = 1;
				a++;
				b--;
			}
		}
		int[] res = new int[queries.length];
		int index = 0;
		for (int[] query : queries) {
			int i = query[0];
			int j = query[1];
			if (arr[i][j] == 1) {
				res[index++] = 1;
			}
			
			if (j - 1 >= 0) {
				arr[i][j - 1] = 0;
			}
			if (j + 1 < n) {
				arr[i][j + 1] = 0;
			}
			
			if (i - 1 >= 0) {
				arr[i - 1][j] = 0;
				if (j - 1 >= 0) {
					arr[i - 1][j - 1] = 0;
				}
				if (j + 1 < n) {
					arr[i - 1][j + 1] = 0;
				}
			}
			if (i + 1 < n) {
				arr[i + 1][j] = 0;
				if (j - 1 >= 0) {
					arr[i + 1][j - 1] = 0;
				}
				if (j + 1 < n) {
					arr[i + 1][j + 1] = 0;
				}
			}
		}
		return res;
	}
	
	int[][] dirs = new int[][]{{0, 0}, {0, -1}, {0, 1}, {-1, 0}, {-1, -1}, {-1, 1}, {1, 0}, {1, -1}, {1, 1}};
	
	public int[] gridIllumination2(int n, int[][] lamps, int[][] queries) {
		HashMap<Integer, Integer> row = new HashMap<>();
		HashMap<Integer, Integer> col = new HashMap<>();
		HashMap<Integer, Integer> left = new HashMap<>();
		HashMap<Integer, Integer> right = new HashMap<>();
		Set<Long> set = new HashSet<>();
		for (int[] lamp : lamps) {
			int i = lamp[0];
			int j = lamp[1];
			int a = i + j;
			int b = i - j;
			long index = i * n + j;
			if (!set.contains(index)) {
				increment(row, i);
				increment(col, j);
				increment(left, a);
				increment(right, b);
				set.add(index);
			}
		}
		int length = queries.length;
		int[] res = new int[length];
		int ids = 0;
		for (int[] query : queries) {
			int i = query[0];
			int j = query[1];
			int a = i + j;
			int b = i - j;
			if (row.containsKey(i) || col.containsKey(j) || left.containsKey(a) || right.containsKey(b)) {
				res[ids] = 1;
			}
			ids++;
			for (int[] dir : dirs) {
				int x = dir[0] + i;
				int y = dir[1] + j;
				int na = x + y;
				int nb = x - y;
				if (x < 0 || y < 0 || x >= n || y >= n) {
					continue;
				}
				if (set.contains(x * n + y)) {
					decrement(row, x);
					decrement(col, y);
					decrement(left, na);
					decrement(right, nb);
					set.remove(x * n + y);
				}
			}
		}
		return res;
	}
	
	void increment(Map<Integer, Integer> map, int key) {
		map.put(key, map.getOrDefault(key, 0) + 1);
	}
	
	void decrement(Map<Integer, Integer> map, int key) {
		if (map.get(key) == 1) map.remove(key);
		else map.put(key, map.get(key) - 1);
	}
}
