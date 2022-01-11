package com.dair.sbxx.day75;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @author Dair
 * @since
 */
public class Test3 {
	
	 static final int BOUNDARY = 1000000;
	
	static final int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	
	public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
		
		if (blocked.length < 2) {
			return true;
		}
		//离散
		TreeSet<Integer> rowMap = new TreeSet();
		TreeSet<Integer> columnMap = new TreeSet();
		for (int i = 0; i < blocked.length; i++) {
			int[] ints = blocked[i];
			rowMap.add(ints[0]);
			columnMap.add(ints[1]);
		}
		rowMap.add(source[0]);
		rowMap.add(target[0]);
		columnMap.add(source[1]);
		columnMap.add(target[1]);
		
		Map<Integer, Integer> rMapping = new HashMap<Integer, Integer>();
		Map<Integer, Integer> cMapping = new HashMap<Integer, Integer>();
		
		int rFirst = rowMap.first();
		int rId = (rFirst == 0) ? 0 : 1;
		rMapping.put(rFirst, rId);
		int preRow = rFirst;
		for (int integer : rowMap) {
			//TODO
			if (integer == preRow) {
				continue;
			}
			rId += (preRow + 1 == integer) ? 1 : 2;
			rMapping.put(integer, rId);
			preRow = integer;
		}
		if (preRow != BOUNDARY - 1) {
			++rId;
		}
		
		int cFirst = columnMap.first();
		int cId = cFirst == 0 ? 0 : 1;
		cMapping.put(cFirst, cId);
		int preColumn = cFirst;
		for (int integer : columnMap) {
			if (integer == preColumn) {
				continue;
			}
			cId += (preColumn + 1 == integer) ? 1 : 2;
			cMapping.put(integer, cId);
			preColumn = integer;
		}
		if (preColumn != BOUNDARY - 1) {
			++cId;
		}
		
		int[][] newArr = new int[rId + 1][cId + 1];
		for (int[] ints : blocked) {
			
			int x = ints[0];
			int y = ints[1];
			newArr[rMapping.get(x)][cMapping.get(y)] = 1;
		}
		
		int sx = rMapping.get(source[0]);
		int sy = cMapping.get(source[1]);
		int tx = rMapping.get(target[0]);
		int ty = cMapping.get(target[1]);
		Queue<int[]> queue = new ArrayDeque<int[]>();
		queue.offer(new int[]{sx, sy});
		newArr[sx][sy] = 1;
		while (!queue.isEmpty()) {
			int[] poll = queue.poll();
			int x = poll[0];
			int y = poll[1];
			for (int d = 0; d < 4; d++) {
				int nx = x + dirs[d][0];
				int ny = y + dirs[d][1];
				if (nx >= 0 && ny >= 0 && nx <= rId && ny <= cId && newArr[nx][ny] != 1) {
					if (nx == tx && ny == ty) {
						return true;
					}
					queue.offer(new int[]{nx, ny});
					newArr[nx][ny] = 1;
				}
			}
		}
		return false;
//		List<int[]> list = new ArrayList<>()
//		};
//		for (int i = 0; i < blocked.length; i++) {
//			int[] ints = blocked[i];
//			if ((ints[0] >= source[0] && ints[0] <= target[0]) || (ints[1] >= source[1] && ints[1] <= target[1])) {
//				list.add(ints);
//			}
//		}
//		if (list.size() == 0) {
//			return true;
//		}
//		return check(list, source, target);
	}
	
	
	public boolean check(List<int[]> list, int[] source, int[] target) {
		if (list.size() == 0) {
			return true;
		}
		//先左边
		int x = source[0] + 1;
		int y = source[1] + 1;
		boolean flag = false;
		while (x <= target[0] && !flag) {
			boolean passFlag = true;
			for (int i = 0; i < list.size() && passFlag; i++) {
				int[] ints = list.get(i);
				int bX = ints[0];
				int by = ints[1];
				if (x == bX || by == source[1]) {
					passFlag = false;
				}
			}
			x++;
			if (passFlag) {
				int[] ints = new int[2];
				ints[0] = x;
				ints[1] = source[1];
				if (!check(list, ints, target)) {
				
				}
			} else {
				break;
			}
		}
		if (flag) {
			return true;
		}
		//
		flag = false;
		while (y <= target[1] && !flag) {
			boolean passFlag = true;
			for (int i = 0; i < list.size() && passFlag; i++) {
				int[] ints = list.get(i);
				int bX = ints[0];
				int by = ints[1];
				if (source[0] == bX && by == y) {
					passFlag = false;
				}
			}
			y++;
			if (!flag && passFlag) {
				int[] ints = new int[2];
				ints[0] = source[0];
				ints[1] = y;
				flag = check(list, ints, target);
			} else {
				break;
			}
		}
		if (flag) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		System.out.println(new Test3().isEscapePossible(new int[][]{{0, 1}, {1, 0}}, new int[]{0, 0}, new int[]{0, 2}));
	}
}
