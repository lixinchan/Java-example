package org.example.core.java.thread.threadcreate;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author clx 3/5/2018
 */
public class BaseedThreadPool {

	public static void main(String[] args) {
		ExecutorService pool = Executors.newFixedThreadPool(8);
		int idx = 0;
		while (idx < 10) {
			pool.execute(() -> {
				System.out.println(Thread.currentThread().getName() + " Running...");
				try {
					Thread.sleep(3);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
			});
			idx++;
		}
		pool.shutdown();
	}
}
