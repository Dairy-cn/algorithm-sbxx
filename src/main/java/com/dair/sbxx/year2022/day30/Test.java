package com.dair.sbxx.year2022.day30;

/**
 * @author Dair
 * @since
 */
public class Test {
	
	public static void main(String[] args) {
		String str = "\uD83D\uDE02";
		System.out.println(str.length());
		System.out.println(str.charAt(0));
		System.out.println(str.offsetByCodePoints(0,1));
		char ss='s';
		System.out.println(Character.isLowSurrogate(ss));


	}
}
