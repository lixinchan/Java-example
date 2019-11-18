package com.example.redis;

import com.google.common.reflect.TypeResolver;
import com.google.common.reflect.TypeToken;
import jdk.internal.org.objectweb.asm.TypeReference;
import redis.clients.jedis.Jedis;

import java.lang.reflect.Type;

/**
 * @author clx 2019-06-19
 */
public class DelayQueue<T> {

	private Jedis jedis;
	private String queueKey;
	private final Type taskType = new TypeToken<TaskItem<T>>(){}.getType();

	public DelayQueue(Jedis jedis, String queueKey) {
		this.jedis = jedis;
		this.queueKey = queueKey;
	}


	static class TaskItem<T> {
		public String id;
		public T message;
	}
}
