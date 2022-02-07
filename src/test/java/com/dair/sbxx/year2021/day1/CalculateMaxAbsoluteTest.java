package com.dair.sbxx.year2021.day1;


import org.junit.jupiter.api.Test;

/*************************************************************
 * Description: 
 * Author: Dairy
 * CreateTime: year2021/4/23
 ************************************************************/
class CalculateMaxAbsoluteTest {
	
	@Test
	void solution() {
		CalculateMaxAbsolute calculateMaxAbsolute = new CalculateMaxAbsolute();
		int arr[] = new int[]{1, 4, 5, 6, 7, 2};
		System.out.println(calculateMaxAbsolute.solution(arr));
	}
}