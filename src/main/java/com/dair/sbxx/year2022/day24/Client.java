package com.dair.sbxx.year2022.day24;

/**
 * @author Dair
 * @since
 */
public class Client {
	
	
	public static void main(String[] args) throws Exception {
		
		Factory factory = new Factory();
		Phone apple = factory.getPhone("apple");
		System.out.println(apple);
		apple.produce();
		Phone redim = factory.getPhone("redim");
		redim.produce();

		FactoryPlus factoryPlus = new FactoryPlus();
		Phone phone = factoryPlus.getPhone(Apple.class);
		System.out.println(phone);
		phone.produce();

		Phone huawei = factoryPlus.getPhone(Huawei.class);
		System.out.println(huawei);
		huawei.produce();
	}
}
