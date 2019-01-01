package org.example.core.java.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author clx 2017/11/10 0:27
 */
public class MapTest {

	public static void main(String[] args) {
		Map<Integer, Integer> map = new HashMap<>(16);
		for (int idx = 0; idx < 10; idx++) {
			map.put(idx, idx);
		}
		System.out.println(map);

		Set<Integer> keySet = map.keySet();
		Iterator<Integer> iterator = keySet.iterator();
		while (iterator.hasNext()) {
			Integer key = iterator.next();
			System.out.println(key + "=" + map.get(key));
			iterator.remove();
			map.remove(key);
		}
		System.out.println(map);
	}
}
