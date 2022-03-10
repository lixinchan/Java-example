package com.example.design.patterns.pattern.created.factory.abstracts.impl;

import java.util.concurrent.TimeUnit;

import com.example.design.patterns.pattern.created.factory.abstracts.CacheAdapter;

/**
 * @author clx
 */
public class BjCacheAdapter implements CacheAdapter {
	@Override
	public String get(String k) {
		return null;
	}

	@Override
	public Boolean set(String k, String val) {
		return null;
	}

	@Override
	public Boolean set(String k, String val, long timeout, TimeUnit timeUnit) {
		return null;
	}

	@Override
	public Integer del(String k) {
		return null;
	}
}
