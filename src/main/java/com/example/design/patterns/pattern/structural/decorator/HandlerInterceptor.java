package com.example.design.patterns.pattern.structural.decorator;

/**
 * @author clx
 */
public interface HandlerInterceptor {
	/**
	 * pre handle
	 *
	 * @param request  req
	 * @param response resp
	 * @param handle   handle
	 * @return bool
	 */
	boolean preHandle(String request, String response, Object handle);
}
