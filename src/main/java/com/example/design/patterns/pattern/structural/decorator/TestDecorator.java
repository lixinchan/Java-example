package com.example.design.patterns.pattern.structural.decorator;

import com.example.commons.log.LogUtils;

/**
 * @author clx
 */
public class TestDecorator {

	public static void main(String[] args) {
		LoginDecorator loginDecorator = new LoginDecorator(new SsoInterceptor());
		boolean result = loginDecorator.preHandle("lsuccessxiaoming", "xxx", "l");
		LogUtils.info("Sso auth result={}", result);
	}
}
