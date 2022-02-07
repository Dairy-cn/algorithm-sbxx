package com.dair.sbxx.year2021.day17;

import java.util.concurrent.CountDownLatch;

/**
 * @author Dair
 * @since
 */
public class ThreadMessage {
	static C c = new C();
	//flag用来标志子线程执行结束
	static boolean flag = false;
	static Object objLock = new Object();
	
	public static void main(String[] arg) throws InterruptedException {
		CountDownLatch countDownLatch = new CountDownLatch(10);
		for (int i = 0; i <10 ; i++) {
			showInfo(i);
			countDownLatch.countDown();
		}
		countDownLatch.await();
		
	}
	
	
	public static void showInfo(int index) {
		System.out.println(Thread.currentThread().getName() + "执行:" + index);
		
	}
	
	
	private void pass(String string) {
		string += "11";
		System.out.println(string);
	}
}


class C {
	private int value = 0;
	
	public int getvalue() {
		return value;
	}
	
	public void setvalue(int v) {
		this.value = v;
	}
}


