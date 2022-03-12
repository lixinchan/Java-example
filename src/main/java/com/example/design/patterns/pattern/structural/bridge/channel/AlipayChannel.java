package com.example.design.patterns.pattern.structural.bridge.channel;

import java.math.BigDecimal;

import com.example.commons.log.LogUtils;
import com.example.design.patterns.pattern.structural.bridge.mode.PayModeService;

/**
 * @author clx
 */
public class AlipayChannel extends AbstractPayChannel {

	public AlipayChannel(PayModeService payModeService) {
		super(payModeService);
	}

	@Override
	public String transfer(String uid, String tradeId, BigDecimal amount) {
		LogUtils.info("Alipay begin transfer: uid={}, tradeId={}, amount={}", uid, tradeId, amount);
		boolean isSecurity = this.payModeService.security(uid);
		if (isSecurity) {
			LogUtils.info("Alipay transfer succeed: uid={}, tradeId={}, amount={}", uid, tradeId, amount);
			return "succeed";
		}
		LogUtils.info("Alipay transfer failed: uid={}, tradeId={}, amount={}", uid, tradeId, amount);
		return "failed";
	}
}
