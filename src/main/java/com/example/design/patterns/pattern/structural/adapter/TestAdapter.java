package com.example.design.patterns.pattern.structural.adapter;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;

/**
 * @author clx
 */
public class TestAdapter {

	public static void main(String[] args) {
		OrderMq orderMq = new OrderMq();
		orderMq.setUid("1212");
		orderMq.setSkuId("121212");
		orderMq.setOrderId("12121212");
		orderMq.setOrderTime(new Date());

		Map<String, String> linkMap = new HashMap<>();
		linkMap.put("userId", "uid");
		linkMap.put("bizId", "orderId");
		linkMap.put("bizTime", "orderTime");
		CommonMqBody mq = MqAdapter.filterMqBody(JSON.toJSONString(orderMq), linkMap);
		System.out.println("before:" + JSON.toJSONString(orderMq));
		System.out.println("after:" + JSON.toJSONString(mq));
	}
}
