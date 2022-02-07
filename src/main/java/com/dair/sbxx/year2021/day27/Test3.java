package com.dair.sbxx.year2021.day27;

/**
 * @author Dair
 * @since
 */
public class Test3 {
	
	
	public static void main(String[] args) {
		int[][] chars = {{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}};
		System.out.println(new Test3().islandPerimeter(chars));
	}
	
	public int islandPerimeter(int[][] grid) {
		if (grid == null || grid.length == 0) {
			return 0;
		}
		int maxArea = 0;
		int nr = grid.length;
		int nc = grid[0].length;
		for (int i = 0; i < nr; i++) {
			for (int j = 0; j < nc; j++) {
				if (grid[i][j] == 1) {
					return dfs(grid, i, j);
				}
				
			}
			
		}
		return maxArea;
		
	}
	
	
	public int dfs(int[][] grid, int r, int c) {
		if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length) {
			return 1;
		}
		if (grid[r][c] == 0) {
			return 1;
		}
		if (grid[r][c] != 1) {
			return 0;
		}
		grid[r][c] = 2;
		return dfs(grid, r - 1, c) + dfs(grid, r + 1, c) + dfs(grid, r, c - 1) + dfs(grid, r, c + 1);
	}
	
}
