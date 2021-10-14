package com.dair.sbxx.day39;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.LongAdder;

/*************************************************************
 * Description: 
 * Author: Dair
 * Date: 2021/10/11
 ************************************************************/
public class Test4 {
	
	
	public static void main(String[] args) {
		ThreadLocal threadLocal=new ThreadLocal();
		threadLocal.set(1);
		System.out.println(threadLocal.get());
		LongAdder longAdder = new LongAdder();
	}
}
