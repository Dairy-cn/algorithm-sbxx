package com.dair.sbxx.year2021.day17;

//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
//		岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
//		此外，你可以假设该网格的四条边均被水包围。
//
//		示例 1：
//		输入：grid = [
//		["1","1","1","1","0"],
//		["1","1","0","1","0"],
//		["1","1","0","0","0"],
//		["0","0","0","0","0"]
//		]
//		输出：1
//
//		实例二:
//		输入：grid = [
//		["1","1","0","0","0"],
//		["1","1","0","0","0"],
//		["0","0","1","0","0"],
//		["0","0","0","1","1"]
//		]
//		输出：3
//		提示：
//		m == grid.length
//		n == grid[i].length
//		1 <= m, n <= 300
//		grid[i][j] 的值为 '0' 或 '1'
public class Solution2 {
	
	public static void main(String[] args) {
		char[][] chars = {
				{'1', '1', '0', '0', '0'},
				{'1', '1', '0', '0', '0'},
				{'0', '0', '1', '0', '0'},
				{'0', '0', '0', '1', '1'},
		};
		System.out.println(new Solution2().numIsland(null));
	}
	
	public int numIsland(char[][] grid) {
		
		if (grid == null || grid.length == 0) {
			return 0;
		}
		int num = 0;
		int nr = grid.length;
		int nc = grid[0].length;
		for (int i = 0; i < nr; i++) {
			for (int j = 0; j < nc; j++) {
				
				if (grid[i][j] == '1') {
					++num;
					dfs(grid, i, j);
				}
			}
		}
		return num;
	}
	
	
	public void dfs(char[][] grid, int r, int c) {
		int nr = grid.length;
		int nc = grid[0].length;
		if (r < 0 || c < 0 || nr <= r || c >= nc || grid[r][c] == '0') {
			return;
		}
		grid[r][c] = '0';
		dfs(grid, r - 1, c);
		dfs(grid, r + 1, c);
		dfs(grid, r, c - 1);
		dfs(grid, r, c + 1);
		
	}
}
