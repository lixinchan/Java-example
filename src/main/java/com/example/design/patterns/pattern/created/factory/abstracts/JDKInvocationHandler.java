package com.example.design.patterns.pattern.created.factory.abstracts;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author clx
 */
public class JDKInvocationHandler implements InvocationHandler {

	private final CacheAdapter cacheAdapter;

	public JDKInvocationHandler(CacheAdapter cacheAdapter) {
		this.cacheAdapter = cacheAdapter;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		return cacheAdapter.getClass().getMethod(method.getName(), args.getClass().getDeclaredClasses())
				.invoke(cacheAdapter, args);
	}
}
