package com.example.guava.basic.utilities;

import com.google.common.base.Preconditions;

import java.util.Objects;

/**
 * pre conditions
 *
 * @author clx 2019-07-13
 */
public class TestPreconditions {

	public static void main(String[] args) {
		test();
	}

	private static void test() {
		String test = "null";
		String s = null;
		Preconditions.checkNotNull(test, "empty.");
		Preconditions.checkArgument(Objects.nonNull(s));
	}
}
