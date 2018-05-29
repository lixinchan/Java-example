package org.core.java.test;

import java.lang.instrument.Instrumentation;

/**
 * calculate object size
 * 
 * @author clx 2018/5/17.
 */
public class CalculateObjectSize<T> {

	/**
	 * calculate object size
	 * 
	 * @param instrumentation
	 * @param target
	 */
	public void objectSize(Instrumentation instrumentation, T target) {
		System.out.println("Object size:" + instrumentation.getObjectSize(new Object()));
		System.out.println("target object size:" + instrumentation.getObjectSize(target));
	}
}
