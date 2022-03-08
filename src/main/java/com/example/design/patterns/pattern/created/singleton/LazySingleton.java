package com.example.design.patterns.pattern.created.singleton;

/**
 * @author clx
 */
public class LazySingleton {

	/**
	 * instance
	 */
	private static volatile LazySingleton instance = null;

	private LazySingleton() {
	}

	/**
	 * get instance
	 *
	 * @return {@link LazySingleton}
	 */
	public static LazySingleton getInstance() {
		if (instance == null) {
			synchronized (LazySingleton.class) {
				if (instance == null) {
					instance = new LazySingleton();
				}
			}
		}
		return instance;
	}
}
