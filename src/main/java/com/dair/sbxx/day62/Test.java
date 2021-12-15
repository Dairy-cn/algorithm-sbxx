package com.dair.sbxx.day62;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Dair
 * @since
 */
public class Test {
	HashMap<Integer, Set<Integer>> map = new HashMap<>();
	
	public int[] loudAndRich(int[][] richer, int[] quiet) {
		for (int[] ints : richer) {
			Set<Integer> list = map.getOrDefault(ints[1], new HashSet<>());
			list.add(ints[0]);
			map.put(ints[1], list);
		}
		int[] arr = new int[quiet.length];
		for (int i = 0; i < quiet.length; i++) {
			Set<Integer> set = map.get(i);
			Set<Integer> setList = getSetList(set);
			setList.add(i);
			int min = Integer.MAX_VALUE;
			for (Integer integer : setList) {
				int i1 = quiet[integer];
				min = Math.min(min, i1);
			}
			arr[i] = min;
		}
		return arr;
	}
	
	private Set<Integer> getSetList(Set<Integer> set) {
		Set<Integer> resSetList = new HashSet<>();
		if (set == null || set.isEmpty()) {
			return resSetList;
		}
		for (Integer integer : set) {
			Set<Integer> set1 = map.get(integer);
			if (set1 != null && !set1.isEmpty()) {
				resSetList.addAll(set1);
				Set<Integer> setList = getSetList(set1);
				if (setList != null && !setList.isEmpty()) {
					resSetList.addAll(setList);
				}
			}
		}
		return resSetList;
	}
	
	
	public static void main(String[] args) {
		int[] ints = new Test().loudAndRich(new int[][]{{1, 0}, {2, 1}, {3, 1}, {3, 7}, {4, 3}, {5, 3}, {6, 3}}, new int[]{3, 2, 5, 4, 6, 1, 7, 0});
		for (int anInt : ints) {
			System.out.println(anInt);
		}
    	}
}
