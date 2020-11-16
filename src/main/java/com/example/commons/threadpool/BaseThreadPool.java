package com.example.commons.threadpool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * base ThreadPool
 *
 * @author clx
 */
public class BaseThreadPool {

	public Executor executor() {
		int corePoolSize = 0;
		int maximumPoolSize = 0;
		long keepAliveTime = 0;
		BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<>(128);
		String threadPoolName = "";
		return new BaseThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, TimeUnit.MINUTES, workQueue,
				new BaseThreadPoolConfig.DefaultThreadFactory(threadPoolName), new BaseThreadPoolConfig.CallerRunPolicy());
	}
}
