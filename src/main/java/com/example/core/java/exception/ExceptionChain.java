package com.example.core.java.exception;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/**
 * @author chenlixin at 2015年7月23日 下午6:15:41
 */
public class ExceptionChain {

	public static void testOne() throws Throwable {
		try {

		} catch (Exception ex) {
			Throwable se = new Throwable("message");
			se.initCause(ex);
			throw se;
		}
	}

	public static void testTwo() {
		InputStream in = null;
		try {
			try {
				in = new FileInputStream("");
			} finally {
				in.close();
			}
		} catch (IOException ex) {

		}
	}

	public static int testThree(int n) {
		try {
			int retVal = (int) Math.pow(n, n);
//			System.exit(0);
			int val = retVal / 0;
		} catch (Exception ex) {
			System.exit(0);
			return 1;
		} finally {
			if (n == 4) {
				return 0;
			}
			return n;
		}
	}

	public static void testFour() {
		Throwable e = new Throwable();
		StackTraceElement[] element = e.getStackTrace();
		for (StackTraceElement frame : element) {

		}
		Map<Thread, StackTraceElement[]> stackMap = Thread.getAllStackTraces();
		for (Thread t : stackMap.keySet()) {
			StackTraceElement[] frames = stackMap.get(t);
		}
	}
}
