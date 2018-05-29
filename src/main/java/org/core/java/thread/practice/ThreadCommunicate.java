package org.core.java.thread.practice;

import java.util.concurrent.*;

/**
 * @author clx 2018/5/24
 */
public class ThreadCommunicate {

	public static void main(String[] args) {
		// demo();
		// demo1();
		demo2();
		// demo3();
		// demo4();
	}

	private static void demo4() {
		int worker = 3;
		CyclicBarrier cyclicBarrier = new CyclicBarrier(worker);
		for (char threadName = 'A'; threadName <= 'C'; threadName++) {
			String name = String.valueOf(threadName);
			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException ex) {
						ex.printStackTrace();
					}
					try {
						System.out.println(name + " is preparing.");
						cyclicBarrier.await();
						System.out.println(name + " is prepared.");
					} catch (InterruptedException e) {
						e.printStackTrace();
					} catch (BrokenBarrierException e) {
						e.printStackTrace();
					}
				}
			}).start();
		}
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("D is working.");
			}
		}).start();
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

		synchronized (ThreadCommunicate.class) {
			a.start();
			try {
				ThreadCommunicate.class.wait(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		synchronized (ThreadCommunicate.class) {
			ThreadCommunicate.class.notify();
			b.start();
		}

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
