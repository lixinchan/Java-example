package org.java.core.collection;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author chenlixin at 2016年9月19日 下午4:20:10
 */
public class LinkedHashMapTest {

	public static void main(String[] args) {
		Map<Integer, String> map = new LinkedHashMap<Integer, String>();
		for (int index = 0; index < 10; index++) {
			map.put(index, String.valueOf(index));
		}

		for (int index = 0; index < 10; index++) {
			System.out.println(map.get(5));
			map.remove(5);
		}

		Iterator<Integer> iter = map.keySet().iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
			iter.remove();
		}
	}
}
