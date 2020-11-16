package com.example.commons.threadpool;

import java.util.Objects;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author clx
 */
public class BaseThreadPoolConfig {

	/**
	 * default ThreadFactory
	 */
	public static class DefaultThreadFactory implements ThreadFactory {

		/**
		 * pool number
		 */
		private static final AtomicInteger POOL_NUMBER = new AtomicInteger(1);
		/**
		 * thread number
		 */
		private static final AtomicInteger THREAD_NUMBER = new AtomicInteger(1);
		/**
		 * thread group
		 */
		private final ThreadGroup threadGroup;
		/**
		 * thread pool name prefix
		 */
		private final String namePrefix;

		public DefaultThreadFactory(String threadPoolName) {
			SecurityManager securityManager = System.getSecurityManager();
			threadGroup = Objects.nonNull(securityManager) ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
			namePrefix = threadPoolName + "-" + POOL_NUMBER.getAndIncrement() + "-thread-";
		}

		@Override
		public Thread newThread(Runnable r) {
			Thread t = new Thread(threadGroup, r, namePrefix + THREAD_NUMBER.getAndIncrement(), 0);
			if (t.isDaemon()) {
				t.setDaemon(false);
			}
			if (t.getPriority() != Thread.NORM_PRIORITY) {
				t.setPriority(Thread.NORM_PRIORITY);
			}
			return t;
		}
	}

	/**
	 * caller run policy
	 */
	public static class CallerRunPolicy implements RejectedExecutionHandler {

		public CallerRunPolicy() {
		}

		@Override
		public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
			if (!executor.isShutdown()) {
				r.run();
			}
		}
	}
}
