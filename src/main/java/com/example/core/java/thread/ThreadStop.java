package com.example.core.java.thread;


import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * @author clx
 */
public class ThreadStop {

	public static void main(String[] args) {
		final long waitTime = 1000;
		final long awaitTime = 2000;
		ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("stop-pool-%d").build();
		ExecutorService pool = new ThreadPoolExecutor(2, 5, 0L, TimeUnit.SECONDS,
				new LinkedBlockingQueue<>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());

		Runnable taskOne = () -> {
			try {
				System.out.println("task one start...");
				Thread.sleep(8 * waitTime);
				System.out.println("task one stop...");
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		};

		Runnable taskTwo = () -> {
			try {
				System.out.println("task two start...");
				Thread.sleep(2 * waitTime);
				System.out.println("task two stop...");
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		};

		pool.execute(taskOne);
		for (int idx = 0; idx < 10; idx++) {
			pool.execute(taskTwo);
		}

		try {
			pool.shutdown();
			if (!pool.awaitTermination(awaitTime, TimeUnit.MILLISECONDS)) {
				pool.shutdownNow();
			}
		} catch (InterruptedException e) {
			System.out.println("await termination err:" + e.getMessage());
			pool.shutdownNow();
		}
	}
}
