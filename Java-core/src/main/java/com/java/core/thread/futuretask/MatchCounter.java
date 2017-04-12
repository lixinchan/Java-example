package com.java.core.thread.futuretask;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @author clx 2017年4月12日 下午11:28:17
 */
public class MatchCounter implements Callable<Integer> {

	private File directory;
	private String keyWord;
	private int count;

	public MatchCounter(File directory, String keyWord) {
		this.directory = directory;
		this.keyWord = keyWord;
	}

	@Override
	public Integer call() throws Exception {
		count = 0;
		File[] files = directory.listFiles();
		List<Future<Integer>> results = new ArrayList<Future<Integer>>();

		for (File file : files) {
			if (file.isDirectory()) {
				MatchCounter counter = new MatchCounter(file, keyWord);
				FutureTask<Integer> task = new FutureTask<Integer>(counter);
				results.add(task);
				new Thread(task).start();
			} else {
				if (search(file)) {
					count++;
				}
			}
		}
		return count;
	}

	private boolean search(File file) {
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
