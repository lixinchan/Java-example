package com.example.core.java.thread.futuretask;

import org.apache.commons.lang3.concurrent.BasicThreadFactory;

import java.io.File;
import java.util.Scanner;
import java.util.concurrent.*;

/**
 * @author clx 2017年4月12日 下午11:27:41
 */
public class FutureTest {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter base directory:");
		String directory = in.nextLine();
		System.out.println("Enter keyWord:");
		String keyWord = in.nextLine();

		MatchCounter counter = new MatchCounter(new File(directory), keyWord);
		FutureTask<Integer> task = new FutureTask<>(counter);

		int minThread = 2;
		int maxThread = 2 * Runtime.getRuntime().availableProcessors() + 1;
		ThreadFactory threadFactory = new BasicThreadFactory.Builder().namingPattern("future-pool-%d").build();
		ExecutorService pool = new ThreadPoolExecutor(minThread, maxThread, 0L, TimeUnit.MILLISECONDS,
				new LinkedBlockingQueue<>(1024), threadFactory, new ThreadPoolExecutor.AbortPolicy());
		pool.execute(task);
		pool.shutdown();

		try {
			System.out.println(task.get() + " matching files.");
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		in.close();
	}
}
