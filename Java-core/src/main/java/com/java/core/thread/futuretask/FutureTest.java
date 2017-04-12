package com.java.core.thread.futuretask;

import java.io.File;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

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
		FutureTask<Integer> task = new FutureTask<Integer>(counter);
		new Thread(task).start();

		try {
			System.out.println(task.get() + " matching files.");
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		in.close();
	}
}
