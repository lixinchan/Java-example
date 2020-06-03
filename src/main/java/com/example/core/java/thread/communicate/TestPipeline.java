package com.example.core.java.thread.communicate;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * @author clx
 */
public class TestPipeline {

	public static void main(String[] args) {
		try {
			PipedReader reader = new PipedReader();
			PipedWriter writer = new PipedWriter();
			reader.connect(writer);

			new Thread(new ThreadReader(reader)).start();
			Thread.sleep(1000);
			new Thread(new ThreadWriter(writer)).start();
		} catch (Exception e) {

		}
	}

	/**
	 * reader
	 */
	static class ThreadReader implements Runnable {
		private PipedReader reader;

		public ThreadReader(PipedReader reader) {
			this.reader = reader;
		}

		@Override
		public void run() {
			System.out.println("reading...");
			int receive = 0;
			try {
				while (((receive = reader.read()) != -1)) {
					System.out.print((char) receive);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * writer
	 */
	static class ThreadWriter implements Runnable {
		private PipedWriter writer;

		public ThreadWriter(PipedWriter writer) {
			this.writer = writer;
		}

		@Override
		public void run() {
			System.out.println("writing...");
			try {
				writer.write("test piped line.");
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
