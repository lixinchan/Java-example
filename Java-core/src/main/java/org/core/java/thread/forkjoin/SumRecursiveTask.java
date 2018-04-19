package org.core.java.thread.forkjoin;

import java.util.concurrent.RecursiveTask;

/**
 * fork&join task
 *
 * @author clx 2018/4/17.
 */
public class SumRecursiveTask extends RecursiveTask<Integer> {

	/**
	 * THRESHOLD
	 */
	private static final int THRESHOLD = 100;
	/**
	 * array
	 */
	private int[] array;
	/**
	 * start
	 */
	private int start;
	/**
	 * end
	 */
	private int end;

	public SumRecursiveTask(int[] array, int start, int end) {
		this.array = array;
		this.start = start;
		this.end = end;
	}

	@Override
	protected Integer compute() {
		// compute directly
		if (end - start <= THRESHOLD) {
			int sum = 0;
			for (int idx = start; idx < end; idx++) {
				sum += array[idx];
			}

			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(String.format("compute sum %d~%d=%d", start, end, sum));
			return sum;
		}

		// split task
		int mid = (start + end) >>> 1;
		System.out.println(String.format("split task %d~%d->%d~%d, %d~%d", start, end, start, mid, mid, end));
		SumRecursiveTask firstTask = new SumRecursiveTask(array, start, mid);
		SumRecursiveTask secondTask = new SumRecursiveTask(array, mid, end);
		invokeAll(firstTask, secondTask);
		int firstResult = firstTask.join();
		int secondResult = secondTask.join();
		return firstResult + secondResult;
	}
}
