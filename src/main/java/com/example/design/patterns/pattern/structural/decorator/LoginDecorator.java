package com.example.design.patterns.pattern.structural.decorator;

import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.lang3.StringUtils;

/**
 * @author clx
 */
public class LoginDecorator extends SsoDecorator {

	private static final ConcurrentHashMap<String, String> loginGateway = new ConcurrentHashMap<>();

	static {
		loginGateway.put("xiaoming", "queryUserAuth");
		loginGateway.put("xiaoliu", "queryUserAuth");
	}

	public LoginDecorator(HandlerInterceptor handlerInterceptor) {
		super(handlerInterceptor);
	}

	@Override
	public boolean preHandle(String request, String response, Object handle) {
		boolean success = super.preHandle(request, response, handle);
		if (!success) {
			return false;
		}
		String userId = request.substring(8);
		String filterMethod = loginGateway.get(userId);
		return StringUtils.equals("queryUserAuth", filterMethod);
	}
}
