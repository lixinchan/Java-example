package com.example.core.java.thread.threadcreate;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author clx 3/5/2018
 */
public class CallableThread implements Callable {

	public static void main(String[] args) throws Exception {
		ExecutorService pool = Executors.newFixedThreadPool(2);

		List<Future> list = new ArrayList<>();
		for (int idx = 0; idx < 2; idx++) {
			Callable callable = new CallableThread();
			Future future = pool.submit(callable);
			list.add(future);
		}

		pool.shutdown();

		for (Future future : list) {
			System.out.println(future.get().toString());
		}
	}

	@Override
	public Object call() throws Exception {
		return "Running...";
	}
}
