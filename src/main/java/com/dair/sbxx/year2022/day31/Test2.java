package com.dair.sbxx.year2022.day31;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * @author Dair
 * @since
 */
public class Test2 {
	
	
	/**
	 * 将一定量进行用户平均分配
	 */
	public static void main(String[] args) {
		List<Integer> userList = new ArrayList<>();
		userList.add(1);
		userList.add(2);
		userList.add(3);
		int count = 10;
		Map<Integer, Integer> userAverage = calculateAverage(userList, count);
		System.out.println("平均分配结果：" + userAverage);
	}
	
	/**
	 * 计算平均分配
	 *
	 * @param userList 用户
	 * @param count    数量
	 * @return 分配结果
	 */
	private static Map<Integer, Integer> calculateAverage(List<Integer> userList, int count) {
		int assignNum = count / userList.size();
		// 不够均分，每人最多一个，分完为止
		if (assignNum == 0) {
			Map<Integer, Integer> result = new ConcurrentHashMap<>();
			for (Integer userId : userList) {
				result.put(userId, 1);
				if (--count <= 0) {
					return result;
				}
			}
		}
		// 均分超过20个，以20个为准
		if (assignNum >= 20) {
			return userList.stream().collect(Collectors.toMap(Integer::intValue, v -> 20));
		}
		// 均分不超过20个，余下的将每人最多进行20补全，直至将剩余补完为止
		int diff = 20 - assignNum;
		int remainder = count % userList.size();
		Map<Integer, Integer> userAssignNumMap = new ConcurrentHashMap<>();
		for (Integer userId : userList) {
			userAssignNumMap.put(userId, assignNum + Math.min(remainder, diff));
			remainder = Math.max(remainder - diff, 0);
		}
		return userAssignNumMap;
	}
}
