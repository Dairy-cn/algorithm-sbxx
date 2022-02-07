package com.dair.sbxx.year2021.day72;

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
	public String dayOfTheWeek(int day, int month, int year) {
		String[] res = new String[]{"Thursday", "Friday", "Saturday", "Sunday", "Monday", "Tuesday", "Wednesday"};
		int num = 0;
		for (int i = 1971; i < year; i++) {
			num += isLeaf(i) ? 366 : 365;
		}
		int[] arr = new int[]{0,31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30};
		for (int i = 1; i < month; i++) {
			if (i == 2) {
				num += isLeaf(year) ? 29 : 28;
			} else {
				num += arr[i];
			}
		}
		num += day;
		return res[num % 7];
		
	}
	
	public boolean isLeaf(int year) {
		if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
			return true;
		}
		return false;
	}
	

}
