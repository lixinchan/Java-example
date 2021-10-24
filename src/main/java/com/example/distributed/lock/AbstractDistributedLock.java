package com.example.distributed.lock;

import lombok.extern.slf4j.Slf4j;

import java.io.Closeable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * abstract distributed lock
 *
 * @author clx
 */
@Slf4j
public abstract class AbstractDistributedLock implements Lock, Closeable {

	/**
	 * lock flag
	 */
	protected final AtomicBoolean locked = new AtomicBoolean(false);
	/**
	 * rr time, /s
	 */
	protected long intervalTime = 10;
	/**
	 * lock max survival time
	 */
	protected long survivalMills = 3600000L;

	@Override
	public void lock() {
		while (this.survivalMills > 0) {
			try {
				if (tryLock()) {
					return;
				}
				Thread.sleep(this.intervalTime);
				this.survivalMills -= this.intervalTime;
			} catch (InterruptedException e) {
				log.error("");
				Thread.currentThread().interrupt();
			}
		}
	}

	/**
	 * try lock
	 *
	 * @param time lock time
	 * @param unit lock time unit
	 * @return lock status
	 */
	@Override
	public boolean tryLock(long time, TimeUnit unit) {
		this.survivalMills = TimeUnit.MICROSECONDS.convert(time, unit);
		while (this.survivalMills > 0) {
			try {
				if (this.tryLock()) {
					return true;
				}
				Thread.sleep(this.intervalTime);
				this.survivalMills -= this.intervalTime;
			} catch (InterruptedException e) {
				log.error("");
				Thread.currentThread().interrupt();
			}
		}
		return false;
	}

	@Override
	public void lockInterruptibly() {
		this.lock();
	}

	@Override
	public Condition newCondition() {
		throw new UnsupportedClassVersionError();
	}

	@Override
	public void close() {
		if (locked.get()) {
			unlock();
		}
	}
}
