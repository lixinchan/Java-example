package com.example.guava.basic.utilities;

import com.google.common.base.Preconditions;

/**
 * pre conditions
 *
 * @author clx 2019-07-13
 */
public class PreconditionsTest {

	public static void main(String[] args) {
		test();
	}

	private static void test() {
		String test = "null";
		Preconditions.checkNotNull(test, "empty.");
	}
}
