package com.example.design.patterns.pattern.structural.decorator;

import org.apache.commons.lang3.StringUtils;

/**
 * @author clx
 */
public class SsoInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(String request, String response, Object handle) {
		String authTicket = request.substring(1, 8);
		return StringUtils.equals(authTicket, "success");
	}
}
