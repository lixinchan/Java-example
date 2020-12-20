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

	/**
	 * template threadPool
	 *
	 * @return
	 */
	public Executor executor() {
		int corePoolSize = Runtime.getRuntime().availableProcessors();
		int maximumPoolSize = corePoolSize * 2;
		long keepAliveTime = 60;
		BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<>(128);
		String threadPoolName = "templateThreadPool";
		return new BaseThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, TimeUnit.SECONDS, workQueue,
				new BaseThreadPoolConfig.DefaultThreadFactory(threadPoolName), new BaseThreadPoolConfig.CallerRunPolicy());
	}
}
