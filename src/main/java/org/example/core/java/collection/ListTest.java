package org.example.core.java.collection;

import java.util.*;

/**
 * @author clx at 2017年3月29日 下午5:29:48
 */
public class ListTest {

	public static void main(String[] args) {
		Result result = new Result();
		List<String> strings = new ArrayList<>();
		result.setResult(strings);
		for (int index = 0; index < 5; index++) {
			strings.add("H");
		}
		System.out.println(result);

		List<Integer> integers = new ArrayList<>(16);
		for (int idx = 0; idx < 10; idx++) {
			integers.add(idx);
		}

		for (int idx = 0; idx < integers.size(); idx++) {
			System.out.println("current element:" + integers.get(idx));
			System.out.println("deleted element:" + integers.remove(idx));
		}

		// wrongRemove(integers);

		Iterator<Integer> iter = integers.iterator();
		while (iter.hasNext()) {
			System.out.println("current element:" + iter.next());
			iter.remove();
		}
		System.out.println(integers.size());

		Set<Integer> set = new HashSet<>();
		for (int idx = 0; idx < 10; idx++) {
			set.add(idx);
		}

		Iterator<Integer> iterator = set.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}

	/**
	 * wrong way to remove collection element
	 * 
	 * @param integers
	 */
	private static void wrongRemove(List<Integer> integers) {
		for (Integer idx : integers) {
			System.out.println(idx);
			System.out.println(integers.remove(idx));
		}
	}

	static class Result {
		private List<String> result;

		public List<String> getResult() {
			return result;
		}

		public void setResult(List<String> result) {
			this.result = result;
		}

		@Override
		public String toString() {
			return "Result [result=" + result + "]";
		}
	}
}