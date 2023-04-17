package com.dair.sbxx.year2022.day33;

import io.netty.util.HashedWheelTimer;
import io.netty.util.Timeout;
import io.netty.util.TimerTask;

import java.util.concurrent.TimeUnit;

/**
 * @author Dair
 * @since
 */
public class HashedWheelTimerTest {
	
	static class MyTimerTask implements TimerTask {
		private boolean flg;
		
		public MyTimerTask(boolean flg) {
			this.flg = flg;
		}
		
		@Override
		public void run(Timeout timeout) throws Exception {
			System.out.println("删除订单了");
			this.flg = false;
		}
	}
	
	public static void main(String[] args) {
		MyTimerTask timerTask = new MyTimerTask(true);
		HashedWheelTimer timer = new HashedWheelTimer();
		timer.newTimeout(timerTask, 5, TimeUnit.SECONDS);
		int i = 1;
		while (timerTask.flg) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(i + "秒过去了");
			i++;
		}
	}
}
