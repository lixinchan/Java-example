package org.core.java.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author clx 2018/5/31.
 */
public class Test {

	public static void main(String[] args) {
		int first = 1123;
		int second = 112345;
		List<Integer> result = new ArrayList<>();
		split(result, first, second);
		Collections.sort(result);
		result.forEach(System.out::print);
	}

	private static void split(List<Integer> result, int... allNum) {
		for (int num : allNum) {
			int ret = splitNum(result, num);
			while (ret != 0) {
				ret = splitNum(result, ret);
			}
		}
	}

	private static int splitNum(List<Integer> result, int num) {
		int ele = num % 10;
		if (!result.contains(ele)) {
			result.add(ele);
		}
		return num / 10;
	}
}
