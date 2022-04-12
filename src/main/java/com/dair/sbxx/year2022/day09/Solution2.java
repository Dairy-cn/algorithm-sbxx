package com.dair.sbxx.year2022.day09;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Dair
 * @since
 */
public class Solution2 {
	
	/**
	 * 树是一个无向图，其中任何两个顶点只通过一条路径连接。 换句话说，一个任何没有简单环路的连通图都是一棵树。
	 * <p>
	 * 给你一棵包含n个节点的树，标记为0到n - 1 。给定数字n和一个有 n - 1 条无向边的 edges列表（每一个边都是一对标签），其中 edges[i] = [ai, bi] 表示树中节点 ai 和 bi 之间存在一条无向边。
	 * <p>
	 * 可选择树中任何一个节点作为根。当选择节点 x 作为根节点时，设结果树的高度为 h 。在所有可能的树中，具有最小高度的树（即，min(h)）被称为 最小高度树 。
	 * <p>
	 * 请你找到所有的 最小高度树 并按 任意顺序 返回它们的根节点标签列表。
	 * <p>
	 * 树的 高度 是指根节点和叶子节点之间最长向下路径上边的数量。
	 *
	 * @param n
	 * @param edges
	 * @return
	 */
	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
		//eg n = 6, edges = [[3,0],[3,1],[3,2],[3,4],[5,4]]
		//[[1,0],[1,2],[1,3]
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < n - 1; i++) {
			int[] edge = edges[i];
			int a = edge[0];
			int b = edge[1];
			map.put(a, map.getOrDefault(a, 0) + 1);
			map.put(b, map.getOrDefault(b, 0) + 1);
		}
		List<Integer> list = new ArrayList<>();
		int minTreeHeight = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			int treeHeight = n;
			if (map.get(i) > 1) {
				treeHeight -= map.get(i);
			}
		}
		return null;
	}
}