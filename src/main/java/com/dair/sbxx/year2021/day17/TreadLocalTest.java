package com.dair.sbxx.year2021.day17;

import java.util.concurrent.*;

/**
 * @author Dair
 * @since
 */
public class TreadLocalTest {

//	private static ThreadLocal<Integer> threadLocal =ThreadLocal.withInitial(()->0);
	
	private Integer threadLocal = 0;
	
	private int getValue() {
		return threadLocal;
	}
	
	private void setValue(Integer value) {
		threadLocal = getValue() + value;
	}
	
	// 排队总人数（请求总数）
	public static int clientTotal = 10;
	
	// 可同时受理业务的窗口数量（同时并发执行的线程数）
	public static int threadTotal = 2;
	
	public static void main(String[] args) throws InterruptedException {
	
;
		
		ExecutorService service = Executors.newCachedThreadPool();
		Semaphore semaphore = new Semaphore(threadTotal);
		CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
		for (int i = 0; i < clientTotal; i++) {
			int finalI = i;
			service.execute(() -> {
				try {
					semaphore.acquire(1);
					showInfo(finalI);
					semaphore.release();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				countDownLatch.countDown();
			});
		}
		countDownLatch.await();
		service.shutdown();
	}
	
	
	private static void showInfo(int i) throws InterruptedException {
		System.out.println("服务号" + i + "，受理业务中。。。");
		Thread.sleep(2000);
	}
	
}
