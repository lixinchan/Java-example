package com.example.design.patterns.pattern.created.factory.method;

/**
 * 抽象工厂
 *
 * @author clx
 */
public interface StoreFactory {

	/**
	 * commodity service factory
	 *
	 * @param commodityType commodity type
	 * @return {@link CommodityService}
	 */
	CommodityService getCommodity(Integer commodityType);
}
