package com.dair.sbxx.year2022.day10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Dair
 * @since
 */
public class Sulotion {
	/**
	 * 给你一个整数 n ，统计并返回各位数字都不同的数字 x 的个数，其中 0 <= x < 10n 。
	 *
	 * @return
	 */
	public int countNumbersWithUniqueDigits(int n) {
		int index = 0;
		int count = 0;
		
		while (index < Math.pow(10, n)) {
			if (index >= 10) {
				String[] arr = String.valueOf(index).split("");
				List<String> list = Arrays.asList(arr);
				boolean flag = true;
				for (int i = 0; i < list.size(); i++) {
					String s = list.get(i);
					List<String> stringList = new ArrayList<>(list);
					stringList.remove(i);
					if (stringList.contains(s)) {
						flag = false;
						break;
					}
				}
				if (flag) {
					++count;
				}
			} else {
				++count;
			}
			++index;
		}
		return count;
	}
	
	public int countNumbersWithUniqueDigits2(int n) {
		if (n == 0) {
			return 1;
		}
		int ans = 10;
		for (int i = 2, last = 9; i <= n; i++) {
			int cur = last * (10 - i + 1);
			ans += cur;
			last = cur;
			
		}
		return ans;
	}
	
	public static void main(String[] args) {
		System.out.println(new Sulotion().countNumbersWithUniqueDigits2(3));
	}
}
