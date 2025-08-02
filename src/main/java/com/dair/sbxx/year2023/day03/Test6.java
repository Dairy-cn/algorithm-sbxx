package com.dair.sbxx.year2023.day03;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * @author Dair
 * @since
 */
public class Test6 {
	private double radius;
	private double x_center;
	private double y_center;
	private Random random;
	
	public Test6(double radius, double x_center, double y_center) {
		this.radius = radius;
		this.x_center = x_center;
		this.random = new Random();
	}
	
	public double[] randPoint() {
		while (true) {
			double x = random.nextDouble() * (2 * radius) - radius;
			double y = random.nextDouble() * (2 * radius) - radius;
			if (x * x + y * y <= radius * radius) {
				return new double[]{x, y};
			}
		}
	}
	
	public static void main(String[] args) {
		String ss="";
		String[] split = ss.split(",");
		Set<String> set=new HashSet<>();
		for (int i = 0; i < split.length; i++) {
			set.add(split[i]);
		}
		System.out.println(set.size());
	}
}
