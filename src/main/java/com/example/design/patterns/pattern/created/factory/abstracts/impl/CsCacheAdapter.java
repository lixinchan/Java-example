package com.example.design.patterns.pattern.created.factory.abstracts.impl;

import com.example.design.patterns.pattern.created.factory.abstracts.CacheAdapter;

import java.util.concurrent.TimeUnit;

/**
 * @author clx
 */
public class CsCacheAdapter implements CacheAdapter {
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
