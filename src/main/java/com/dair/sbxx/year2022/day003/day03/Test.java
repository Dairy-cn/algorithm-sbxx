package com.dair.sbxx.year2022.day003.day03;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author Dair
 * @since
 */
public class Test {
	
	public static void main(String[] args) {
		List<JobInfo> jobInfos = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			JobInfo jobInfo = new JobInfo();
			jobInfo.setBuId(Long.valueOf(i / 10) );
			jobInfo.setJobCode(i + "");
			jobInfo.setChangeCode(i % 5 + "");
			jobInfo.setHandleUserCode(i % 2 + "");
			jobInfos.add(jobInfo);
		}
		List<JobNumInfo> jobNumInfoList = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			JobNumInfo jobNumInfo = new JobNumInfo();
			jobNumInfo.setBuId(Long.valueOf(i));
			jobNumInfo.setJobNum(10);
			jobNumInfoList.add(jobNumInfo);
		}
		PriorityQueue<JobNumInfo> jobNumInfoPriorityQueue = new PriorityQueue<>(new Comparator<JobNumInfo>() {
			@Override
			public int compare(JobNumInfo o1, JobNumInfo o2) {
				return o2.getJobNum() - o1.getJobNum();
			}
		});
		for (JobNumInfo jobNumInfo : jobNumInfoList) {
			jobNumInfoPriorityQueue.offer(jobNumInfo);
		}
		PriorityQueue<String[]> changeAndUserCodeQueue = new PriorityQueue<>(new Comparator<String[]>() {
			@Override
			public int compare(String[] o1, String[] o2) {
				return Integer.valueOf(o2[1]) - Integer.valueOf(o1[1]);
			}
		});
		PriorityQueue<String[]> changeMapQueue = new PriorityQueue<>(new Comparator<String[]>() {
			@Override
			public int compare(String[] o1, String[] o2) {
				return Integer.valueOf(o2[1]) - Integer.valueOf(o1[1]);
			}
		});
		PriorityQueue<String[]> userCodeQueue = new PriorityQueue<>(new Comparator<String[]>() {
			@Override
			public int compare(String[] o1, String[] o2) {
				return Integer.valueOf(o2[1]) - Integer.valueOf(o1[1]);
			}
		});
		Map<Long, List<JobInfo>> buMap = new HashMap<>();
		Map<String, List<JobInfo>> changeAndUserCodeMap = new HashMap<>();
		Map<String, List<JobInfo>> changeMap = new HashMap<>();
		Map<String, List<JobInfo>> userCodeMap = new HashMap<>();
		for (JobInfo jobInfo : jobInfos) {
			String changeAndUserCodeKey = jobInfo.getChangeCode() + "/" + jobInfo.getHandleUserCode();
			List<JobInfo> changeAndUserCodeList = changeAndUserCodeMap.get(changeAndUserCodeKey);
			if (changeAndUserCodeList == null) {
				changeAndUserCodeList = new ArrayList<>();
			}
			changeAndUserCodeList.add(jobInfo);
			changeAndUserCodeMap.put(changeAndUserCodeKey, changeAndUserCodeList);
			
			String changeKey = jobInfo.getChangeCode();
			List<JobInfo> changeList = changeMap.get(changeKey);
			if (changeList == null) {
				changeList = new ArrayList<>();
			}
			changeList.add(jobInfo);
			changeAndUserCodeMap.put(changeKey, changeList);
			
			String handleUserCodeKey = jobInfo.getHandleUserCode();
			List<JobInfo> handleList = userCodeMap.get(handleUserCodeKey);
			if (handleList == null) {
				handleList = new ArrayList<>();
			}
			handleList.add(jobInfo);
			userCodeMap.put(handleUserCodeKey, handleList);
			
			if (jobInfo.getBuId() != null) {
				List<JobInfo> buList = buMap.get(jobInfo.getBuId());
				if (buList == null) {
					buList = new ArrayList<>();
				}
				buList.add(jobInfo);
				buMap.put(jobInfo.getBuId(), buList);
			}
		}
		
		for (Map.Entry<String, List<JobInfo>> entry : changeAndUserCodeMap.entrySet()) {
			if (entry.getValue().size() > 1) {
				String[] arr = new String[2];
				arr[0] = entry.getKey();
				arr[1] = entry.getValue().size() + "";
				changeAndUserCodeQueue.offer(arr);
			}
		}
		
		for (Map.Entry<String, List<JobInfo>> entry : changeMap.entrySet()) {
			if (entry.getValue().size() > 1) {
				String[] arr = new String[2];
				arr[0] = entry.getKey();
				arr[1] = entry.getValue().size() + "";
				changeMapQueue.offer(arr);
			}
		}
		
		for (Map.Entry<String, List<JobInfo>> entry : userCodeMap.entrySet()) {
			if (entry.getValue().size() > 1) {
				String[] arr = new String[2];
				arr[0] = entry.getKey();
				arr[1] = entry.getValue().size() + "";
				userCodeQueue.offer(arr);
			}
		}
		
		while (!jobNumInfoPriorityQueue.isEmpty()) {
			JobNumInfo info = jobNumInfoPriorityQueue.poll();
			if (!changeAndUserCodeQueue.isEmpty()) {
				while (!changeAndUserCodeQueue.isEmpty()) {
					String[] arr = changeAndUserCodeQueue.poll();
					
				}
			}
		}
	}
}

