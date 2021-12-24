package com.dair.sbxx.day67;

import java.util.LinkedHashMap;

/**
 * @author Dair
 * @since
 */
public class Test {
	
	/**
	 * 未知 整数数组 arr 由 n 个非负整数组成。
	 * <p>
	 * 经编码后变为长度为 n - 1 的另一个整数数组 encoded ，其中 encoded[i] = arr[i] XOR arr[i + 1] 。例如，arr = [1,0,2,1] 经编码后得到 encoded = [1,2,3] 。
	 * <p>
	 * 给你编码后的数组 encoded 和原数组 arr 的第一个元素 first（arr[0]）。
	 * <p>
	 * 请解码返回原数组 arr 。可以证明答案存在并且是唯一的。
	 * <p>
	 *  
	 * <p>
	 * 示例 1：
	 * <p>
	 * 输入：encoded = [1,2,3], first = 1
	 * 输出：[1,0,2,1]
	 * 解释：若 arr = [1,0,2,1] ，那么 first = 1 且 encoded = [1 XOR 0, 0 XOR 2, 2 XOR 1] = [1,2,3]
	 * 示例 2：
	 * <p>
	 * 输入：encoded = [6,2,7,3], first = 4
	 * 输出：[4,2,0,7,4]
	 *  
	 * <p>
	 * 来源：力扣（LeetCode）
	 * 链接：https://leetcode-cn.com/problems/decode-xored-array
	 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */
	
	public int[] decode(int[] encoded, int first) {
		int[] arr = new int[encoded.length + 1];
		arr[0] = first;
		for (int i = 0; i < encoded.length; i++) {
			arr[i + 1] = encoded[i] ^ arr[i];
		}
		return arr;
	}
	
	/**
	 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
	 * <p>
	 * push(x) —— 将元素 x 推入栈中。
	 * pop() —— 删除栈顶的元素。
	 * top() —— 获取栈顶元素。
	 * getMin() —— 检索栈中的最小元素。
	 *  
	 * <p>
	 * 示例:
	 * <p>
	 * 输入：
	 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
	 * [[],[-2],[0],[-3],[],[],[],[]]
	 * <p>
	 * 输出：
	 * [null,null,null,null,-3,null,0,-2]
	 * <p>
	 * 解释：
	 * MinStack minStack = new MinStack();
	 * minStack.push(-2);
	 * minStack.push(0);
	 * minStack.push(-3);
	 * minStack.getMin();   --> 返回 -3.
	 * minStack.pop();
	 * minStack.top();      --> 返回 0.
	 * minStack.getMin();   --> 返回 -2.
	 * <p>
	 * 来源：力扣（LeetCode）
	 * 链接：https://leetcode-cn.com/problems/min-stack
	 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 *
	 * @param args
	 */
	static class MinStack {
		
		int[] arr = null;
		int size = 10;
		int index = 0;
		
		public MinStack() {
			arr = new int[size];
		}
		
		public void push(int val) {
			if (arr.length == index) {
				//扩容
				size += 10;
				int[] temp = new int[size];
				System.arraycopy(arr, 0, temp, 0, arr.length);
				arr = temp;
			}
			arr[index++] = val;
		}
		
		public void pop() {
			index--;
		}
		
		public int top() {
			return  arr[--index];
		}
		
		public int getMin() {
			int res=Integer.MAX_VALUE;
			for (int i = 0; i < index; i++) {
				if(res>arr[i]){
					res=arr[i];
				}
			}
			return res;
			
		}
	}
	
	public static void main(String[] args) {
//		System.out.println(new Test().decode(new int[]{6, 2, 7, 3}, 4));
		MinStack obj = new MinStack();
		obj.push(-2);
		obj.push(0);
		obj.push(-3);
		obj.push(1);
		obj.push(2);
		obj.push(3);
		obj.push(4);
		obj.push(4);
		obj.push(5);
		obj.push(6);
		obj.push(8);
		obj.push(9);
		System.out.println(obj.getMin());
		obj.pop();
		System.out.println(obj.top());
		System.out.println(obj.getMin());
		
	}
}
