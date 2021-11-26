package com.dair.sbxx.day57;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Dair
 * @since
 */
public class Test3 {
	
	
	public int flipgame(int[] fronts, int[] backs) {
		int a = getMinInt(fronts, backs);
		int b = getMinInt(backs, fronts);
		if (a != 0 && b != 0) {
			return Math.min(a, b);
		} else if (a != 0) {
			return a;
		} else if (b != 0) {
			return b;
		} else {
			return 0;
		}
	}
	
	private int getMinInt(int[] fronts, int[] backs) {
		Integer res = null;
		HashMap<Integer, Integer> map = new HashMap<>();
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < fronts.length; i++) {
			if (fronts[i] == backs[i]) {
				set.add(fronts[i]);
				continue;
			}
			int m = fronts[i];
			if (!set.contains(m)) {
				map.put(m, map.getOrDefault(m, 0) + 1);
			}
		}
		
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (!set.contains(entry.getKey())) {
				if (res == null) {
					res = entry.getKey();
				} else {
					res = Math.min(entry.getKey(), res);
				}
			}
		}
		return res == null ? 0 : res;
	}
	
	public static void main(String[] args) {
		System.out.println(new Test3().flipgame(new int[]{1, 1}, new int[]{2, 2}));
	}
	
	public int flipgame2(int[] fronts, int[] backs) {
		Set<Integer> set = new HashSet<>();
		
		for (int i = 0; i < fronts.length; i++) {
			if (fronts[i] == backs[i]) {
				set.add(fronts[i]);
			}
		}
		int res = 0;
		for (int i = 0; i < fronts.length; i++) {
			if (!set.contains(fronts[i])) {
				res = (res == 0) ? fronts[i] : Math.min(res, fronts[i]);
			}
		}
		
		for (int i = 0; i < backs.length; i++) {
			if (!set.contains(backs[i])) {
				res = (res == 0) ? backs[i] : Math.min(res, backs[i]);
			}
		}
		return res;
		Math.pow()
	}
}
