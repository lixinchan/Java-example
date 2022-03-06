package com.example.design.patterns.pattern.created.factory.abstracts;

import java.util.concurrent.TimeUnit;

/**
 * @author clx
 */
public interface CacheService {
	/**
	 * get
	 *
	 * @param k key
	 * @return val
	 */
	String get(String k);

	/**
	 * set
	 *
	 * @param k   key
	 * @param val value
	 * @return {@link Boolean}
	 */
	Boolean set(String k, String val);

	/**
	 * set
	 *
	 * @param k        key
	 * @param val      value
	 * @param timeout  timeout
	 * @param timeUnit time unit
	 * @return {@link Boolean}
	 */
	Boolean set(String k, String val, long timeout, TimeUnit timeUnit);

	/**
	 * del
	 *
	 * @param k key
	 * @return {@link Integer}
	 */
	Integer del(String k);
}
