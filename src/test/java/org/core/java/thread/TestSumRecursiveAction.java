package org.core.java.thread;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

import org.core.java.thread.forkjoin.SumRecursiveAction;
import org.core.java.thread.forkjoin.SumRecursiveTask;

/**
 * SumTask test
 *
 * @author clx 2018/4/17.
 */
public class TestSumRecursiveAction {

	private static Random random = new Random();

	public static void main(String[] args) {
		int[] array = new int[25000000];

		for (int idx = 0; idx < array.length; idx++) {
			array[idx] = random.nextInt();
		}
		System.out.println(Arrays.toString(array));

		int availableProcessors = Runtime.getRuntime().availableProcessors();
		System.out.println("availableProcessors:" + availableProcessors);
		ForkJoinPool forkJoinPool = new ForkJoinPool(availableProcessors);
		ForkJoinTask forkJoinTask = new SumRecursiveAction(array);
		long startTime = System.currentTimeMillis();
		forkJoinPool.invoke(forkJoinTask);
		System.out.println("SumTask result:" + ((SumRecursiveAction) forkJoinTask).getResult());
		System.out.println("SumTask used time:" + (System.currentTimeMillis() - startTime));
	}
}
