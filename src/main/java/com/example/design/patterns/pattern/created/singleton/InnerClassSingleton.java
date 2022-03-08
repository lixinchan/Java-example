package com.example.design.patterns.pattern.created.singleton;

/**
 * @author clx
 */
public class InnerClassSingleton {

	/**
	 * get instance
	 *
	 * @return {@link InnerClassSingleton}
	 */
	public static InnerClassSingleton getInstance() {
		return SingletonHolder.INSTANCE;
	}

	private InnerClassSingleton() {
	}

	/**
	 * inner static class
	 */
	private static class SingletonHolder {
		private static final InnerClassSingleton INSTANCE = new InnerClassSingleton();
	}
}
