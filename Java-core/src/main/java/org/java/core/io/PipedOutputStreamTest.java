package org.java.core.io;

import java.io.PipedOutputStream;

/**
 * @author clx 2017/11/23 23:37
 */
public class PipedOutputStreamTest implements Runnable {

	private final PipedOutputStream out = new PipedOutputStream();

	public PipedOutputStream getOutputStream() {
		return this.out;
	}

	@Override
	public void run() {
		String test = "Hello, Recevier!";
		try {
			out.write(test.getBytes());
			out.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
