package com.dair.sbxx.day34;

/*************************************************************
 * Description: 
 * Author: Dair
 * Date: 2021/10/5
 ************************************************************/
public class Test {
	
	public double myPow(double x, int n) {
		if (n == 0) {
			return 1;
		}
		long a = n;
		if (n < 0) {
			a = -n;
		}
		return n > 0 ? pow(x, a) : 1 / pow(x, a);
		
	}
	
	private double pow(double x, long n) {
		if (n == 0) {
			return 1.0;
		}
		double pow = pow(x, n / 2);
		return n % 2 == 0 ? pow * pow : pow * pow * x;
	}
	
	public static void main(String[] args) {
		System.out.println(new Test().myPow(2, 4));
	}
}
