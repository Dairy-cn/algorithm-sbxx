package com.dair.sbxx.day27;

import com.dair.sbxx.day17.Solution2;

/**
 * @author Dair
 * @since
 */
public class Test2 {
	
	public static void main(String[] args) {
		char[][] chars = {
				{'1', '1', '0', '0', '0'},
				{'1', '1', '0', '0', '0'},
				{'0', '0', '1', '0', '0'},
				{'0', '0', '0', '1', '1'},
		};
		System.out.println(new Test2().maxAreaOfIsland(chars));
	}
	
	public int maxAreaOfIsland(char[][] grid) {
		if (grid == null || grid.length == 0) {
			return 0;
		}
		int maxArea = 0;
		int nr = grid.length;
		int nc = grid[0].length;
		for (int i = 0; i < nr; i++) {
			for (int j = 0; j < nc; j++) {
				if (grid[i][j] == '1') {
					int a = dfs(grid, i, j);
					maxArea = Math.max(a, maxArea);
				}
				
			}
			
		}
		return maxArea;
		
	}
	
	
	public int dfs(char[][] grid, int r, int c) {
		if (!(r >= 0 && r < grid.length && c >= 0 && c < grid[0].length)) {
			return 0;
		}
		if (grid[r][c] != '1') {
			return 0;
		}
		grid[r][c]='0';
		return 1 + dfs(grid,r-1,c)+dfs(grid,r+1,c)+dfs(grid,r,c-1)+dfs(grid,r,c+1);
	}
	
}
