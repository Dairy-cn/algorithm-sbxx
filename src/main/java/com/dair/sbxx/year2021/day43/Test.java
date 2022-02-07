package com.dair.sbxx.year2021.day43;

/**
 * @author Dair
 * @since
 */
public class Test {
	
	/**
	 * 数学归纳法，统计出前段和后段的情况分类
	 * @param nums
	 * @return
	 */
	public boolean sumGames(String nums) {
		
		int sumL = 0;
		int sumR = 0;
		int qmL = 0;
		int qmR = 0;
		int n = nums.length();
		
		for (int i = 0; i < n; i++) {
			if (nums.charAt(i) == '?') {
				if (i < n / 2) {
					++qmL;
				} else {
					++qmR;
				}
			} else {
				if (i < n / 2) {
					sumL += nums.charAt(i) - '0';
				} else {
					sumR += nums.charAt(i) - '0';
				}
			}
		}
		
		//如果前段和后段和相等，且前段和后段问号数相等
		if (sumL == sumR && qmL == qmR) {
			return false;
		}
		if (sumL == sumR && qmL != qmR) {
			return true;
		}
		if (((qmL + qmR) & 1) != 0) {
			return true;
		}
		if (sumL > sumR && qmL >= qmR) {
			return true;
		}
		if (sumL < sumR && qmL <= qmR) {
			return true;
		}
		if (Math.abs(sumL - sumR) != Math.abs(qmL - qmR) / 2 * 9) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		System.out.println(new Test().sumGames("25??"));
	}
}

