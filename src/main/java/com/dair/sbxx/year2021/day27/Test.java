package com.dair.sbxx.year2021.day27;

/**
 * @author Dair
 * @since
 */
public class Test {
	
	static class Father {
		public int money = 1;
		
		public Father() {
			this.money = 2;
			showMoney();
		}
		
		public void showMoney() {
			System.out.println("I am father,i have" + money);
		}
		
	}
	
	static class Son extends Father {
		public int money = 3;
		
		public Son() {
			this.money = 4;
			showMoney();
		}
		
		@Override
		public void showMoney() {
			System.out.println("I am son,i have" + money);
		}
		
	}
	
	public static void main(String[] args) {
		Father f = new Son();
		System.out.println("this gay has " + f.money);
	}
	
	
}
