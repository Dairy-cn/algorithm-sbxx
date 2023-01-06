package com.dair.sbxx.year2022.day29;

import java.math.BigDecimal;

/**
 * @author Dair
 * @since
 */
public class Test {
	public static void main(String[] args) {
		//禁止使用BigDecimal的构造new BigDecimal(double)的方式把double转化为BigDdecimal对象
		
		BigDecimal x = new BigDecimal(0.1f);
		BigDecimal y = BigDecimal.valueOf(0.1);
		BigDecimal z = new BigDecimal("0.1");
		
		System.out.println(x.compareTo(y));//1 x>y
		System.out.println(y.compareTo(z));//0 x=y
	}
}
