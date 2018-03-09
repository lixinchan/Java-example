package org.java.core.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * test list's new features
 *
 * @author clx 2018/3/9.
 */
public class ListNewFeaturesTest {

	private static List<String> list;

	/**
	 * return list
	 *
	 * @return
	 */
	public static List<String> getList() {
		return list;
	}

	/**
	 * init list
	 */
	static {
		list = new ArrayList<>();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
	}

	/**
	 * filter test
	 *
	 * @param list
	 * @param target
	 * @return
	 */
	private static List<String> filterTest(List<String> list, final String target) {
		return list.stream().filter(key -> !key.equals(target)).collect(Collectors.<String>toList());
	}

	public static void main(String[] args) {
		String target = "a";
		filterTest(getList(), target).forEach(System.out::println);
	}
}
