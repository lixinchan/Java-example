package org.core.java.nio;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * @author clx 2018/5/29.
 */
public class NonBlockingSocketServer {

	public static void main(String[] args) {
		server();
	}

	private static void server() {
		int serverPort = 9999;
		try {
			ServerSocketChannel ssc = ServerSocketChannel.open();
			ssc.configureBlocking(false);
			ServerSocket ss = ssc.socket();
			ss.bind(new InetSocketAddress(serverPort));
			System.out.println("Start waiting client data. time:" + System.currentTimeMillis());
			while (true) {
				SocketChannel sc = ssc.accept();
				if (sc == null) {
					Thread.sleep(100);
				} else {
					System.out.println("Client data received. client ip:" + sc.socket().getInetAddress());
					ByteBuffer buffer = ByteBuffer.allocate(256);
					sc.read(buffer);
					buffer.flip();
					if (buffer.hasArray()) {
						System.out.println(new String(buffer.array(), "utf-8").trim());
					}
					buffer.clear();
					sc.close();
					ss.close();
					ssc.close();
					System.exit(0);
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
