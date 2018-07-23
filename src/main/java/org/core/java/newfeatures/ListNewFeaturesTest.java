package org.core.java.newfeatures;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

/**
 * test list's new features
 *
 * @author clx 2018/3/9.
 */
public class ListNewFeaturesTest {

	private static List<Person> list;

	/**
	 * return list
	 *
	 * @return
	 */
	public static List<Person> getList() {
		return list;
	}

	/**
	 * init list
	 */
	static {
		list = new ArrayList<>();
		list.add(new Person(1, "a"));
		list.add(new Person(2, "b"));
		list.add(new Person(3, "a"));
		list.add(new Person(4, "c"));
		list.add(new Person(5, "d"));
	}

	static class Person {
		private int id;
		private String name;

		private Person(int id, String name) {
			this.id = id;
			this.name = name;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return "Person{" + "id=" + id + ", name='" + name + '\'' + '}';
		}
	}

	/**
	 * filter test
	 *
	 * @param list
	 * @param target
	 * @return
	 */
	private static List<Person> filterNotEquals(List<Person> list, final String target) {
		return list.stream().filter(key -> !target.equals(key.getName())).collect(Collectors.toList());
	}

	/**
	 * filter test
	 *
	 * @param list
	 * @param target
	 * @return
	 */
	private static List<Person> filterEquals(List<Person> list, String target) {
		return list.stream().filter(key -> target.equals(key.getName())).collect(Collectors.toList());
	}

	/**
	 * find test
	 *
	 * @param list
	 * @param target
	 * @return
	 */
	private static Person findElements(List<Person> list, String target) {
		return list.stream().filter(key -> target.equals(key.getName())).findAny().orElse(null);
	}

	/**
	 * find element by multi condition
	 *
	 * @param list
	 * @param target
	 * @param idx
	 * @return
	 */
	private static Person findByMultiCondition(List<Person> list, String target, int idx) {
		return list.stream().filter(key -> {
			if (StringUtils.equals(key.getName(), target) && (key.getId() == idx)) {
				return true;
			} else {
				return false;
			}
		}).findAny().orElse(null);
	}

	/**
	 * findWithMap
	 *
	 * @param list
	 * @param target
	 * @return
	 */
	private static String findWithMap(List<Person> list, String target) {
		return list.stream().filter(key -> target.equals(key.getName())).map(Person::getName).findAny().orElse(null);

	}

	public static void main(String[] args) {
		int idx = 1;
		String target = "a";
		System.out.println("----------------filterNotEquals");
		filterNotEquals(getList(), target).forEach(System.out::println);
		System.out.println("----------------filterEquals");
		filterEquals(getList(), target).forEach(System.out::println);
		System.out.println("----------------findElements");
		System.out.println(findElements(getList(), target));
		System.out.println("----------------findByMultiCondition");
		System.out.println(findByMultiCondition(getList(), target, idx));
		System.out.println("----------------findWithMap");
		System.out.println(findWithMap(getList(), target));
	}
}
