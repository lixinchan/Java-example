package com.example.commons.threadpool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * s ThreadPoolExecutor
 *
 * @author clx
 */
public class BaseThreadPoolExecutor extends ThreadPoolExecutor {

	public BaseThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory, RejectedExecutionHandler handler) {
		super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler);
	}

	@Override
	protected void beforeExecute(Thread t, Runnable r) {
		super.beforeExecute(t, r);
	}

	@Override
	protected void afterExecute(Runnable r, Throwable t) {
		super.afterExecute(r, t);
	}

	@Override
	public Future<?> submit(Runnable task) {
		return super.submit(task);
	}

	@Override
	public <T> Future<T> submit(Runnable task, T result) {
		return super.submit(task, result);
	}

	@Override
	public <T> Future<T> submit(Callable<T> task) {
		return super.submit(task);
	}

	@Override
	public void execute(Runnable command) {
		super.execute(command);
	}
}
