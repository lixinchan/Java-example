package com.example.demo.core.test;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author clx 2018/5/2.
 */
public class TestOutOfMemory {

	private static Map<Long, Set<Integer>> setMap = new ConcurrentHashMap<>();

	public static void main(String[] args) {
		final long key = 1L;
		setMap.put(key, new HashSet<Integer>());
		for (int idx = 0; idx < 100; idx++) {
			setMap.get(key).add(idx);
		}

		Thread first = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int idx = 100; idx < 200000; idx++) {
					setMap.get(key).add(idx);
				}
			}
		});

		Thread second = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int idx = 200000; idx < 2 * 200000; idx++) {
					setMap.get(key).add(idx);
				}
			}
		});

		first.start();
		second.start();

		try {
			Thread.sleep(1000 * 10);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		System.out.println(setMap.toString());
	}
}
