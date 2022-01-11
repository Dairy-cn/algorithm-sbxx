package com.dair.sbxx.day75;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dair
 * @since
 */
public class Test2 {
	
	
	public char slowestKey(int[] releaseTimes, String keysPressed) {
		int max = Integer.MIN_VALUE;
		char res = keysPressed.charAt(0);
		//releaseTimes = [9,29,49,50], keysPressed = "cbcd"
		for (int i = 0; i < keysPressed.length(); i++) {
			char c = keysPressed.charAt(i);
			int time = releaseTimes[i];
			if (i >= 1) {
				time = time - releaseTimes[i - 1];
			}
			if (time > max) {
				max=time;
				res = c;
			} else if (time == max) {
				if (c > res) {
					res = c;
				}
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		System.out.println(new Test2().slowestKey(new int[]{9,29,49,50},"cbcd"));
	}
	
	
	public List<Integer> grayCode(int n) {
		List<Integer> ret = new ArrayList<Integer>();
		ret.add(0);
		for (int i = 1; i <= n; i++) {
			int m = ret.size();
			for (int j = m - 1; j >= 0; j--) {
				ret.add(ret.get(j) | (1 << (i - 1)));
			}
		}
		return ret;
	}
	
}
