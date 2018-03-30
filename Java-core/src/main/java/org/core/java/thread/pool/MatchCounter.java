package org.core.java.thread.pool;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/**
 * @author clx 2017年4月16日 下午6:07:06
 */
public class MatchCounter implements Callable<Integer> {

	private File directory;
	private String keyWord;
	private int count;
	private ExecutorService pool;

	public MatchCounter(File directory, String keyWord, ExecutorService pool) {
		super();
		this.directory = directory;
		this.keyWord = keyWord;
		this.pool = pool;
	}

	@Override
	public Integer call() throws Exception {
		count = 0;
		try {
			File[] files = directory.listFiles();
			List<Future<Integer>> results = new ArrayList<Future<Integer>>();

			for (File file : files) {
				if (file.isDirectory()) {
					MatchCounter counter = new MatchCounter(file, keyWord, pool);
					Future<Integer> result = pool.submit(counter);
					results.add(result);
				} else {
					if (search(file)) {
						count++;
					}
				}
			}

			for (Future<Integer> result : results) {
				count += result.get();
			}
		} catch (Exception ex) {

		}
		return count;
	}

	public boolean search(File file) {
		try {
			Scanner in = new Scanner(new FileInputStream(file));
			boolean found = false;
			while (!found && in.hasNextLine()) {
				String line = in.nextLine();
				if (line.contains(keyWord)) {
					found = true;
				}
			}
			in.close();
			return found;
		} catch (Exception ex) {
			return false;
		}
	}
}
