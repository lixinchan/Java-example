package com.example.core.java.thread.forkjoin;

import java.util.concurrent.RecursiveAction;

/**
 * @author clx 2018/4/19.
 */
public class SumRecursiveAction extends RecursiveAction {

	/**
	 * THRESHOLD
	 */
	private static final int THRESHOLD = 100;

	/**
	 * array
	 */
	private final int[] array;
	/**
	 * lo
	 */
	private int lo;
	/**
	 * hi
	 */
	private int hi;
	/**
	 * result
	 */
	private long result;

	/**
	 * get result
	 * 
	 * @return
	 */
	public long getResult() {
		return this.result;
	}

	public SumRecursiveAction(int[] array, int lo, int hi) {
		this.array = array;
		this.lo = lo;
		this.hi = hi;
	}

	public SumRecursiveAction(int[] array) {
		this(array, 0, array.length);
	}

	@Override
	protected void compute() {
		if (hi - lo < THRESHOLD) {
			for (int idx = lo; idx < hi; idx++) {
				result += array[idx];
			}
		} else {
			int mid = (lo + hi) >>> 1;
			invokeAll(new SumRecursiveAction(array, lo, mid), new SumRecursiveAction(array, mid, hi));
		}
	}
}
