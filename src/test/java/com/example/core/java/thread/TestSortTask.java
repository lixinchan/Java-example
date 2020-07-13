package com.example.core.java.thread;

import com.example.core.java.thread.forkjoin.SortTask;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

/**
 * @author clx 2018/4/19.
 */
public class TestSortTask {

	private static Random random = new Random();

	public static void main(String[] args) {
		int[] array = new int[2500000];

		for (int idx = 0; idx < array.length; idx++) {
			array[idx] = random.nextInt();
		}

		int availableProcessors = Runtime.getRuntime().availableProcessors();
		System.out.println("availableProcessors:" + availableProcessors);
		ForkJoinPool forkJoinPool = new ForkJoinPool(availableProcessors);
		ForkJoinTask forkJoinTask = new SortTask(array);
		long startTime = System.currentTimeMillis();
		forkJoinPool.invoke(forkJoinTask);
		System.out.println(Arrays.toString(array));
		System.out.println("sort task used time:" + (System.currentTimeMillis() - startTime));
	}
}
