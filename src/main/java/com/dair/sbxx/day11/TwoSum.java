package com.dair.sbxx.day11;

import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Dair
 * @since
 */
public class TwoSum {
	
	
	public static int[] solution(int[] arr, Integer target) {
		int[] res = new int[]{0, 1};
		if (arr.length == 2) {
			return res;
		}
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			map.put(arr[i], i);
		}
		for (int i = 0; i < arr.length; i++) {
			if (map.get(target - arr[i]) != null) {
				res[0] = i;
				res[1] = map.get(target - arr[i]);
				if (res[0] != res[1]) {
					break;
				}
			}
			
		}
		return res;
	}
	
	
	public static int[] solution1(int[] arr, Integer target) {
//		int k = 0;
//		int m = arr.length - 1;
//		int[] res = new int[]{0, 1};
//		while (m > k) {
//			if (arr[k] + arr[m] == target) {
//				res[0] = k;
//				res[1] = m;
//				break;
//			} else if (arr[k] + arr[m] > target) {
//				m--;
//			} else {
//				m++;
//			}
//		}
		int k = 0;
		int m = arr.length - 1;
		int[] res = new int[]{-1, -1};
		int[] team = Arrays.copyOf(arr, arr.length);
		Arrays.sort(team);
		while (true) {
			if (arr[k] + arr[m] == target) {
				break;
			} else if (arr[k] + arr[m] > target) {
				m--;
				continue;
			} else {
				k++;
				continue;
			}
		}
		for (int i = 0; i < arr.length; i++) {
			if (team[k] == arr[i] && res[0] == -1) {
				res[0] = i;
				continue;
			}
			if (team[m] == arr[i] && res[1] == -1) {
				res[1] = i;
			}
		}
		return res;
	}
	
	
	public static void main(String[] args) {
		int[] arr = solution1(new int[]{2, 3, 4}, 9);
		for (int i : arr) {
			System.out.println(i);
		}
		ReentrantLock lock=new ReentrantLock();
		boolean b = lock.tryLock();
		Semaphore semaphore=new Semaphore(11);
		semaphore.tryAcquire();
		CountDownLatch countDownLatch=new CountDownLatch(11);
		long count = countDownLatch.getCount();
		
		
		AtomicInteger atomicInteger=new AtomicInteger(0);
		atomicInteger.incrementAndGet();
		
	}
}
