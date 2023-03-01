package com.dair.sbxx.year2022.day30;

/**
 * @author Dair
 * @since
 */
public class OutClass {
	
	
	private String name;
	
	private int age;
	
	
	private void getInfo(String name,int age){
		System.out.println(name+"---age:"+age);
	}
	
	
	class InnerClass{
		
		
		
		public void innerMethod(){
			getInfo("dair",1);
		}
	}
	
	public static void main(String[] args) {
		InnerClass innerClass = new OutClass().new InnerClass();
		innerClass.innerMethod();
	}
}
