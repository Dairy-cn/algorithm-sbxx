package com.dair.sbxx.year2022.day04;

import java.util.HashMap;
import java.util.Random;


public class Individual {
	private int[] path;
	private long totalCount;
	private long totalChangeCount;
	private long totalChangeAndUserCount;
	
	private JobInfo[] jobInfos;
	
	public Individual(int[] path) {
		this.path = path;
	}
	
	public Individual(int pathLength) {
		this.path = new int[pathLength];
		for (int i = 0; i < pathLength; i++) {
			path[i] = i;
		}
	}
	
	public void setFitness(JobInfo[] jobInfos, Long[] buArr) {
		long count = 0;
		long changeCount = 0;
		long changeAndUserCount = 0;
		HashMap<String, Integer> mapChangeCode = new HashMap<>();
		HashMap<String, Integer> mapHandleUserCode = new HashMap<>();
		for (int i = 0; i < path.length; i++) {
			jobInfos[i].setQualityBuId(buArr[path[i]]);
			if (jobInfos[i].getBuId() == null || !jobInfos[i].getBuId().equals(jobInfos[i].getQualityBuId())) {
				count++;
			}
			String key = jobInfos[i].getChangeCode() + "/" + jobInfos[i].getQualityBuId();
			int changeCodeCount = mapChangeCode.getOrDefault(key, 0);
			mapChangeCode.put(key, ++changeCodeCount);
			if (changeCodeCount > 1) {
				++changeCount;
			}
			String key2 = jobInfos[i].getHandleUserCode() + "/" + jobInfos[i].getQualityBuId();
			int handleUserCount = mapHandleUserCode.getOrDefault(key2, 0);
			mapHandleUserCode.put(key2, ++handleUserCount);
			if (handleUserCount > 1) {
				++changeAndUserCount;
			}
		}
		this.totalCount = count;
		this.totalChangeCount = changeCount;
		this.totalChangeAndUserCount = changeAndUserCount;
		this.jobInfos = jobInfos;
	}
	
	public long getTotalCount() {
		
		return totalCount;
	}
	
	public long getTotalChangeCount() {
		
		return totalChangeCount;
	}
	
	public long getTotalChangeAndUserCount() {
		return totalChangeAndUserCount;
	}
	
	public int[] getPath() {
		return path;
	}
	
	/**
	 * 随机交换
	 * @param seed
	 * @return
	 */
	public Individual shuffle(int seed) {
		Random rand = new Random();
		Individual tempIndividual = new Individual(path.length);
		int[] tempPath = tempIndividual.getPath();
		for (int i = 0; i < path.length; i++) {
			tempPath[i] = path[i];
		}
		for (int i = 0; i < seed; i++) {
			int randIndex = rand.nextInt(path.length );
			int randIndex2 = rand.nextInt(path.length );
			int temp = tempPath[randIndex];
			tempPath[randIndex] = tempPath[randIndex2];
			tempPath[randIndex2] = temp;
		}
		return tempIndividual;
	}
	
	public String print() {
		String out = "";
		for (int i = 0; i < this.path.length; i++) {
			out += this.path[i];
		}
		return "Soluation：" + out + "\ttotalCount：" + this.totalCount + "\ttotalChangeCount：" + this.totalChangeCount + "\ttotalChangeAndUserCount：" + this.totalChangeAndUserCount;
	}
	
	public void printJobInfo(){
		for (JobInfo jobInfo : jobInfos) {
			System.out.println(jobInfo);
		}
	}
}
