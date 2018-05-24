package org.core.java.thread.practice;

import java.util.concurrent.CountDownLatch;

/**
 * @author clx 2018/5/24
 */
public class ThreadCommunicate {

	public static void main(String[] args) {
		// demo();
		// demo1();
		// demo2();
		demo3();
	}

	private static void demo3() {
		int worker = 3;
		CountDownLatch countDownLatch = new CountDownLatch(worker);
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("D is waiting for other thread.");
				try {
					countDownLatch.await();
					System.out.println("ALL DONE. D start.");
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
			}
		}).start();
		for (char threadName = 'A'; threadName <= 'C'; threadName++) {
			String name = String.valueOf(threadName);
			new Thread(new Runnable() {
				@Override
				public void run() {
					System.out.println(name + " is working");
					try {
						Thread.sleep(100);
					} catch (InterruptedException ex) {
						ex.printStackTrace();
					}
					System.out.println(name + " is done.");
					countDownLatch.countDown();
				}
			}).start();
		}
	}

	private static void demo2() {
		Object lock = new Object();
		Thread a = new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (lock) {
					System.out.println("A 1");
					try {
						lock.wait();
					} catch (InterruptedException ex) {
						ex.printStackTrace();
					}
					System.out.println("A 2");
					System.out.println("A 3");
				}
			}
		});
		Thread b = new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (lock) {
					System.out.println("B 1");
					System.out.println("B 2");
					System.out.println("B 3");
					lock.notify();
				}
			}
		});
	}

	private static void demo1() {
		Thread a = new Thread(new Runnable() {
			@Override
			public void run() {
				printNumber("A");
			}
		});
		Thread b = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("B 开始等待 A");
				try {
					a.join(0);
				} catch (InterruptedException ex) {

				}
				printNumber("B");
			}
		});
		a.start();
		b.start();
	}

	private static void demo() {
		Thread a = new Thread(new Runnable() {
			@Override
			public void run() {
				printNumber("A");
			}
		});
		Thread b = new Thread(new Runnable() {
			@Override
			public void run() {
				printNumber("B");
			}
		});
		a.start();
		b.start();
	}

	private static void printNumber(String threadName) {
		int idx = 0;
		while (idx++ < 3) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
			System.out.println(threadName + " print:" + idx);
		}
	}
}
