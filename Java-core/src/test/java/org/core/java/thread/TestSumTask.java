package org.core.java.thread;

import org.core.java.thread.forkjoin.SumTask;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

/**
 * SumTask test
 *
 * @author clx 2018/4/17.
 */
public class TestSumTask {

	public static void main(String[] args) {
		long[] array = new long[500];

		// todo: 
		ForkJoinPool forkJoinPool = new ForkJoinPool(4);
		ForkJoinTask<Long> forkJoinTask = new SumTask(array, 0, array.length);
		long startTime = System.currentTimeMillis();
		long result = forkJoinPool.invoke(forkJoinTask);
		System.out.println("SumTask result:" + result);
		System.out.println("SumTask used time:" + (System.currentTimeMillis() - startTime));
	}
}
