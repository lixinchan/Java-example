package com.example.design.patterns.pattern.created.factory.method.impl;

import com.example.commons.log.LogUtils;
import com.example.design.patterns.pattern.created.factory.method.CommodityService;

/**
 * card commodity
 *
 * @author clx
 */
public class CardCommodityServiceImpl implements CommodityService {

	@Override
	public void lotteryDraw(String userId, String lotteryId, Integer bizType) {
		LogUtils.info("CardCommodityService: userId={}, lotteryId={}, bizType={}", userId, lotteryId, bizType);
	}
}
