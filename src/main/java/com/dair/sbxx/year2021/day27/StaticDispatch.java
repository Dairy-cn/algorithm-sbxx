package com.dair.sbxx.year2021.day27;

/**
 * @author Dair
 * @since
 */
public class StaticDispatch {
	
	static abstract  class Human{
	
	}
	
	static class Man extends Human{
		
	}
	static class Woman extends Human{
	
	}
	
	public void sayHello(Human human){
		System.out.println("hello human");
	}
//	public void sayHello(Man man){
//		System.out.println("hello man");
//	}
	public void sayHello(Woman woman){
		System.out.println("hello woman");
	}
	
	public static void main(String[] args) {
		//方法重装，静态分派
        //Human 是静态类型,而Man和Woman是实际类型,
		// 静态类型在编译期可知，而实际类型只有在运行时才能确认下来
		// 编译器在执行时，并不知道实际类型，所以
		
		
		Man man=new Man();
		Human woman=new Woman();
		StaticDispatch staticDispatch = new StaticDispatch();
		staticDispatch.sayHello(man);
		staticDispatch.sayHello(woman);
		staticDispatch.sayHello((Man) man);
	}
}
