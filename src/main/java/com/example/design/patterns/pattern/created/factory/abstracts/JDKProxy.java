package com.example.design.patterns.pattern.created.factory.abstracts;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import com.example.design.patterns.pattern.created.factory.abstracts.impl.BjCacheAdapter;
import com.example.design.patterns.pattern.created.factory.abstracts.impl.CacheServiceImpl;
import com.example.design.patterns.pattern.created.factory.abstracts.impl.CsCacheAdapter;

/**
 * @author clx
 */
public class JDKProxy {

	/**
	 * get proxy
	 *
	 * @param clazz        {@link Class}
	 * @param cacheAdapter {@link CacheAdapter}
	 * @param <T>          T
	 * @return T
	 */
	public static <T> T getProxy(Class<T> clazz, CacheAdapter cacheAdapter) {
		InvocationHandler invocationHandler = new JDKInvocationHandler(cacheAdapter);
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		Class<?>[] interfaces = clazz.getInterfaces();
		return (T) Proxy.newProxyInstance(classLoader, new Class[] { interfaces[0] }, invocationHandler);
	}

	public static void main(String[] args) {
		CacheService csCacheService = JDKProxy.getProxy(CacheServiceImpl.class, new CsCacheAdapter());
		csCacheService.get("");
		CacheService bjCacheService = JDKProxy.getProxy(CacheServiceImpl.class, new BjCacheAdapter());
		bjCacheService.get("");
	}
}
