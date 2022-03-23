package com.dair.sbxx.year2022.day03;

import java.util.*;

/**
 * @author Dair
 * @since
 */
public class Test2 {
	public static Stack<String> stack = new Stack<String>();
	
	public static List<Stack<String>> jobCodeList = new ArrayList<>();
	
	public static void main(String[] args) {
		List<JobInfo> jobInfos = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			JobInfo jobInfo = new JobInfo();
			jobInfo.setBuId(i / 10 + "");
			jobInfo.setJobCode(i + "");
			jobInfo.setChangeCode(i % 5 + "");
			jobInfo.setHandleUserCode(i % 2 + "");
			jobInfos.add(jobInfo);
		}
		String[] shu = new String[jobInfos.size()];
		HashMap<String, JobInfo> map = new HashMap<>();
		for (int i = 0; i < jobInfos.size(); i++) {
			shu[i] = jobInfos.get(i).getJobCode();
			map.put(jobInfos.get(i).getJobCode(), jobInfos.get(i));
		}
		List<JobNumInfo> jobNumInfoList = new ArrayList<>();
		String buArr[] = new String[jobInfos.size()];
		int index = 0;
		for (int i = 0; i < 10; i++) {
			JobNumInfo jobNumInfo = new JobNumInfo();
			jobNumInfo.setBuId(i + "");
			jobNumInfo.setJobNum(10);
			jobNumInfoList.add(jobNumInfo);
			if (jobNumInfo.getJobNum() > 0) {
				for (Integer integer = 0; integer < jobNumInfo.getJobNum(); integer++) {
					buArr[index++] = jobNumInfo.getBuId() == null ? "" : jobNumInfo.getBuId();
				}
			}
		}
		f(shu, jobInfos.size(), 0);
//		permutation(shu);
		int i = 0;
		List<List<JobInfo>> allList = new ArrayList<>();
		for (Stack<String> strings : jobCodeList) {
			List<JobInfo> list = new ArrayList<>();
			while (!strings.empty()) {
				String code = strings.pop();
				JobInfo jobInfo = map.get(code);
				if (jobInfo != null) {
					jobInfo.setQualityBuId(buArr[i++]);
				}
				list.add(jobInfo);
			}
			allList.add(list);
		}
		System.out.println("s");
		
	}
	
	/**
	 * @param shu  待选择的数组
	 * @param targ 要选择多少个次
	 * @param cur  当前选择的是第几次
	 */
	private static void f(String[] shu, int targ, int cur) {
		if (cur == targ) {
			jobCodeList.add(stack);
			return;
		}
		for (int i = 0; i < shu.length; i++) {
			if (!stack.contains(shu[i])) {
				stack.add(shu[i]);
				f(shu, targ, cur + 1);
				stack.pop();
			}
		}
	}
	
	static List<String[]> list = new ArrayList<>();
	
	public static void permutation(String[] s) {
		permutate(s, 0);
//		String[] res = new String[list.size()];
//		for (int i = 0; i < res.length; i++) {
//			String[] strings = list.get(i);
//			res[i]=
//		}
		for (String[] strings : list) {
//			jobCodeList.add(strings);
		}
	}
	
	public static void permutate(String[] arr, int first) {
		if (first == arr.length - 1) {
			list.add(arr);
			return;
		}
		for (int i = first; i < arr.length; i++) {
			swap(arr, first, i);
			permutate(arr, first + 1);
			swap(arr, first, i);
		}
	}
	
	public static void swap(String[] arr, int i, int j) {
		String temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
}
