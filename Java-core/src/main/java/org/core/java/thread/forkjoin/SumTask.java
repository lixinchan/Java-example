package org.core.java.thread.forkjoin;

import java.util.concurrent.RecursiveTask;

/**
 * fork&join task
 *
 * @author clx 2018/4/17.
 */
public class SumTask extends RecursiveTask<Long> {

	/**
	 * THRESHOLD
	 */
	private static final int THRESHOLD = 100;
	/**
	 * array
	 */
	private long[] array;
	/**
	 * start
	 */
	private int start;
	/**
	 * end
	 */
	private int end;

	public SumTask(long[] array, int start, int end) {
		this.array = array;
		this.start = start;
		this.end = end;
	}

	@Override
	protected Long compute() {
		// compute directly
		if (end - start <= THRESHOLD) {
			long sum = 0;
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
		System.out.println(String.format("split task %d~%d->%d%d, %d~%d", start, end, start, mid, mid, end));
		SumTask firstTask = new SumTask(array, start, mid);
		SumTask secondTask = new SumTask(array, start, mid);
		invokeAll(firstTask, secondTask);
		long firstResult = firstTask.join();
		long secondResult = secondTask.join();
		return firstResult + secondResult;
	}
}
