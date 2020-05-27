package com.example.core.java.thread;

import java.util.stream.IntStream;

/**
 * @author clx
 */
public class TestThreadPriority {

	public static class ThreadPriority implements Runnable {

		@Override
		public void run() {
			System.out.println(String.format("current thread: %s, priority: %d", Thread.currentThread().getName(),
					Thread.currentThread().getPriority()));
		}
	}

	public static void main(String[] args) {
		Thread a = new Thread();
		System.out.println("default priority:" + a.getPriority());

		Thread b = new Thread();
		b.setPriority(1);
		System.out.println("priority:" + b.getPriority());

		IntStream.range(1, 10).forEach(idx -> {
			Thread t = new Thread(new ThreadPriority());
			t.setPriority(idx);
			t.start();
		});
	}
}
