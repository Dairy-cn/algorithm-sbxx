package com.dair.sbxx.year2021.day67;

import java.util.Stack;

/**
 * @author Dair
 * @since
 */
public class MinStack {
	
	private Stack<Integer> data;
	
	
	private static Integer help = null;
	
	public MinStack() {
		data = new Stack<>();
	}
	
	public void push(int val) {
		data.add(val);
		if (help == null || val < help) {
			help = val;
		}
	}
	
	public void pop() {
		Integer peek = data.peek();
		data.pop();
		if (peek.equals(help)) {
			if (data.isEmpty()) {
				help = null;
			} else {
				int min = Integer.MAX_VALUE;
				for (int i = 0; i < data.size(); i++) {
					if (min > data.get(i)) {
						min = data.get(i);
					}
				}
				help=min;
			}
		}
	}
	
	public int top() {
		return data.peek();
	}
	
	public int getMin() {
		return help;
	}
	
	public static void main(String[] args) {
		MinStack obj = new MinStack();
		obj.push(512);
		obj.push(-1024);
		obj.push(-1024);
		obj.push(512);
        obj.pop();
        obj.pop();
        obj.pop();
		System.out.println(obj.top());
		System.out.println(obj.getMin());
	}
}
