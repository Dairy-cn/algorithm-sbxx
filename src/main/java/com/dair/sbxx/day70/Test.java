package com.dair.sbxx.day70;

import java.util.PriorityQueue;
import java.util.Queue;

/*************************************************************
 * Description: 
 * Author: Dair
 * Date: 2021/12/24
 ************************************************************/
public class Test {
	
	public int eatenApples(int[] apples, int[] days) {
		int res = 0;
		Queue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
		//天数
		int d = 0;
		while (d < apples.length || !queue.isEmpty()) {
			if (d < apples.length && apples[d] > 0) {
				queue.add(new int[]{days[d] + d, apples[d]});
			}
			while (!queue.isEmpty() && (queue.peek()[0] <= d || queue.peek()[1] == 0)) {
				queue.poll();
			}
			if(!queue.isEmpty()){
				res++;
				--queue.peek()[1];
			}
			d++;
			
		}
		return res;
	}
	
	public static void main(String[] args) {
		System.out.println(new Test().eatenApples(new int[]{1,2,3,5,2},new int[]{3,2,1,4,2}));
	}
	
}
