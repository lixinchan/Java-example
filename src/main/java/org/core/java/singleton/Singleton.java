package org.core.java.singleton;

/**
 * singleton Initialization on Demand Holder
 * 
 * @author clx at 2017年7月7日 下午1:39:08
 */
public class Singleton {

	/**
	 * 懒汉式，非线程安全实现
	 */
	/*
	 * private static Singleton lazyInstanceUnSafe = null;
	 * 
	 * private Singleton() { }
	 * 
	 * public static Singleton getInstance() { if (lazyInstanceUnSafe == null) {
	 * lazyInstanceUnSafe = new Singleton(); } return lazyInstanceUnSafe; }
	 */

	/**
	 * 懒汉式，线程安全实现
	 */
	/*
	 * private static Singleton lazyInstanceSafe;
	 * 
	 * private Singleton() { }
	 * 
	 * public static synchronized Singleton getInstance() { if (lazyInstanceSafe
	 * == null) { lazyInstanceSafe = new Singleton(); } return lazyInstanceSafe;
	 * }
	 */

	/**
	 * 饿汉式
	 */
	/*
	 * private static final Singleton hungryInstance = new Singleton();
	 * 
	 * private Singleton() { }
	 * 
	 * public static Singleton getInstatnce() { return hungryInstance; }
	 */

	/**
	 * double-checking,unsafe
	 */
	/*
	 * private static Singleton instance = null;
	 * 
	 * private Singleton() {
	 * 
	 * }
	 * 
	 * private static Singleton getInstance() { if (instance == null) {
	 * synchronized (Singleton.class) { if (instance == null) { instance = new
	 * Singleton(); } } } return instance; }
	 */

	/**
	 * double-checking, safe
	 */
	/*
	 * private static volatile Singleton instance = null;
	 * 
	 * private Singleton() { }
	 * 
	 * public static Singleton getInstance() { if (instance == null) {
	 * synchronized (Singleton.class) { if (instance == null) { instance = new
	 * Singleton(); } } } return instance; }
	 */

	/**
	 * ThreadLocal
	 */
	/*
	 * private static ThreadLocal localInstance = new ThreadLocal(); private
	 * static Singleton instance = null;
	 * 
	 * private Singleton() {
	 * 
	 * }
	 * 
	 * public static Singleton getInstance() { if (localInstance.get() == null)
	 * { createInstance(); } return instance; }
	 * 
	 * private static void createInstance() { synchronized (Singleton.class) {
	 * if (instance == null) { instance = new Singleton(); } }
	 * localInstance.set(instance); }
	 */

	/**
	 * 静态内部内实现
	 */
	// private static class SingletonHolder {
	// static Singleton instance = new Singleton();
	// }
	//
	// public static Singleton getInstace() {
	// return SingletonHolder.instance;
	// }
}
