package com.example.redis;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import redis.clients.jedis.Jedis;

import java.lang.reflect.Type;
import java.util.List;
import java.util.UUID;

/**
 * @author clx 2019-06-19
 */
public class DelayQueue<T> {

	private Jedis jedis;
	private String queueKey;
	private final Type taskType = new TypeToken<TaskItem<T>>() {
	}.getType();
	private Gson gson = new GsonBuilder().create();

	public DelayQueue(Jedis jedis, String queueKey) {
		this.jedis = jedis;
		this.queueKey = queueKey;
	}

	static class TaskItem<T> {
		public String id;
		public T message;
	}

	public void delay(T message) {
		TaskItem<T> taskItem = new TaskItem<>();
		taskItem.id = UUID.randomUUID().toString();
		taskItem.message = message;
		String content = gson.toJson(taskItem);
		jedis.zadd(queueKey, System.currentTimeMillis(), content);
	}

	public void loop() {
		while (!Thread.interrupted()) {
			List<String> values = jedis.zrangeByScore(queueKey, 0, System.currentTimeMillis(), 0, 1);
			if (values.isEmpty()) {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
					break;
				}
				continue;
			}
			String content = values.iterator().next();
			if (jedis.zrem(queueKey, content) > 0) {
				TaskItem<T> taskItem = gson.fromJson(content, taskType);
				this.handleMessage(taskItem.message);
			}
		}
	}

	/**
	 * handle message
	 *
	 * @param message
	 */
	private void handleMessage(T message) {
		System.out.println(message);
	}
}
