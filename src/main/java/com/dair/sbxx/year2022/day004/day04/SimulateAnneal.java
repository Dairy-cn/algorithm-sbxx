package com.dair.sbxx.year2022.day004.day04;

/**
 * 模拟退火算法
 * 全排列的优化方式 存在一定误差（5%），但解决了全排列极高的时间复杂度
 *
 * @author Dair
 * @since 2022/3/31 
 */
public class SimulateAnneal {
	//初始温度
	private double T;
	// 降温系数
	private double delta;
	// 内迭代次数
	private int generation;
	// Metropolis 常数项
	private static final int k = 30;
	// 终止温度
	private static final double MinTemper = 1e-8;
	
	public SimulateAnneal(double t, double delta, int generation) {
		T = t;
		this.delta = delta;
		this.generation = generation;
	}
	
	/**
	 * 算法主体
	 * @param jobInfos
	 * @param buArr
	 * @return
	 */
	public Individual SA(JobInfo[] jobInfos, Long[] buArr) {
		Individual solve = new Individual(jobInfos.length);
		solve.setFitness(jobInfos, buArr);
		Individual bestSolution = solve;
		while (T > MinTemper) {
			for (int i = 0; i < generation; i++) {
				Individual tempSolution = solve.shuffle(jobInfos.length/3);
				tempSolution.setFitness(jobInfos, buArr);
				long bias = tempSolution.getTotalCount() - solve.getTotalCount();
				long bias2 = tempSolution.getTotalChangeCount() - solve.getTotalChangeCount();
				long bias3 = tempSolution.getTotalChangeAndUserCount() - solve.getTotalChangeAndUserCount();
				if (bias > 0) {
					solve = tempSolution;
				} else if (bias == 0) {
					if (bias2 > 0) {
						solve = tempSolution;
					} else if (bias2 == 0) {
						if (bias3 > 0) {
							solve = tempSolution;
						} else if (Math.exp(bias3 / (k * T)) > Math.random()) {
							// Metropolis准则接收新解
							solve = tempSolution;
						}
						
					} else if (Math.exp(bias2 / (k * T)) > Math.random()) {
						// Metropolis准则接收新解
						solve = tempSolution;
					}
				} else if (Math.exp(bias / (k * T)) > Math.random()) {
					// Metropolis准则接收新解
					solve = tempSolution;
				}
			}
			System.out.println(solve.print());
			if (solve.getTotalCount() > bestSolution.getTotalCount()) {
				bestSolution = solve;
			}else if(solve.getTotalCount() == bestSolution.getTotalCount()){
				if (solve.getTotalChangeCount() > bestSolution.getTotalChangeCount()) {
					bestSolution = solve;
				}else if(solve.getTotalChangeCount() == bestSolution.getTotalChangeCount()){
					if(solve.getTotalChangeAndUserCount()>bestSolution.getTotalChangeAndUserCount()){
						bestSolution = solve;
					}
				}
			}
			T *= delta;
		}
		return bestSolution;
	}
}
