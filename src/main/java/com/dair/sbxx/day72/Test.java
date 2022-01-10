package com.dair.sbxx.day72;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Dair
 * @since
 */
public class Test {
	
	
	public boolean checkPerfectNumber(int num) {
		int ans = 1;
		for (int i = 2; i <= num / i; i++) {
			if (num % i == 0){
				ans += i + num / i;
			}
		}
		
		return num!=1 && ans == num;
	}
	
	public static void main(String[] args) {
		System.out.println(new Test().checkPerfectNumber(28));
	}
}
