package com.example.core.java.thread.practice;

import java.util.concurrent.Semaphore;

/**
 * @author clx 3/7/2018
 */
public class TestSemaphore {

	public static void main(String[] args) {
		testSemaphore();
	}

	private static void testSemaphore() {
		int machineNum = 5;
		Semaphore semaphore = new Semaphore(machineNum);
		int worker = 10;

		for (int idx = 0; idx < worker; idx++) {
			new Worker(idx, semaphore).start();
		}
	}

	static class Worker extends Thread {

		private int num;
		private Semaphore semaphore;

		public Worker(int num, Semaphore semaphore) {
			this.num = num;
			this.semaphore = semaphore;
		}

		@Override
		public void run() {
			try {
				semaphore.acquire();
				System.out.println(num + " worker working...");
				Thread.sleep(10000);
				System.out.println(num + " worker finished.");
				semaphore.release();
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}
	}
}
