package com.example.design.patterns.pattern.created.factory.method.impl;

import com.example.commons.log.LogUtils;
import com.example.design.patterns.pattern.created.factory.method.CommodityService;

/**
 * coupon commodity
 *
 * @author clx
 */
public class CouponCommodityServiceImpl implements CommodityService {

	@Override
	public void lotteryDraw(String userId, String lotteryId, Integer bizType) {
		LogUtils.info("CouponCommodityService: userId={}, lotteryId={}, bizType={}", userId, lotteryId, bizType);
	}
}
