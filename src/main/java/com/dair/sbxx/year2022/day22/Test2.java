package com.dair.sbxx.year2022.day22;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Dair
 * @since
 */
public class Test2 {
	
	
	public boolean uniqueOccurrences(int[] arr) {
		
		int[] ints = new int[2001];
		for (int i = 0; i < arr.length; i++) {
			ints[arr[i] + 1000] += 1;
		}
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < ints.length; i++) {
			
			if (set.contains(ints[i])) {
				return false;
			}
			set.add(ints[i]);
		}
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println(new Test2().uniqueOccurrences(new int[]{1,2,2,1,1,3}));
	}
}
