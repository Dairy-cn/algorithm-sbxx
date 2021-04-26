package com.dair.sbxx.day3;

/**
 * @author Dair
 * @since
 */
public class Sqrt {
	
	
	
	public int getSqrt(int x){
		int l = 0, r = x, ans = -1;
		while (l <= r) {
			int mid = l + (r - l) / 2;
			if ((long) mid * mid <= x) {
				ans = mid;
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}
		return ans;
	}
}
