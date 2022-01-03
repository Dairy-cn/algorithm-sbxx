package com.dair.sbxx.day72;

/*************************************************************
 * Description: 
 * Author: Dair
 * Date: 2022/1/3
 ************************************************************/
public class Test {
	
	
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
	
	public static void main(String[] args) {
		System.out.println(8263 % 7);
		System.out.println(new Test().dayOfTheWeek(15, 8, 1993));
	}
}
