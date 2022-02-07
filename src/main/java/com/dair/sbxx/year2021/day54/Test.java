package com.dair.sbxx.year2021.day54;

/**
 * @author Dair
 * @since
 */
public class Test {
	
	
	public int integerReplacement(int n) {
		int res = 0;
		if (n == 0) {
			return res;
		}
		long n1=n;
		while (n1 != 1) {
			++res;
			if (n1 % 2 != 0) {
				//奇数
				if(n1!=3 && ((n1>>1)&1)==1){
					n1++;
				}else {
					n1--;
				}
			}else {
				n1 = n1 >> 1;
			}
			
		}
		return res;
	}
	
	public static void main(String[] args) {
//		System.out.println(new Test().integerReplacement(7));
		System.out.println(-1-(-1/2*2));
	}
}
