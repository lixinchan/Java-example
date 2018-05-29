package org.core.java.thread.forkjoin;

import java.util.Arrays;
import java.util.concurrent.RecursiveAction;

/**
 * sort task
 * 
 * @author clx 2018/4/19.
 */
public class SortTask extends RecursiveAction {

	/**
	 * THRESHOLD
	 */
	private static final int THRESHOLD = 100;
	/**
	 * array
	 */
	private int[] array;
	/**
	 * lo
	 */
	private int lo;
	/**
	 * hi
	 */
	private int hi;

	public SortTask(int[] array, int lo, int hi) {
		this.array = array;
		this.lo = lo;
		this.hi = hi;
	}

	public SortTask(int[] array) {
		this(array, 0, array.length);
	}

	@Override
	protected void compute() {
		if (hi - lo < THRESHOLD) {
			this.sortSequentially(lo, hi);
		} else {
			int mid = (lo + hi) >>> 1;
			invokeAll(new SortTask(array, lo, mid), new SortTask(array, mid, hi));
			this.merge(lo, mid, hi);
		}
	}

	/**
	 * sort
	 * 
	 * @param lo
	 * @param hi
	 */
	private void sortSequentially(int lo, int hi) {
		Arrays.sort(array, lo, hi);
	}

	/**
	 * merge
	 * 
	 * @param lo
	 * @param mid
	 * @param hi
	 */
	private void merge(int lo, int mid, int hi) {
		int[] buf = Arrays.copyOfRange(array, lo, mid);
		for (int idx = 0, jdx = lo, k = mid; idx < buf.length; jdx++) {
			array[jdx] = (k == hi || buf[idx] < array[k]) ? buf[idx++] : array[k++];
		}
	}
}
