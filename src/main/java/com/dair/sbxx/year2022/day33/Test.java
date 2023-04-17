package com.dair.sbxx.year2022.day33;

import java.util.ArrayList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @author Dair
 * @since
 */
public class Test {
	
	public static void main(String[] args) {
		
		ArrayList<String> list = new ArrayList<>();
		list.add("00001");
		list.add("00002");
		list.add("00003");
		list.add("00004");
		list.add("00005");
		DelayQueue<OrderDelayed> queue = new DelayQueue<>();
		long l = System.currentTimeMillis();
		for (int i = 0; i < 5; i++) {
			int s = (int) (Math.random()*40+10);
			long convert = TimeUnit.NANOSECONDS.convert(s, TimeUnit.SECONDS);
			queue.put(new OrderDelayed(list.get(i), convert,s));
		}
		int index = 5;
		while (index > 0) {
			try {
				queue.take().print();
				System.out.println("时间：" + (TimeUnit.SECONDS.convert(System.currentTimeMillis() - l,TimeUnit.MILLISECONDS)) + "MillsSeconds");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			index--;
		}
	}
}
