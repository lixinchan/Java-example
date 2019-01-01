package org.example.design.patterns.pattern.created;

/**
 * singleton pattern
 * 
 * @author clx 2018/10/21
 */
public class Singleton {

}

/**
 * hungry singleton
 */
class HungrySingleton {

	/**
	 * instance
	 */
	private static HungrySingleton instance = new HungrySingleton();

	private HungrySingleton() {

	}

	/**
	 * get instance
	 * 
	 * @return
	 */
	public static HungrySingleton getInstance() {
		return instance;
	}
}

/**
 * lazy singleton
 */
class LazySingleton {

	/**
	 * instance
	 */
	private static volatile LazySingleton instance = null;

	private LazySingleton() {

	}

	/**
	 * get instance
	 * 
	 * @return
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
