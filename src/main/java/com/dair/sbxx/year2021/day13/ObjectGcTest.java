package com.dair.sbxx.year2021.day13;

/*************************************************************
 * Description: 
 * Author: Dair
 * Date: year2021/6/19
 ************************************************************/
public class ObjectGcTest {
	
	public static void main(String[] args) {
		int a;
		a=10;
		System.out.println(a+1);
	}
	
	
	public static void method(){
		byte[] arr=new byte[4*1024*1024];
	}
	
}
