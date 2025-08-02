package com.dair.sbxx.year2022.day33;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @author Dair
 * @since
 */
public class OrderDelayed implements Delayed {
	private String orderId;
	
	private Long timeOut;
	
	private Integer msg;
	
	public OrderDelayed(String orderId, Long timeOut,Integer msg) {
		this.orderId = orderId;
		this.timeOut = timeOut + System.nanoTime();
		this.msg = msg;
	}
	
	
	public int compareTo(Delayed other) {
		if (other == this) {
			return 0;
		}
		OrderDelayed t = (OrderDelayed) other;
		long d = (getDelay(TimeUnit.NANOSECONDS) - t.getDelay(TimeUnit.NANOSECONDS));
		return (d == 0) ? 0 : ((d < 0) ? -1 : 1);
	}
	
	// 返回距离你自定义的超时时间还有多少
	public long getDelay(TimeUnit unit) {
		return unit.convert(timeOut - System.nanoTime(), TimeUnit.NANOSECONDS);
	}
	
	
	void print() {
		System.out.println(orderId + "编号的订单删除啦。。。。延时了：" + msg + "S");
	}
}
