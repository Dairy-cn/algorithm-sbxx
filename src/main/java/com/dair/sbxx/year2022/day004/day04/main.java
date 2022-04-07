package com.dair.sbxx.year2022.day004.day04;

import java.security.SecureRandom;
import java.util.Random;

/**
 * Created by 13633 on 2019/12/15.
 */
public class main {
	public static JobInfo[] initJobInfo(int size) {
		JobInfo[] jobInfos = new JobInfo[size];
		for (int i = 0; i < size; i++) {
			JobInfo jobInfo = new JobInfo();
			jobInfo.setBuId(Long.valueOf(new Random().nextInt(6)));
			jobInfo.setJobCode(i + "");
			jobInfo.setChangeCode(new Random().nextInt(12) + "");
			jobInfo.setHandleUserCode(new Random().nextInt(10) + "");
			jobInfos[i] = jobInfo;
		}
		return jobInfos;
	}
	
	public static void main(String[] args) {
		for (int i = 0; i <100 ; i++) {
			System.out.println(Math.random());
			System.out.println(new SecureRandom().nextDouble());
		}
//		JobInfo[] jobInfos = initJobInfo(29);
//		Long[] buArr = new Long[jobInfos.length];
//		int index = 0;
//		int totalCount = 0;
//		for (int i = 0; totalCount < jobInfos.length; i++) {
//			JobNumInfo jobNumInfo = new JobNumInfo();
//			jobNumInfo.setBuId(Long.valueOf(i));
//			int count = new Random().nextInt(10);
//			totalCount += count;
//			if (totalCount > jobInfos.length) {
//				count = jobInfos.length - index;
//			}
//			jobNumInfo.setJobNum(count);
//			if (jobNumInfo.getJobNum() > 0) {
//				for (int j = 0; j < jobNumInfo.getJobNum(); j++) {
//					buArr[index++] = jobNumInfo.getBuId() == null ? null : jobNumInfo.getBuId();
//				}
//			}
//		}
//		SimulateAnneal anneal = new SimulateAnneal(400, 0.95, 1000);
//		Individual solve = anneal.SA(jobInfos, buArr);
//		System.out.println(solve.getTotalCount());
//		solve.printJobInfo();
	}
}

