package com.example.core.java.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @author clx 2018/5/30.
 */
public class SelectorClient {

	/**
	 * thread sum
	 */
	private static int sum = 5000;

	public static void main(String[] args) {
		client();
	}

	/**
	 * selector client
	 */
	private static void client() {
		try {
			SelectorClient.NoneBlockingClient[] clients = new SelectorClient.NoneBlockingClient[sum];
			for (int idx = 0; idx < sum; idx++) {
				clients[idx] = new SelectorClient.NoneBlockingClient();
			}
			for (int idx = 0; idx < sum; idx++) {
				clients[idx].start();
			}
			for (int idx = 0; idx < sum; idx++) {
				clients[idx].join();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private static class NoneBlockingClient extends Thread {

		@Override
		public void run() {
			try {
				SocketChannel sc = SocketChannel.open();
				sc.configureBlocking(false);
				sc.connect(new InetSocketAddress("127.0.0.1", 9999));
				while (!sc.finishConnect()) {
					System.out.println("Establish connect from server. time:" + System.currentTimeMillis());
					Thread.sleep(10);
				}
				System.out.println("Connection established.");
				String data = Thread.currentThread().getName() + ":" + "Hello,NIO!";
				ByteBuffer buffer = ByteBuffer.allocate(data.length());
				buffer.put(data.getBytes());
				buffer.flip();
				sc.write(buffer);
				buffer.clear();
				sc.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
}
