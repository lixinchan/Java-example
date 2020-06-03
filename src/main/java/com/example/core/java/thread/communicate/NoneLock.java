package com.example.core.java.thread.communicate;

import java.util.stream.IntStream;

/**
 * @author clx
 */
public class NoneLock {

	public static void main(String[] args) {
		new Thread(() -> {
			IntStream.range(0, 100).forEach(idx -> {
				System.out.println("a->" + idx);
			});
		}).start();
		new Thread(() -> {
			IntStream.range(0, 100).forEach(idx -> {
				System.out.println("b->" + idx);
			});
		}).start();
	}
}
