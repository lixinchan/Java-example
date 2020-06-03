package com.example.core.java.thread.communicate;

import java.util.stream.IntStream;

/**
 * @author clx
 */
public class ObjectLock {


	private static final Object LOCK = new Object();

	public static void main(String[] args) {
		new Thread(new ThreadA()).start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		new Thread(new ThreadB()).start();
	}

	static class ThreadA implements Runnable {

		@Override
		public void run() {
			synchronized (LOCK) {
				IntStream.range(0, 3).forEach(idx -> {
					try {
						System.out.println("a->" + idx);
						LOCK.notifyAll();
						LOCK.wait();
					} catch (InterruptedException e) {
						Thread.currentThread().interrupt();
						e.printStackTrace();
					}
				});
				LOCK.notify();
			}
		}
	}

	static class ThreadB implements Runnable {

		@Override
		public void run() {
			synchronized (LOCK) {
				IntStream.range(0, 3).forEach(idx -> {
					try {
						System.out.println("b->" + idx);
						LOCK.notifyAll();
						LOCK.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				});
				LOCK.notify();
			}
		}
	}
}
