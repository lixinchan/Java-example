package org.java.core.collection;

import java.util.*;

/**
 * @author clx at 2017年3月29日 下午5:29:48
 */
public class ListTest {
	public static void main(String[] args) {
//		Result result = new Result();
//		List<String> list = new ArrayList<String>();
//		result.setResult(list);
//		for (int index = 0; index < 5; index++) {
//			list.add("H");
//		}
//		System.out.println(result);


		List<Integer> list = new ArrayList<Integer>(16);
		for (int idx = 0; idx < 10; idx++) {
			list.add(idx);
		}

//		for (int idx = 0; idx < list.size(); idx++) {
//			System.out.println("current element:" + list.get(idx));
//			System.out.println("deleted element:" + list.remove(idx));
//		}

//		for (Integer idx : list) {
//			System.out.println(idx);
//			System.out.println(list.remove(idx));
//		}

		Iterator<Integer> iter = list.iterator();
		while(iter.hasNext()) {
			System.out.println("current element:" + iter.next());
			iter.remove();
		}
		System.out.println(list.size());

//		Set<Integer> set = new HashSet<>();
//		for (int idx = 0; idx < 10; idx++) {
//			set.add(idx);
//		}

//		Iterator<Integer> iter = set.iterator();
//		while(iter.hasNext()) {
//			System.out.println(iter.next());
//		}


	}
}

class Result {
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