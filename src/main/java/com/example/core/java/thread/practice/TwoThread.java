package com.example.core.java.thread.practice;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author clx
 */
public class TwoThread {

	private static final ReentrantLock LOCK = new ReentrantLock();

	private volatile boolean flag = false;

	private int start = 1;

	public static void main(String[] args) {
		TwoThread tt = new TwoThread();

		Thread t1 = new Thread(new OddThread(tt));
		t1.setName("OddNum");
		Thread t2 = new Thread(new EvenThread(tt));
		t2.setName("EvenNum");

		t1.start();
		t2.start();
	}

	static class OddThread implements Runnable {

		private TwoThread num;

		public OddThread(TwoThread tt) {
			this.num = tt;
		}

		@Override
		public void run() {
			while (num.start < 100) {
				if (!num.flag) {
					try {
						LOCK.lock();
						System.out.println(Thread.currentThread().getName() + "->" + num.start);
						num.start++;
						num.flag = true;
					} finally {
						LOCK.unlock();
					}
				}
			}
		}
	}

	static class EvenThread implements Runnable {

		private TwoThread num;

		public EvenThread(TwoThread tt) {
			this.num = tt;
		}

		@Override
		public void run() {
			while (num.start <= 100) {
				if (num.flag) {
					try {
						LOCK.lock();
						System.out.println(Thread.currentThread().getName() + "->" + num.start);
						num.start++;
						num.flag = false;
					} finally {
						LOCK.unlock();
					}
				}
			}
		}
	}
}
