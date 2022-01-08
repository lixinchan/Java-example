package com.example.design.patterns.pattern.created.factory.method;

/**
 * 抽象奖品接口
 *
 * @author clx
 */
public interface CommodityService {

	/**
	 * lottery draw commodity
	 *
	 * @param userId    user id
	 * @param lotteryId lottery commodity id
	 * @param bizType   biz type
	 */
	void lotteryDraw(String userId, String lotteryId, Integer bizType);
}
