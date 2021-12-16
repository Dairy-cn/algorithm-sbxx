package com.dair.sbxx.day62;

import java.sql.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author Dair
 * @since
 */
public class Test2 {
	
	/**
	 * 拓扑排序
	 *
	 * @param richer
	 * @param quiet
	 * @return
	 */
	public int[] loudAndRich(int[][] richer, int[] quiet) {
		
		int n = quiet.length;
		int[] inDeg = new int[n];
		List<Integer>[] g = new List[n];
		for (int i = 0; i < n; i++) {
			g[i] = new ArrayList<>();
		}
		for (int[] ints : richer) {
			++inDeg[ints[1]];
			g[ints[0]].add(ints[1]);
		}
		int[] res = new int[n];
		for (int i = 0; i < res.length; i++) {
			res[i] = i;
		}
		Queue<Integer> queue = new ArrayDeque<>();
		for (int i = 0; i < inDeg.length; i++) {
			if (inDeg[i] == 0) {
				queue.offer(i);
			}
		}
		while (!queue.isEmpty()) {
			Integer x = queue.poll();
			for (Integer y : g[x]) {
				if (quiet[res[x]] < quiet[res[y]]) {
					res[y] = res[x];
				}
				if (--inDeg[y] == 0) {
					queue.offer(y);
				}
			}
		}
		return res;
	}
	
}
