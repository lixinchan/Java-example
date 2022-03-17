package com.example.design.patterns.pattern.structural.decorator;

/**
 * @author clx
 */
public abstract class SsoDecorator implements HandlerInterceptor {

	private final HandlerInterceptor handlerInterceptor;

	protected SsoDecorator(HandlerInterceptor handlerInterceptor) {
		this.handlerInterceptor = handlerInterceptor;
	}

	@Override
	public boolean preHandle(String request, String response, Object handle) {
		return this.handlerInterceptor.preHandle(request, response, handle);
	}
}
