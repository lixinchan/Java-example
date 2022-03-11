package com.example.design.patterns.pattern.structural.adapter;

/**
 * @author clx
 */
public interface OrderService {
	/**
	 * query user order count
	 *
	 * @param uid user id
	 * @return order count
	 */
	long queryUserOrderCount(String uid);
}
