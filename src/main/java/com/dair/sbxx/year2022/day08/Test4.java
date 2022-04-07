package com.dair.sbxx.year2022.day08;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Set;
import java.util.Stack;

/**
 * @author Dair
 * @since
 */
public class Test4 {
	public static Stack<JobInfo> stack = new Stack<JobInfo>();
	
	public static List<Stack<String>> jobCodeList = new ArrayList<>();
	
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		List<JobInfo> jobInfos = new ArrayList<>();
		Set<Long> buIds = new HashSet<>();
		for (int i = 0; i < 100; i++) {
			JobInfo jobInfo = new JobInfo();
			long buId = (long) new Random().nextInt(10);
			buIds.add(buId);
			jobInfo.setBuId(buId);
			jobInfo.setJobCode(i + "");
			jobInfo.setChangeCode(new Random().nextInt(12) + "");
			jobInfo.setHandleUserCode(new Random().nextInt(10) + "");
			jobInfos.add(jobInfo);
		}
		PriorityQueue<String[]> notBuQueue = new PriorityQueue<>(new Comparator<String[]>() {
			@Override
			public int compare(String[] o1, String[] o2) {
				return Integer.valueOf(o1[1]) - Integer.valueOf(o2[1]);
			}
		});
		HashMap<Long, List<JobInfo>> notBuMap = new HashMap<>();
//		HashMap<Long, List<JobInfo>> buMap = new HashMap<>();
		for (Long buId : buIds) {
			List<JobInfo> infoList = notBuMap.get(buId);
			if (CollectionUtils.isEmpty(infoList)) {
				infoList = new ArrayList<>();
			}
			for (JobInfo jobInfo : jobInfos) {
				if (jobInfo.getBuId() == null || !jobInfo.getBuId().equals(buId)) {
					infoList.add(jobInfo);
				}
			}
			notBuMap.put(buId, infoList);
			String[] arr = new String[2];
			arr[0] = buId + "";
			arr[1] = infoList.size() + "";
			notBuQueue.offer(arr);
		}
//		for (JobInfo jobInfo : jobInfos) {
//			List<JobInfo> infos = buMap.get(jobInfo.getBuId());
//			if (CollectionUtils.isEmpty(infos)) {
//				infos = new ArrayList<>();
//			}
//			infos.add(jobInfo);
//			buMap.put(jobInfo.getBuId(), infos);
//
//		}
		JobInfo[] shu = new JobInfo[jobInfos.size()];
		HashMap<String, JobInfo> map = new HashMap<>();
		for (int i = 0; i < jobInfos.size(); i++) {
			shu[i] = jobInfos.get(i);
			map.put(jobInfos.get(i).getJobCode(), jobInfos.get(i));
		}
		List<JobNumInfo> jobNumInfoList = new ArrayList<>();
		Long[] buArr = new Long[jobInfos.size()];
		int index = 0;
		int totalCount = 0;
		for (int i = 0; totalCount < 100; i++) {
			JobNumInfo jobNumInfo = new JobNumInfo();
			jobNumInfo.setBuId(Long.valueOf(i));
			int count = new Random().nextInt(10);
			totalCount += count;
			if (totalCount > 100) {
				count = totalCount - 100;
			}
			jobNumInfo.setJobNum(count);
			jobNumInfoList.add(jobNumInfo);
			if (jobNumInfo.getJobNum() > 0) {
				for (Integer integer = 0; integer < jobNumInfo.getJobNum(); integer++) {
					buArr[index++] = jobNumInfo.getBuId() == null ? null : jobNumInfo.getBuId();
				}
			}
		}
		Collections.sort(jobNumInfoList, new Comparator<JobNumInfo>() {
			@Override
			public int compare(JobNumInfo o1, JobNumInfo o2) {
				return o1.getJobNum() - o2.getJobNum();
			}
		});
		Set<String> jobCode = new HashSet<>();
		HashMap<Long, JobNumInfo> jobNumInfoHashMap = new HashMap<>();
		for (JobNumInfo jobNumInfo : jobNumInfoList) {
			if (jobNumInfo.getJobNum() > 0) {
				List<JobInfo> infoList = notBuMap.get(jobCode);
				
				for (int i = 0; i < jobNumInfo.getJobNum(); i++) {
				
				}
				jobNumInfoHashMap.put(jobNumInfo.getBuId(), jobNumInfo);
			}
		}
		while (!notBuQueue.isEmpty()) {
			String[] poll = notBuQueue.poll();
			Long buId =Long.valueOf( poll[0]);
			JobNumInfo jobNumInfo = jobNumInfoHashMap.get(buId);
			List<JobInfo> infoList = notBuMap.get(buId);
			for (int i = 0; i < jobNumInfo.getJobNum(); i++) {
			
			}
		}
		
	}
	
	
}
