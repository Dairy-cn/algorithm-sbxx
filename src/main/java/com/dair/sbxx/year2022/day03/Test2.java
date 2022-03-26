package com.dair.sbxx.year2022.day03;

import org.springframework.beans.BeanUtils;

import java.util.*;

/**
 * @author Dair
 * @since
 */
public class Test2 {
	public static Stack<JobInfo> stack = new Stack<JobInfo>();
	
	public static List<Stack<String>> jobCodeList = new ArrayList<>();
	
	public static void main(String[] args) {
		List<JobInfo> jobInfos = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			JobInfo jobInfo = new JobInfo();
			jobInfo.setBuId(new Random().nextInt(5) + "");
			jobInfo.setJobCode(i + "");
			jobInfo.setChangeCode(i % 5 + "");
			jobInfo.setHandleUserCode(i % 2 + "");
			jobInfos.add(jobInfo);
		}
		JobInfo[] shu = new JobInfo[jobInfos.size()];
		HashMap<String, JobInfo> map = new HashMap<>();
		for (int i = 0; i < jobInfos.size(); i++) {
			shu[i] = jobInfos.get(i);
			map.put(jobInfos.get(i).getJobCode(), jobInfos.get(i));
		}
		List<JobNumInfo> jobNumInfoList = new ArrayList<>();
		String[] buArr = new String[jobInfos.size()];
		int index = 0;
		for (int i = 0; i < 5; i++) {
			JobNumInfo jobNumInfo = new JobNumInfo();
			jobNumInfo.setBuId(i + "");
			jobNumInfo.setJobNum(2);
			jobNumInfoList.add(jobNumInfo);
			if (jobNumInfo.getJobNum() > 0) {
				for (Integer integer = 0; integer < jobNumInfo.getJobNum(); integer++) {
					buArr[index++] = jobNumInfo.getBuId() == null ? "" : jobNumInfo.getBuId();
				}
			}
		}
//		f(shu, jobInfos.size(), 0, buArr);
		permutation(shu, buArr);
		for (JobInfo jobInfo : jobInfoListFinal) {
			System.out.println(jobInfo);
		}
//		permutation(shu);
//		int i = 0;
//		List<List<JobInfo>> allList = new ArrayList<>();
//		for (Stack<String> strings : jobCodeList) {
//			List<JobInfo> list = new ArrayList<>();
//			while (!strings.empty()) {
//				String code = strings.pop();
//				JobInfo jobInfo = map.get(code);
//				if (jobInfo != null) {
//					jobInfo.setQualityBuId(buArr[i++]);
//				}
//				list.add(jobInfo);
//			}
//			allList.add(list);
//		}
		System.out.println("s");
		
	}
	
	/**
	 * @param shu  待选择的数组
	 * @param targ 要选择多少个次
	 * @param cur  当前选择的是第几次
	 */
	private static int countMax = 0;
	private static int countMax1 = 0;
	private static int countMax2 = 0;
	
	private static JobInfo[] jobInfoListFinal = null;
	
	private static void f(JobInfo[] shu, int targ, int cur, String[] buArr) {
		if (cur == targ) {
//			List<JobInfo> jobInfoList = new ArrayList<>();
//			for (JobInfo jobInfo : stack) {
//				jobInfoList.add(jobInfo);
//			}
//			for (int i = 0; i < jobInfoList.size(); i++) {
//				jobInfoList.get(i).setQualityBuId(buArr[i]);
//			}
//			int count = 0;
//			for (JobInfo jobInfo : jobInfoList) {
//				if (jobInfo.getBuId() == null || !jobInfo.getBuId().equals(jobInfo.getQualityBuId())) {
//					count++;
//				}
//			}
//			System.out.println(count);
//			if (jobInfoListFinal == null) {
//				jobInfoListFinal =new JobInfo[];
//			} else {
//				if (count > countMax) {
//					jobInfoListFinal = jobInfoList;
//				} else if (count == countMax) {
//					for (JobInfo jobInfo : jobInfoListFinal) {
//
//					}
//				}
//			}
			return;
		}
		for (int i = 0; i < shu.length; i++) {
			if (!stack.contains(shu[i])) {
				stack.add(shu[i]);
				f(shu, targ, cur + 1, buArr);
				stack.pop();
			}
		}
	}
	
	static List<String[]> list = new ArrayList<>();
	
	public static void permutation(JobInfo[] s, String[] buArr) {
		permutate(s, 0, buArr);
//		String[] res = new String[list.size()];
//		for (int i = 0; i < res.length; i++) {
//			String[] strings = list.get(i);
//			res[i]=
//		}
		for (String[] strings : list) {
//			jobCodeList.add(strings);
		}
	}
	
	public static void permutate(JobInfo[] arr, int first, String[] buArr) {
		if (first == arr.length - 1) {
//			List<JobInfo> jobInfoList = new ArrayList<>();
			int count = 0;
			HashMap<String, Integer> mapChangeCode = new HashMap<>();
			HashMap<String, Integer> mapHandleUserCode = new HashMap<>();
			for (int i = 0; i < arr.length; i++) {
				arr[i].setQualityBuId(buArr[i]);
				if (arr[i].getBuId() == null || !arr[i].getBuId().equals(arr[i].getQualityBuId())) {
					count++;
				}
				String key = arr[i].getChangeCode() + "/" + arr[i].getQualityBuId();
				int changeCodeCount = mapChangeCode.getOrDefault(key, 0);
				mapChangeCode.put(key, ++changeCodeCount);
				
				String key2 = arr[i].getHandleUserCode() + "/" + arr[i].getQualityBuId();
				int handleUserCount = mapHandleUserCode.getOrDefault(key2, 0);
				mapHandleUserCode.put(key2, ++handleUserCount);
			}
			int count1 = 0;
			for (Map.Entry<String, Integer> entry : mapChangeCode.entrySet()) {
				if(entry.getValue()>1){
					count1 += entry.getValue();
				}
			}
			
			int count2 = 0;
			for (Map.Entry<String, Integer> entry : mapHandleUserCode.entrySet()) {
				if(entry.getValue()>1){
					count2 += entry.getValue();
				}
			}
			System.out.println(count);
			if (jobInfoListFinal==null) {
				copyArr(arr);
				countMax = count;
				countMax1 = count1;
				countMax2 = count2;
			} else {
				if (count > countMax) {
					copyArr(arr);
					countMax = count;
					countMax1 = count1;
					countMax2 = count2;
				} else if (count == countMax) {
					if (countMax1 < count1 || (countMax1 == count1 && count2 > countMax2)) {
						copyArr(arr);
						countMax1 = count1;
						countMax2 = count2;
					}
				}
			}
			return;
		}
		for (int i = first; i < arr.length; i++) {
			swap(arr, first, i);
			permutate(arr, first + 1, buArr);
			swap(arr, first, i);
		}
	}
	
	private static void copyArr(JobInfo[] arr) {
		jobInfoListFinal=new JobInfo[arr.length];
		for (int i = 0; i < arr.length; i++) {
			JobInfo jobInfo = new JobInfo();
			JobInfo info = arr[i];
			BeanUtils.copyProperties(info,jobInfo);
			jobInfoListFinal[i]= jobInfo;
		}
	}
	
	public static void swap(JobInfo[] arr, int i, int j) {
		JobInfo temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
}
