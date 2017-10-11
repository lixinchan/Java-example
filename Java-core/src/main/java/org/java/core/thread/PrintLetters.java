package org.java.core.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author clx 2017年9月18日 上午1:36:21
 */
public class PrintLetters {

	/**
	 * wrong example
	 * 
	 * @throws InterruptedException
	 */
	public void exec() throws InterruptedException {
		final char[] letters = { 'a', 'b', 'c' };
		int count = 10;
		for (int i = 0; i < count; i++) {
			for (int k = 0; k < letters.length; k++) {
				final int idx = k;
				Thread thread = new Thread(new Runnable() {

					@Override
					public void run() {
						System.out.println(Thread.currentThread().getName() + "---" + letters[idx]);
					}
				});
				thread.start();
				thread.join();
			}
		}
	}

	private static int state = 0;

	public void execute() {
		final Lock lock = new ReentrantLock();
		Thread ta = new Thread(new Runnable() {

			@Override
			public void run() {
				while (state <= 27) {
					lock.lock();
					if (state % 3 == 0) {
						System.out.println(state + ":" + Thread.currentThread().getName() + "---a");
						state++;
					}
					lock.unlock();
				}
			}
		});
		Thread tb = new Thread(new Runnable() {

			@Override
			public void run() {
				while (state <= 27) {
					lock.lock();
					if (state % 3 == 1) {
						System.out.println(state + ":" + Thread.currentThread().getName() + "---b");
						state++;
					}
					lock.unlock();
				}
			}
		});
		Thread tc = new Thread(new Runnable() {

			@Override
			public void run() {
				while (state <= 27) {
					lock.lock();
					if (state % 3 == 2) {
						System.out.println(state + ":" + Thread.currentThread().getName() + "---c");
						state++;
					}
					lock.unlock();
				}
			}
		});

		ta.start();
		tb.start();
		tc.start();
	}

	public static void main(String[] args) {
		// try {
		// new PrintLetters().exec();
		// } catch (InterruptedException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// new PrintLetters().execute();
		int idx = 5;
		int count = 0;
		while (idx > 0) {
			idx = idx & (idx - 1);
			count++;
		}
		System.out.println(count);

	}
}
