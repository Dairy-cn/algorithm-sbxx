package com.dair.sbxx.year2022.day004.day04;

/**
 * Created by 13633 on 2019/12/9.
 */
public class IndividualForGa {
	private int[] chromosome;
	private long fitness = -1;
	
	private long fitness1 = -1;
	private long fitness2 = -1;
	
	private long totalCount;
	private long totalChangeCount;
	private long totalChangeAndUserCount;
	
	
	IndividualForGa(int chromosomeSize) {
		this.chromosome = new int[chromosomeSize];
		for (int i = 0; i < chromosomeSize; i++) {
			this.chromosome[i] = i;
		}
	}
	
	IndividualForGa(int[] chromosome) {
		this.chromosome = chromosome;
	}
	
	// 子代初始化
	IndividualForGa(int chromosomeSize, int flag) {
		this.chromosome = new int[chromosomeSize];
		for (int i = 0; i < chromosomeSize; i++) {
			this.chromosome[i] = -1;
		}
	}
	
	public void setGene(int index, int val) {
		this.chromosome[index] = val;
	}
	
	public int[] getChromosome() {
		return chromosome;
	}
	
	public void setChromosome(int[] chromosome) {
		this.chromosome = chromosome;
	}
	
	public int getChromosomeLength() {
		return this.chromosome.length;
	}
	
	public int getGene(int index) {
		return this.chromosome[index];
	}
	
	public void setFitness(long fitness) {
		this.fitness = fitness;
	}
	
	public double getFitness() {
		return fitness;
	}
	
	public void setFitness1(long fitness) {
		this.fitness1 = fitness;
	}
	
	public double getFitness1() {
		return fitness1;
	}
	
	public void setFitness2(long fitness) {
		this.fitness2 = fitness;
	}
	
	public double getFitness2() {
		return fitness2;
	}
	
	public boolean containGene(int gene) {
		for (int i = 0; i < chromosome.length; i++) {
			if (chromosome[i] == gene) {
				return true;
			}
		}
		return false;
	}
	
	public void setTotal(long totalCount,long totalChangeCount,long totalChangeAndUserCount) {
		this.totalCount = totalCount;
		this.totalChangeCount = totalChangeCount;
		this.totalChangeAndUserCount = totalChangeAndUserCount;
	}
	
	@Override
	public String toString() {
		String out = "";
		for (int i = 0; i < this.chromosome.length; i++) {
			out += this.chromosome[i];
		}
		return out + "\tfitness：" + this.fitness + "\ttotalCount：" + this.totalCount + "\ttotalChangeCount：" + this.totalChangeCount + "\ttotalChangeAndUserCount：" + this.totalChangeAndUserCount;
	}
}
