package com.dair.sbxx.day32;

/**
 * @author Dair
 * @since
 */
public class Test {
	
	
	public String toHex(int num) {
		if (num == 0) {
			return "0";
		}
		StringBuilder sb = new StringBuilder("");
		for (int i = 7; i >= 0; i--) {
			int a = num >> (i * 4) & 0xf;
			if (a > 0 || sb.length() > 0) {
				//双目运算符两边类型不一样时，会先转换类型一样后再计算，取范围大的运算
				// sb.append(a > 9 ? (char) (a - 10 + 'a') : a); append添加的是int类型（char->int）
				sb.append(a > 9 ? (char) (a - 10 + 'a') : (char) (a + '0'));
			}
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(new Test().toHex(111111));
		System.out.println(0xf == 0b1111);
	}
	
	
}
