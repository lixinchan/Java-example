package org.core.java.io;

import java.io.PipedInputStream;

/**
 * @author clx 2017/11/23 23:37
 */
public class PipedInputStreamTest implements Runnable {

	private final PipedInputStream in = new PipedInputStream();

	public PipedInputStream getInputStream() {
		return this.in;
	}

	@Override
	public void run() {
		String tmp = null;
		try {
			byte[] bytes = new byte[in.available()];
			int len = 0;
			while ((len = in.read(bytes)) != -1) {
				tmp = new String(bytes, 0, len);
				System.out.println("Reader:" + tmp);
			}
			in.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
