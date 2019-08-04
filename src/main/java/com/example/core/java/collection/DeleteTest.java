package com.example.core.java.collection;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author clx 2017/11/10.
 */
public class DeleteTest {

	public static void main(String[] args) {
		Map<Integer, Integer> map = new HashMap<>(16);
		List<Integer> delKeyList = new ArrayList<>();
		for (int idx = 0; idx < 10; idx++) {
			if (map.size() == 0) {
				map.put(idx, idx);

			} else {
				for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
					if (entry.getKey() % 2 != idx % 2) {
						map.put(idx, idx);
					} else {
						delKeyList.add(entry.getKey());
					}
				}
			}
		}
		System.out.println(delKeyList);
		for (Integer key : delKeyList) {
			map.remove(key);
		}
		System.out.println(map);
	}
}
