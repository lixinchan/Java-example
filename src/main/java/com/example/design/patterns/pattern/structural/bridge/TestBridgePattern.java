package com.example.design.patterns.pattern.structural.bridge;

import java.math.BigDecimal;

import com.example.design.patterns.pattern.structural.bridge.channel.AbstractPayChannel;
import com.example.design.patterns.pattern.structural.bridge.channel.AlipayChannel;
import com.example.design.patterns.pattern.structural.bridge.channel.WeChatPayChannel;
import com.example.design.patterns.pattern.structural.bridge.mode.PayCypherServiceImpl;
import com.example.design.patterns.pattern.structural.bridge.mode.PayFingerprintServiceImpl;

/**
 * @author clx
 */
public class TestBridgePattern {

	public static void main(String[] args) {
		AbstractPayChannel alipay = new AlipayChannel(new PayFingerprintServiceImpl());
		alipay.transfer("1221", "12345", new BigDecimal(10));
		AbstractPayChannel wxPay = new WeChatPayChannel(new PayCypherServiceImpl());
		wxPay.transfer("1212", "54321", new BigDecimal(5));
	}
}
