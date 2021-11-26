package com.dair.sbxx.day57;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Dair
 * @since
 */
public class Test2 {
	
	public int maxEqualRowsAfterFlips(int[][] matrix) {
		int c = matrix.length;
		HashMap<String, Integer> map = new HashMap<>();
		for (int i = 0; i < c; i++) {
			//如果第一个是1,直接把该行转换为字符串，当作hash表的key
			int[] column = matrix[i];
			StringBuilder sb = new StringBuilder();
			boolean flag = true;
			if (column[0] != 1) {
				flag = false;
			}
			for (int j = 0; j < column.length; j++) {
				sb.append(flag ? column[j] : column[j] ^ 1);
			}
			map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
		}
		int res = 0;
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			res = Math.max(res, entry.getValue());
		}
		
		return res;
	}
	
	
	public static void main(String[] args) {
		System.out.println(new Test2().maxEqualRowsAfterFlips(new int[][]{{0, 0, 0}, {0, 0, 1}, {1, 1, 0}}));
	}
	
	
	public int maxEqualRowsAfterFlips2(int[][] matrix) {
		// 翻转之后，行与行之间所有值相等 ==> 行与行之间所有值要么相等，要么相反
		int m = matrix.length,
				n = matrix[0].length;
		Trie root = new Trie();
		int res = 0;
		for (int i = 0; i < m; i++) {
			Trie node = root, xNode = root;
			for (int j = 0; j < n; j++) {
				int v = matrix[i][j];
				if (node.son[v] == null) {
					node.son[v] = new Trie();
				}
				node = node.son[v];
				if (xNode.son[v^1] == null) {
					xNode.son[v^1] = new Trie();
				}
				xNode = xNode.son[v^1];
			}
			res = Math.max(res, Math.max(++node.cnt, ++xNode.cnt));
		}
		return res;
	}
	class Trie {
		Trie[] son = new Trie[2];
		int cnt;
		
		public Trie() {
			cnt = 0;
		}
	}
}
