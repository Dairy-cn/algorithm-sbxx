package com.dair.sbxx.year2021.day39;

import java.util.concurrent.atomic.LongAdder;

/*************************************************************
 * Description: 
 * Author: Dair
 * Date: year2021/10/11
 ************************************************************/
public class Test4 {
	
	
	public static void main(String[] args) {
		ThreadLocal threadLocal=new ThreadLocal();
		threadLocal.set(1);
		System.out.println(threadLocal.get());
		LongAdder longAdder = new LongAdder();
	}
}
