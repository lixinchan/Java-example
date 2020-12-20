package com.example.commons.threadpool;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
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

	public BaseThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue,
	                              ThreadFactory threadFactory, RejectedExecutionHandler handler) {
		super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, new ThreadFactoryBuilder().setThreadFactory(threadFactory)
				.setUncaughtExceptionHandler((t, e) -> {
					// TODO: log
					System.out.printf("Thread name:%s, err:%s", t.getName(), e);
				}).build(), handler);
	}

	@Override
	protected void beforeExecute(Thread t, Runnable r) {
		super.beforeExecute(t, r);
	}

	@Override
	protected void afterExecute(Runnable r, Throwable t) {
		super.afterExecute(r, t);
		if (Objects.isNull(t) && r instanceof Future<?>) {
			try {
				Future<?> future = (Future<?>) r;
				future.get();
			} catch (CancellationException ce) {
				t = ce;
			} catch (ExecutionException ee) {
				t = ee.getCause();
			} catch (InterruptedException ie) {
				Thread.currentThread().interrupt();
			}
		}
		if (Objects.nonNull(t)) {
			// TODO: log
			System.out.println(t);
		}
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
