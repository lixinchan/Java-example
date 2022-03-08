package com.example.design.patterns.pattern.created.singleton;

import com.example.commons.log.LogUtils;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author clx
 */
public class AtomicRefSingleton {

	/**
	 * AtomicReference
	 */
	private static final AtomicReference<AtomicRefSingleton> ATOMIC_REF_INSTANCE = new AtomicReference<>();

	private AtomicRefSingleton() {
	}

	/**
	 * get instance
	 *
	 * @return {@link AtomicRefSingleton}
	 */
	public static AtomicRefSingleton getInstance() {
		for (; ; ) {
			AtomicRefSingleton instance = ATOMIC_REF_INSTANCE.get();
			if (Objects.nonNull(instance)) {
				return instance;
			}
			ATOMIC_REF_INSTANCE.compareAndSet(null, new AtomicRefSingleton());
			return ATOMIC_REF_INSTANCE.get();
		}
	}

	public static void main(String[] args) {
		LogUtils.info("instance:{}", AtomicRefSingleton.getInstance());
		LogUtils.info("instance:{}", AtomicRefSingleton.getInstance());
	}
}
