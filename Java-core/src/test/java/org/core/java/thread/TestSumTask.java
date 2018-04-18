package org.core.java.thread;

import org.core.java.thread.forkjoin.SumTask;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

/**
 * SumTask test
 *
 * @author clx 2018/4/17.
 */
public class TestSumTask {

	private static Random random = new Random();

	public static void main(String[] args) {
		int[] array = new int[25000000];

		for (int idx = 0; idx < array.length; idx++) {
			array[idx] = random.nextInt();
		}

		int availableProcessors = Runtime.getRuntime().availableProcessors();
		System.out.println("availableProcessors:" + availableProcessors);
		ForkJoinPool forkJoinPool = new ForkJoinPool(availableProcessors);
		ForkJoinTask<Integer> forkJoinTask = new SumTask(array, 0, array.length);
		long startTime = System.currentTimeMillis();
		long result = forkJoinPool.invoke(forkJoinTask);
		System.out.println("SumTask result:" + result);
		System.out.println("SumTask used time:" + (System.currentTimeMillis() - startTime));
	}
}
