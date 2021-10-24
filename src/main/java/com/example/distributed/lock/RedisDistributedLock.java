package com.example.distributed.lock;

import com.example.commons.log.LogUtils;
import org.apache.commons.io.IOUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.params.SetParams;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Objects;
import java.util.UUID;

/**
 * redis distributed lock
 *
 * @author clx
 */
public class RedisDistributedLock extends AbstractDistributedLock {

	private static final String OK = "OK";

	private final Jedis jedis;

	private static String script;

	private final String key;

	private final String value;

	private static final String EXPECTED = ", expectedValue=";

	static {
		try {
			script = IOUtils.toString(Objects.requireNonNull(RedisDistributedLock.class.getResourceAsStream("/scripts/redis_unlock.lua")),
					Charset.defaultCharset());
		} catch (IOException e) {
			LogUtils.error("");
		}
	}

	public RedisDistributedLock(String key) {
		this(new Jedis(), key);
	}

	public RedisDistributedLock(String key, long survivalMills) {
		this("jedisBeanName", key, survivalMills);
	}

	public RedisDistributedLock(Jedis jedis, String key) {
		this.jedis = jedis;
		this.key = key;
		this.value = UUID.randomUUID().toString().replace("-", "");
	}

	public RedisDistributedLock(String jedisBeanName, String key, long survivalMills) {
		this(new Jedis(), key);
	}

	@Override
	public boolean tryLock() {
		SetParams params = new SetParams().nx().px(this.survivalMills);
		String result = this.jedis.set(key, value, params);
		boolean lockSuccess = OK.equals(result);
		if (lockSuccess) {
			this.locked.set(true);
		}
		return lockSuccess;
	}

	@Override
	public void unlock() {
		Long result;
		try {
			result = (Long) this.jedis.eval(script, 1, key, value);
		} catch (Exception e) {
			LogUtils.error("");
			throw new IllegalStateException("", e);
		}
		if (Objects.isNull(result)) {
			LogUtils.error("");
			throw new IllegalStateException("");
		}
		if (result != 1) {
			LogUtils.error("");
			throw new IllegalStateException("");
		}
		this.locked.set(false);
	}
}
