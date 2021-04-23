package com.dair.sbxx.day1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*************************************************************
 * Description: 
 * Author: Dairy
 * CreateTime: 2021/4/23
 * Copyright © 成都通吃岛信息技术有限公司 All right reserved
 ************************************************************/
class SumBinaryTest {
	
	@Test
	void addBinary() {
		SumBinary sumBinary=new SumBinary();
		System.out.println(sumBinary.addBinary("1010","1011"));
	}
}