package com.example.core.java.thread.threadcreate;

import java.util.concurrent.*;

/**
 * @author clx
 */
public class ThreadTask implements Callable<String> {
	@Override
	public String call() throws Exception {
		return "...";
	}

	public static void main(String[] args) {
		ExecutorService service = Executors.newCachedThreadPool();
		FutureTask<?> futureTask = new FutureTask<>(new ThreadTask());
		service.submit(futureTask);
		try {
			System.out.println(futureTask.get());
		} catch (InterruptedException | ExecutionException e) {

		}

	}
}
