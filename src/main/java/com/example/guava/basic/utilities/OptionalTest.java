package com.example.guava.basic.utilities;

import com.google.common.base.Optional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * using and avoid null
 *
 * @author clx 2019-07-11
 */
public class OptionalTest {

	public static void main(String[] args) {
		test();
		testNullable();
		testAsSet();
	}

	private static void test() {
		String test = "";
		Optional<String> optional = Optional.of(test);
		if (!optional.isPresent()) {
			System.out.println(optional.orNull());
		}
		System.out.println(optional.get());
	}

	private static void testNullable() {
		String test = "abc";
		Optional<String> optional = Optional.fromNullable(test);
		if (optional.isPresent()) {
			System.out.println(optional.get());
		}
		test = null;
		String result = Optional.fromNullable(test).or("default.");
		System.out.println(result);
	}

	private static void testAsSet() {
		List<String> list = new ArrayList<>();
		for (int idx = 0; idx < 1; idx++) {
			list.add("abc");
		}
		Set<List<String>> set = Optional.fromNullable(list).asSet();
		System.out.println(set.size());
	}
}
