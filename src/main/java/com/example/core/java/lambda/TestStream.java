package com.example.core.java.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author clx
 */
public class TestStream {
	public static void main(String[] args) {
		System.out.println("current thread:" + Runtime.getRuntime().availableProcessors());

		Random rand = new Random();
		List<Integer> list = new ArrayList<>(10_000_000);
		for (int idx = 0; idx < 10_000_000; idx++) {
			list.add(rand.nextInt(100));
		}

		long startTime = System.currentTimeMillis();
		System.out.println("normal compute result:");
		list.stream().reduce(Integer::sum).ifPresent(System.out::println);
		long endTime = System.currentTimeMillis();
		System.out.println("elapsed time:" + (endTime - startTime));

		System.out.println("parallel compute result:");
		list.stream().parallel().reduce(Integer::sum).ifPresent(System.out::println);
		System.out.println("elapsed time:" + (System.currentTimeMillis() - endTime));
	}
}
