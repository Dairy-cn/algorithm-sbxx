package com.dair.sbxx.day10;


/**
 * @author Dair
 * @since
 */
public class IsPowerOfFour {
	
	
	public static boolean solution(int n) {
		//0Xaaaaaaaa 十六进制 转为二进制位偶数位位1奇数位为0的二进制数
		//0X55555555 十六进制 转为二进制位偶数位位0奇数位为1的二进制数
		
		return n > 0 && (n & (n - 1)) == 0 && (n & 0Xaaaaaaaa) == 0;
	}
	
	public static void main(String[] args) {
		
		for (int i = 0; i < 100; i++) {
			System.out.println(i + "是不是4的幂次方：" + solution(i));
		}
		
	}
}
