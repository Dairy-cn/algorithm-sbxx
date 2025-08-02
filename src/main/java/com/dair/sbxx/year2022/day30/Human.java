package com.dair.sbxx.year2022.day30;

import java.util.Timer;

/**
 * @author Dair
 * @since
 */
public class Human {
	
	
	public void method() throws InterruptedException {
		
		new Person() {
			
			@Override
			public void run() throws InterruptedException {
				Thread.sleep(10);
				System.out.println(new Human().end());
			}
		}.run();
	}
	
	private String end() {
		return "end";
	}
	
	public static void main(String[] args) throws InterruptedException {
		Human human = new Human();
		human.method();
	}
}
