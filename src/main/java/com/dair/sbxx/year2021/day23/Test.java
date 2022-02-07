package com.dair.sbxx.year2021.day23;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Dair
 * @since
 */
public class Test implements Runnable {
	ReentrantLock lock=new ReentrantLock();
	
	public void lockTest() {
		lock.lock();
		System.out.println(Thread.currentThread().getName());
	}
	
	@Override
	public void run() {
		lockTest();
	}
	
	public static void main(String[] args) {
		Test test = new Test();
		for (int i = 0; i < 100; i++) {
			Thread thread1 = new Thread(test);
			Thread thread2 = new Thread(test);
			thread1.start();
			thread2.start();
		}
	}
	
}
