package com.dair.sbxx.day19;

/**
 * @author Dair
 * @since
 */
public class LongAndDoubleTest implements Runnable {
	
	private static long field = 0L;
	
	private volatile long value;
	
	
	public long getValue() {
		return value;
	}
	
	public void setValue(long value) {
		this.value = value;
	}
	
	
	public LongAndDoubleTest(long value) {
		this.setValue(value);
	}
	
	
	@Override
	public void run() {
		
		
		for (int i = 0; i < 10000; i++) {
			LongAndDoubleTest.field = this.value;
			long field = LongAndDoubleTest.field;
			if (field != 1L && field != -1L) {
				System.out.println("出现错误结果" + field);
				System.exit(0);
			}
		}
		System.out.println("运行正确");
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		String arch = System.getProperty("sun.arch.data.model");
		System.out.println("arch"+arch+"-bit");
		LongAndDoubleTest t1=new LongAndDoubleTest(1);
		LongAndDoubleTest t2=new LongAndDoubleTest(-1);
		Thread thread1=new Thread(t1);
		Thread thread2=new Thread(t2);
		thread1.start();
		thread2.start();
		thread1.join();
		thread2.join();
	}
}
