package com.example.distributed.traffic;

import com.google.common.util.concurrent.RateLimiter;

/**
 * @author clx
 */
public class TrafficRateLimiter {

	public static void main(String[] args) {
		RateLimiter limiter = RateLimiter.create(2.0);
		double acquire = limiter.acquire();
		System.out.println("acquire:" + acquire);
	}
}
