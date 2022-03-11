package com.example.design.patterns.pattern.structural.adapter;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.example.commons.log.LogUtils;

/**
 * mq adapter
 *
 * @author clx
 */
public class MqAdapter {

	/**
	 * filter mq with link
	 *
	 * @param mqBody  mq
	 * @param linkMap link
	 * @return {@link CommonMqBody}
	 */
	public static CommonMqBody filterMqBody(String mqBody, Map<String, String> linkMap) {
		try {
			return MqAdapter.filterMqBody(JSON.parseObject(mqBody, Map.class), linkMap);
		} catch (InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
			LogUtils.error("error={}", e.toString());
			return new CommonMqBody();
		}
	}

	/**
	 * filter mq with link
	 * 
	 * @param mqMap   mq
	 * @param linkMap link
	 * @return {@link CommonMqBody}
	 */
	public static CommonMqBody filterMqBody(Map<Object, Object> mqMap, Map<String, String> linkMap)
			throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
		CommonMqBody mqBody = new CommonMqBody();
		for (Map.Entry<String, String> entry : linkMap.entrySet()) {
			Object val = mqMap.get(entry.getValue());
			CommonMqBody.class
					.getMethod("set" + entry.getKey().substring(0, 1).toUpperCase() + entry.getKey().substring(1),
							String.class)
					.invoke(mqBody, val.toString());
		}
		return mqBody;
	}
}
