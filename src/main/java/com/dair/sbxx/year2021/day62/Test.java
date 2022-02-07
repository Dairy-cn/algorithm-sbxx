package com.dair.sbxx.year2021.day62;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Dair
 * @since
 */
public class Test {
	
	
	public int[] loudAndRich(int[][] richer, int[] quiet) {
		List<Integer>[] list = new List[quiet.length];
		
		for (int i : quiet) {
			list[i] = new ArrayList<>();
		}
		for (int[] ints : richer) {
			list[ints[1]].add(ints[0]);
		}
		int[] resArr = new int[quiet.length];
		Arrays.fill(resArr, -1);
		for (int i = 0; i < quiet.length; i++) {
			dfs(quiet, list, resArr, i);
		}
		return resArr;
	}
	
	private void dfs(int[] quiet, List<Integer>[] list, int[] resArr, int x) {
		if (resArr[x] != -1) {
			return;
		}
		resArr[x] = x;
		for (Integer y : list[x]) {
			dfs(quiet, list, resArr, y);
			if (quiet[resArr[y]] < quiet[resArr[x]]) {
				resArr[x] = resArr[y];
			}
		}
	}
	
	public static void main(String[] args) {
		//[[1,0],[2,1],[3,1],[3,7],[4,3],[5,3],[6,3]]
		//[3,2,5,4,6,1,7,0]
		new Test().loudAndRich(new int[][]{{1,0},{2,1},{3,1},{3,7},{4,3},{5,3},{6,3}},new int[]{3,2,5,4,6,1,7,0});
	}
	
}
