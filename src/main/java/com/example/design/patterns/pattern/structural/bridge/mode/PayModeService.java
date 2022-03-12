package com.example.design.patterns.pattern.structural.bridge.mode;

/**
 * @author clx
 */
public interface PayModeService {
	/**
	 * security
	 *
	 * @param uid user id
	 * @return bool
	 */
	boolean security(String uid);
}
