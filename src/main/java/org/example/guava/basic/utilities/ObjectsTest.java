package org.example.guava.basic.utilities;

import com.google.common.base.Objects;

/**
 * @author clx 2019-07-17
 */
public class ObjectsTest {

	public static void main(String[] args) {
		test();
	}

	private static void test() {
		String test = "null";
		System.out.println(Objects.hashCode(test));
		System.out.println(Objects.equal(test, "null"));
	}
}
