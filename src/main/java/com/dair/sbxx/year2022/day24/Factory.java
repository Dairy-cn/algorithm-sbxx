package com.dair.sbxx.year2022.day24;

/**
 * @author Dair
 * @since
 */
public class Factory {
	
	public Phone getPhone(String type) {
		if ("apple".equals(type)) {
			return new Apple();
		} else if ("redim".equals(type)) {
			return new Redim();
		}
		return null;
	}
	
}
