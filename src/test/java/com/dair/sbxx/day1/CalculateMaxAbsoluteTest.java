package com.dair.sbxx.day1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*************************************************************
 * Description: 
 * Author: Dairy
 * CreateTime: 2021/4/23
 ************************************************************/
class CalculateMaxAbsoluteTest {
	
	@Test
	void solution() {
		CalculateMaxAbsolute calculateMaxAbsolute=new CalculateMaxAbsolute();
		int arr[] =new int[]{1,4,5,6,7,2};
		System.out.println(calculateMaxAbsolute.solution(arr));
	}
}