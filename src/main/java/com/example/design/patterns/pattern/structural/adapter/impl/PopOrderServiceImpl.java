package com.example.design.patterns.pattern.structural.adapter.impl;

import com.example.design.patterns.pattern.structural.adapter.OrderAdapterService;
import com.example.design.patterns.pattern.structural.adapter.PopOrderService;

/**
 * @author clx
 */
public class PopOrderServiceImpl implements OrderAdapterService {

	private final PopOrderService popOrderService;

	public PopOrderServiceImpl(PopOrderService popOrderService) {
		this.popOrderService = popOrderService;
	}

	@Override
	public boolean isFirstOrder(String uid) {
		return this.popOrderService.isFirstOrder(uid);
	}
}
