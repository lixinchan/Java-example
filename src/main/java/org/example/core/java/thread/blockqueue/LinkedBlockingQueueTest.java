package org.example.core.java.thread.blockqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author clx 3/7/2018
 */
public class LinkedBlockingQueueTest {

	public static void main(String[] args) throws Exception {
		testQueue();
	}

	private static void testQueue() throws Exception {
		BlockingQueue<Integer> linkedBlockingQueue = new LinkedBlockingQueue<>();
		for (int idx = 0; idx < 5; idx++) {
			linkedBlockingQueue.put(idx);
		}
		while (!linkedBlockingQueue.isEmpty()) {
			Integer result = linkedBlockingQueue.take();
			System.out.println(result);
		}
	}
}
