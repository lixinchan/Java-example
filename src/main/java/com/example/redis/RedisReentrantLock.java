package com.example.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.params.SetParams;

import java.util.HashMap;
import java.util.Map;

/**
 * redis reentrant lock
 *
 * @author clx 2019-06-06
 */
public class RedisReentrantLock {

	private ThreadLocal<Map<String, Integer>> locker = new ThreadLocal<>();
	private Jedis jedis;

	public RedisReentrantLock(Jedis jedis) {
		this.jedis = jedis;
	}

	/**
	 * lock
	 *
	 * @param key
	 * @return
	 */
	public boolean lock(String key) {
		Map<String, Integer> refs = this.currLocks();
		Integer refCount = refs.get(key);
		if (refCount != null) {
			refs.put(key, refCount + 1);
			return true;
		}
		if (!this.setLock(key)) {
			return false;
		}
		refs.put(key, 1);
		return true;
	}

	/**
	 * unlock
	 *
	 * @param key
	 * @return
	 */
	public boolean unLock(String key) {
		Map<String, Integer> refs = this.currLocks();
		Integer refCount = refs.get(key);
		if (refCount == null) {
			return false;
		}
		refCount -= 1;
		if (refCount > 0) {
			refs.put(key, refCount);
		} else {
			refs.remove(key);
			this.delLock(key);
		}
		return true;
	}

	private boolean setLock(String key) {
		SetParams params = new SetParams();
		params.ex(5).nx();
		return this.jedis.set(key, "", params) != null;
	}

	private void delLock(String key) {
		this.jedis.del(key);
	}

	private Map<String, Integer> currLocks() {
		Map<String, Integer> refs = this.locker.get();
		if (refs != null) {
			return refs;
		}
		locker.set(new HashMap<>(1));
		return locker.get();
	}
}
