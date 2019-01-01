package org.example.core.java.thread.pool;

import java.io.File;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author clx 2017年4月13日 下午11:56:00
 */
public class ThreadPoolTest {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter base directory:");
		String directory = in.nextLine();
		System.out.println("Enter keyWord:");
		String keyWord = in.nextLine();

		ExecutorService pool = Executors.newCachedThreadPool();
		MatchCounter counter = new MatchCounter(new File(directory), keyWord, pool);
		Future<Integer> result = pool.submit(counter);

		try {
			System.out.println(result.get() + " matching files");
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}

		pool.shutdown();
		in.close();

		int largestPoolSize = ((ThreadPoolExecutor) pool).getLargestPoolSize();
		System.out.println("Largest Pool Size:" + largestPoolSize);
	}
}
