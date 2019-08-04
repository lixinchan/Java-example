package com.example.core.java.thread;

import com.example.core.java.thread.blockqueue.FileEnumTask;
import com.example.core.java.thread.blockqueue.FileSearchTask;

import java.io.File;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author clx 2018/5/21.
 */
public class TestBlockingQueue {

	private static final int QUEUE_SIZE = 15;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter base directory:");
		String directory = in.nextLine();
		System.out.println("Enter keyWord:");
		String keyWord = in.nextLine();

		int availableProcessor = Runtime.getRuntime().availableProcessors();
		ExecutorService findFilePool = Executors.newFixedThreadPool(2 * availableProcessor + 1);
		ExecutorService searchPool = Executors.newFixedThreadPool(2 * availableProcessor);
		BlockingQueue<File> blockingQueue = new ArrayBlockingQueue<>(QUEUE_SIZE);
		findFilePool.execute(new FileEnumTask(blockingQueue, new File(directory)));
		searchPool.execute(new FileSearchTask(blockingQueue, keyWord));

		findFilePool.shutdown();
		searchPool.shutdown();
		in.close();
	}
}
