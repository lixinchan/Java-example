package com.example.design.patterns.pattern.structural.bridge.channel;

import java.math.BigDecimal;

import com.example.design.patterns.pattern.structural.bridge.mode.PayModeService;

/**
 * @author clx
 */
public abstract class AbstractPayChannel {

	protected PayModeService payModeService;

	protected AbstractPayChannel(PayModeService payModeService) {
		this.payModeService = payModeService;
	}

	/**
	 * pay transfer
	 *
	 * @param uid     userId
	 * @param tradeId tradeId
	 * @param amount  transfer amount
	 * @return pay result
	 */
	public abstract String transfer(String uid, String tradeId, BigDecimal amount);
}
