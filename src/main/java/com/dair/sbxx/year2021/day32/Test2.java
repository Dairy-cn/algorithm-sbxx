package com.dair.sbxx.year2021.day32;


/**
 * @author Dair
 * @since
 */
public class Test2 {
	
	public String toHex(int num) {
		if (num == 0) {
			return "0";
		}
		long temp = num;
		StringBuilder sb = new StringBuilder("");
		if (num < 0) {
			//小技巧，int类型在-2^31~2^31-1中，小于零时，转换为对应的整数，即2^31+2^31=>2^32，使得-2^31对应正数的2^31
			temp = (long) ( num + Math.pow(2, 32));
		}
		while (temp > 0) {
			long a = temp % 16;
			temp = temp / 16;
			sb.append(a > 9 ? (char) ('a' + a - 10) : (char) (a + '0'));
		}
		return sb.reverse().toString();
		
	}
	
	
	public static void main(String[] args) {
		System.out.println(new Test2().toHex(26));
		System.out.println(new Test2().toHex(-1));
		//-1 数在计算机中是以补码形式存在的，正数中，原码、反码和补码都是一样的
		//在负数中，原码取反后+1得到补码
		//补码-1取反得到原码
		
		
	}
}
