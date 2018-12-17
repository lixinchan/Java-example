package org.vm;

import java.util.ArrayList;
import java.util.List;

/**
 * -xx:PermSize=10m -XX:MaxPermSize=10m
 * 
 * @author clx 2018/12/16
 */
public class RuntimeConstantPoolOOM {

	public static void main(String[] args) {
		// testPermSize();
		testIntern();
	}

	/**
	 * test String's intern()
	 */
	public static void testIntern() {
		String s1 = new StringBuilder("Computer").append("Software").toString();
		System.out.println(s1.intern() == s1);

		String s2 = new StringBuilder("Ja").append("va").toString();
		System.out.println(s2.intern() == s2);
	}

	/**
	 * test PermSize MaxPermSize
	 */
	public static void testPermSize() {
		List<String> constantPool = new ArrayList<>();
		int idx = 0;
		while (true) {
			constantPool.add(String.valueOf(idx).intern());
		}
	}
}
