package com.example.core.java.thread;

/**
 * @author clx
 */
public class TestThreadStatus {

	public static void main(String[] args) {
		try {
			new TestThreadStatus().mainThread();
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}

	public void mainThread() throws InterruptedException {
		Thread a = new Thread(new Runnable() {
			@Override
			public void run() {
				testMethod();
			}
		}, "a");

		Thread b = new Thread(new Runnable() {
			@Override
			public void run() {
				testMethod();
			}
		}, "b");

		a.start();
//		Thread.sleep(1000L); // thread b blocked
//		a.join(); // thread b waiting
		a.join(1000L);
		b.start();
		System.out.println(a.getName() + "->" + a.getState());
		System.out.println(b.getName() + "->" + b.getState());
	}

	private synchronized void testMethod() {
		try {
			Thread.sleep(2000L);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
}
