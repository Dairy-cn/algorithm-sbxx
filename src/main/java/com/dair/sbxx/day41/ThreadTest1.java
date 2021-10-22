package com.dair.sbxx.day41;

import java.util.concurrent.TimeUnit;

/*************************************************************
 * Description: 
 * Author: Dair
 * Date: 2021/10/21
 ************************************************************/
public class ThreadTest1 {
	
	
	public static void main(String[] args) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					TimeUnit.SECONDS.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName()+"输出");
				
			}
		}).start();
	}
}
