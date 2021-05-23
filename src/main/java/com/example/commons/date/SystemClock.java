package com.example.commons.date;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author clx
 */
public class SystemClock {
	/**
	 * 时钟更新间隔，单位ms
	 */
	private final long period;
	/**
	 * 当前时刻毫秒数
	 */
	private volatile long currentTimeMills;

	/**
	 * construct
	 *
	 * @param period time period
	 */
	public SystemClock(long period) {
		this.period = period;
		this.currentTimeMills = System.currentTimeMillis();
		this.schedulingUpdateClock();
	}

	/**
	 * schedule update clock
	 */
	private void schedulingUpdateClock() {
		ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor(t -> {
			Thread thread = new Thread(t, "System_Clock");
			thread.setDaemon(true);
			return thread;
		});
		scheduledExecutorService.scheduleAtFixedRate(() -> this.currentTimeMills = System.currentTimeMillis(),
				this.period, this.period, TimeUnit.MICROSECONDS);
	}

	/**
	 * return current timeMills
	 *
	 * @return current mills
	 */
	private long getCurrentTimeMills() {
		return this.currentTimeMills;
	}

	/**
	 * static instance holder
	 */
	private static class InstanceHolder {
		public static final SystemClock INSTANCE = new SystemClock(1);
	}

	/**
	 * current timeMills
	 *
	 * @return mills
	 */
	public static long currTimeMills() {
		return InstanceHolder.INSTANCE.getCurrentTimeMills();
	}
}
