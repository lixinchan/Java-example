package com.example.design.patterns.pattern.created.singleton;

/**
 * @author clx
 */
public class HungrySingleton {

	/**
	 * instance
	 */
	private static final HungrySingleton INSTANCE = new HungrySingleton();

	private HungrySingleton() {
	}

	/**
	 * get instance
	 *
	 * @return {@link HungrySingleton}
	 */
	public static HungrySingleton getInstance() {
		return INSTANCE;
	}
}
