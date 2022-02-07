package com.dair.sbxx.year2021.day39;

import java.util.HashMap;

/*************************************************************
 * Description: 
 * Author: Dair
 * Date: year2021/10/11
 ************************************************************/
public class Test2 {
	
	
	public int dayOfYear(String date) {
		String[] arr = date.split("-");
		HashMap<Integer, Integer> map = new HashMap();
		map.put(1, 31);
		map.put(2, isLeapYear(Integer.valueOf(arr[0])) ? 29 : 28);
		map.put(3, 31);
		map.put(5, 31);
		map.put(7, 31);
		map.put(8, 31);
		map.put(10, 31);
		map.put(12, 31);
		map.put(4, 30);
		map.put(6, 30);
		map.put(9, 30);
		map.put(11, 30);
		
		int res = Integer.valueOf(arr[2]);
		
		int month = Integer.valueOf(arr[1]);
		
		for (int i = 1; i < month; i++) {
			res+=map.get(i);
			
		}
		return res;
	}
	
	
	public boolean isLeapYear(int year) {
		return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
	}
	
	
	public static void main(String[] args) {
		System.out.println(new Test2().dayOfYear("2004-03-01"));
	}
	
}
