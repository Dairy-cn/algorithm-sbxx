package com.dair.sbxx.day27;

/**
 * @author Dair
 * @since
 */
public class DynamicDispatch {
	
	static abstract class Human {
		
		protected abstract void sayHello();
	}
	
	static class Man extends Human {
		
		@Override
		protected void sayHello() {
			System.out.println("hello Man");
		}
	}
	
	static class Woman extends Human {
		
		@Override
		protected void sayHello() {
			System.out.println("hello Woman");
		}
	}
	
	public static void main(String[] args) {
		
		Human man = new Man();
		Human woman = new Woman();
		
		man.sayHello();
		woman.sayHello();
	}
}
