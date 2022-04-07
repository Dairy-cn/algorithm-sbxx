package com.dair.sbxx.year2022.day004.day04;


import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

/**
 * Created by 13633 on 2019/12/9.
 */
public class Population {
	private IndividualForGa[] population;
	private double populationFitness = -1;
	
	Population(int populationSize) {
		this.population = new IndividualForGa[populationSize];
	}
	
	Population(int populationSize, int chromosomeLength) {
		this.population = new IndividualForGa[populationSize];
		for (int i = 0; i < populationSize; i++) {
			IndividualForGa individual = new IndividualForGa(chromosomeLength);
			this.population[i] = individual;
		}
	}
	
	public IndividualForGa[] getPopulation() {
		return population;
	}
	
	public void setPopulation(IndividualForGa[] population) {
		this.population = population;
	}
	
	/*
	 * 返回指定排序的个体的适应度
	 */
	public IndividualForGa getFittest(int offset) {
		Arrays.sort(this.population, new Comparator<IndividualForGa>() {
			@Override
			public int compare(IndividualForGa o1, IndividualForGa o2) {
				if (o1.getFitness() > o2.getFitness()) {
					return -1;
				} else if (o1.getFitness() == o2.getFitness()) {
					if (o1.getFitness1() > o2.getFitness1()) {
						return -1;
					} else if (o1.getFitness1() == o2.getFitness1()) {
						if (o1.getFitness2() > o2.getFitness2()) {
							return -1;
						} else {
							return 0;
						}
					} else {
						return 0;
					}
					
				} else {
					return 0;
				}
			}
		});
		return this.population[offset];
	}
	
	public void setPopulationFitness(double populationFitness) {
		this.populationFitness = populationFitness;
	}
	
	public double getPopulationFitness() {
		return populationFitness;
	}
	
	public int size() {
		return population.length;
	}
	
	// 打乱种群
	public void shuffle() {
		Random ran = new Random();
		for (int i = this.population.length - 1; i > 0; i--) {
			int index = ran.nextInt(i + 1);
			IndividualForGa a = population[index];
			population[index] = population[i];
			population[i] = a;
		}
	}
	
	public void setIndividualForGa(int index, IndividualForGa individual) {
		this.population[index] = individual;
	}
	
	public IndividualForGa getIndividualForGa(int index) {
		return population[index];
	}
}
