package com.example.design.patterns.pattern.created.factory.method;

import com.example.design.patterns.pattern.created.factory.method.impl.CardCommodityServiceImpl;
import com.example.design.patterns.pattern.created.factory.method.impl.CouponCommodityServiceImpl;
import com.google.common.base.Preconditions;

import java.util.Objects;

/**
 * 工厂实现
 *
 * @author clx
 */
public class StoreFactoryImpl implements StoreFactory {

	@Override
	public CommodityService getCommodity(Integer commodityType) {
		Preconditions.checkArgument(Objects.nonNull(commodityType));
		CommodityService commodityService = null;
		switch (commodityType) {
			case 1:
				commodityService = new CouponCommodityServiceImpl();
				break;
			case 2:
				commodityService = new CardCommodityServiceImpl();
				break;
			default:
				break;
		}
		return commodityService;
	}
}
