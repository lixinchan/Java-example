package com.example.core.java.thread;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

import com.example.core.java.thread.forkjoin.SumRecursiveTask;

/**
 * SumTask test
 *
 * @author clx 2018/4/17.
 */
public class TestSumRecursiveTask {

	private static Random random = new Random();

	public static void main(String[] args) {
		int[] array = new int[25000000];

		for (int idx = 0; idx < array.length; idx++) {
			array[idx] = random.nextInt();
		}

		int availableProcessors = Runtime.getRuntime().availableProcessors();
		System.out.println("availableProcessors:" + availableProcessors);
		ForkJoinPool forkJoinPool = new ForkJoinPool(availableProcessors);
		ForkJoinTask<Integer> forkJoinTask = new SumRecursiveTask(array, 0, array.length);
		long startTime = System.currentTimeMillis();
		long result = forkJoinPool.invoke(forkJoinTask);
		System.out.println("SumTask result:" + result);
		System.out.println("SumTask used time:" + (System.currentTimeMillis() - startTime));
	}
}
