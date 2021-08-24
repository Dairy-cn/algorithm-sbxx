package com.dair.sbxx.day18;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author Dair
 * @since
 */
public class LongAdderTest {
	
	
	
	
	private static int count = 1000;
	
	public static void main(String[] args) throws InterruptedException {
		ConcurrentHashMap  concurrentHashMap=new ConcurrentHashMap();
		
		String columnTitle = "ZY";
		
		int res = 0;
		for (int i = 0; i < columnTitle.length(); i++) {
			  res+= (int)(Math.pow(26, columnTitle.length() - 1 - i)*(columnTitle.charAt(i)-64));
		}
		System.out.println("sss" + res);
		;
//		for (int i = 0; i <10 ; i++) {
//			atomicLongMethod();
//		}
//
	}
	
	private static void atomicLongMethod() throws InterruptedException {
		int index = 0;
		long currentTime = System.currentTimeMillis();
		System.out.println("当前时间是：" + currentTime);
		AtomicLong atomicLong = new AtomicLong(index);
		CountDownLatch countDownLatch = new CountDownLatch(count);
		for (int i = 1; i <= count; i++) {
			Thread thread = new Thread(new Runnable() {
				@Override
				public void run() {
					atomicLong.incrementAndGet();
				}
			});
			thread.start();
			while (thread.isAlive()) {
			
			}
			countDownLatch.countDown();
		}
		try {
			countDownLatch.await();
			long endTime = System.currentTimeMillis();
			System.out.println("执行后时间是：" + endTime);
			System.out.println("执行结果为" + atomicLong.get());
			System.out.println("执行时间是：" + (endTime - currentTime));
		} catch (Exception e) {
		
		}
	}
	
	
}
