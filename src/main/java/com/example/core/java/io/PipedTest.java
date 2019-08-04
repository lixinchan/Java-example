package com.example.core.java.io;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * @author clx 2017/11/23 23:54
 */
public class PipedTest {

	public static void main(String[] args) {
		PipedOutputStreamTest out = new PipedOutputStreamTest();
		PipedInputStreamTest in = new PipedInputStreamTest();
		Thread outThread = new Thread(out);
		Thread inThread = new Thread(in);
		PipedOutputStream outputStream = out.getOutputStream();
		PipedInputStream inputStream = in.getInputStream();
		try {
			outputStream.connect(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		outThread.start();
		inThread.start();
	}
}
