package com.dair.sbxx.year2022.day24;

/**
 * @author Dair
 * @since
 */
public class FactoryPlus {
	
	public Phone getPhone(Class clz) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		return (Phone) Class.forName(clz.getName()).newInstance();
	}
}
