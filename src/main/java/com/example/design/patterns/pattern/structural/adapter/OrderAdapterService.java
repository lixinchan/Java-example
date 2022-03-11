package com.example.design.patterns.pattern.structural.adapter;

/**
 * order adapter
 *
 * @author clx
 */
public interface OrderAdapterService {
	/**
	 * is first order
	 *
	 * @param uid user id
	 * @return bool
	 */
	boolean isFirstOrder(String uid);
}
