package com.example.effective.java.chapter.tenth;

import java.util.concurrent.TimeUnit;

/**
 * @author clx 2018/4/2.
 */
public class StopThread {
	private volatile boolean stopRequested;

	public static void main(String[] args) {
		try {
			new StopThread().test();
		} catch (Exception ex) {
			ex.getMessage();
		}
	}

	private void test() throws InterruptedException {
		Thread backgroundThread = new Thread(new Runnable() {
			@Override
			public void run() {
				int i = 0;
				while (!stopRequested) {
					i++;
				}
			}
		});
		backgroundThread.start();
		TimeUnit.SECONDS.sleep(1);
		stopRequested = true;
	}
}
