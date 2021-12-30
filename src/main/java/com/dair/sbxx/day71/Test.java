package com.dair.sbxx.day71;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Dair
 * @since
 */
public class Test {
	
	public boolean isNStraightHand(int[] hand, int groupSize) {
		int n = hand.length;
		if (n % groupSize != 0) {
			return false;
		}
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < n; i++) {
			map.put(hand[i], map.getOrDefault(hand[i], 0) + 1);
		}
		Arrays.sort(hand);
		for (int i = 0; i < n; i++) {
			Integer integerA = map.get(hand[i]);
			if (integerA == 0) {
				continue;
			}
			map.put(hand[i], --integerA);
			for (int j = 1; j < groupSize; j++) {
				Integer integerJ = map.get(hand[i] + j);
				if (integerJ == null || integerJ == 0) {
					return false;
				}
				map.put(hand[i] + j, --integerJ);
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println(new Test().isNStraightHand(new int[]{1}, 1));
	}
}
