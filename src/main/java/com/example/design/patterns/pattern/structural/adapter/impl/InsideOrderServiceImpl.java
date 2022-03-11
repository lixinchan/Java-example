package com.example.design.patterns.pattern.structural.adapter.impl;

import com.example.design.patterns.pattern.structural.adapter.OrderAdapterService;
import com.example.design.patterns.pattern.structural.adapter.OrderService;

/**
 * @author clx
 */
public class InsideOrderServiceImpl implements OrderAdapterService {

	private final OrderService orderService;

	public InsideOrderServiceImpl(OrderService orderService) {
		this.orderService = orderService;
	}

	@Override
	public boolean isFirstOrder(String uid) {
		return this.orderService.queryUserOrderCount(uid) < 1;
	}
}
