package com.dair.sbxx.year2021.day27;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author Dair
 * @since
 */
public class Test5 {
	
	public static void main(String[] args) {
//		int[][] chars = {{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}};
		int[][] chars = {{1,0}, {0, 1}};
		System.out.println(new Test5().largestIsland(chars));
		
	}
	
	public int largestIsland(int[][] grid) {
		if (grid == null || grid.length == 0) {
			return 1;
		}
		int nr = grid.length;
		int nc = grid[0].length;
		int index = 2;
		HashMap<Integer, Integer> map = new HashMap<>();
		int res = 0;
		for (int i = 0; i < nr; i++) {
			
			for (int j = 0; j < nc; j++) {
				if (grid[i][j] == 1) {
					int size = dfs(grid, i, j, index);
					map.put(index++, size);
					res = Math.max(res, size);
				}
				
			}
		}
		if (res == 0) {
			return 1;
		}
		for (int i = 0; i < nr; i++) {
			for (int j = 0; j < nc; j++) {
				if (grid[i][j] == 0) {
					HashSet<Integer> hashSet = findNeighbour(grid, i, j);
					if (hashSet.size() < 1) {
						continue;
					}
					int twoIsland = 1;
					for (Integer integer : hashSet) {
						twoIsland += map.get(integer);
					}
					res=Math.max(twoIsland, res);
				}
				
			}
		}
		return res;
	}
	
	private HashSet<Integer> findNeighbour(int[][] grid, int i, int j) {
		HashSet<Integer> set = new HashSet<>();
		if (inArea(grid, i - 1, j) && grid[i - 1][j] != 0) {
			set.add(grid[i - 1][j]);
		}
		if (inArea(grid, i + 1, j) && grid[i + 1][j] != 0) {
			set.add(grid[i + 1][j]);
		}
		if (inArea(grid, i, j - 1) && grid[i][j - 1] != 0) {
			set.add(grid[i][j - 1]);
		}
		if (inArea(grid, i, j + 1) && grid[i][j + 1] != 0) {
			set.add(grid[i][j + 1]);
		}
		return set;
	}
	
	
	public int dfs(int[][] grid, int r, int c, int index) {
		if (!inArea(grid, r, c)) {
			return 0;
		}
		if (grid[r][c] != 1) {
			return 0;
		}
		grid[r][c] = index;
		return 1 + dfs(grid, r - 1, c, index) + dfs(grid, r + 1, c, index) + dfs(grid, r, c - 1, index) + dfs(grid, r, c + 1, index);
	}
	
	
	public boolean inArea(int[][] grid, int r, int c) {
		return r >= 0 && c >= 0 && grid.length > r && grid[0].length > c;
		
	}
}
