package org.example.core.java.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * @author clx 2018/5/30.
 */
public class SelectorServer {

	public static void main(String[] args) {
		server();
	}

	/**
	 * selector server
	 */
	private static void server() {
		try {
			int serverPort = 9999;
			ServerSocketChannel ssc = ServerSocketChannel.open();
			ssc.configureBlocking(false);

			ServerSocket ss = ssc.socket();
			ss.bind(new InetSocketAddress(serverPort));

			Selector selector = Selector.open();
			// register
			ssc.register(selector, SelectionKey.OP_ACCEPT);

			while (true) {
				int selectKeys = selector.select();
				if (selectKeys == 0) {
					continue;
				}

				Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
				while (iterator.hasNext()) {
					SelectionKey selectionKey = iterator.next();
					if (selectionKey.isAcceptable()) {
						ServerSocketChannel workerChannel = (ServerSocketChannel) selectionKey.channel();
						SocketChannel sc = workerChannel.accept();
						sc.configureBlocking(false);
						sc.register(selector, SelectionKey.OP_READ);
					} else if (selectionKey.isReadable()) {
						readData(selectionKey);
					}
					iterator.remove();
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * read data from socket
	 * 
	 * @param selectionKey
	 */
	private static void readData(SelectionKey selectionKey) throws IOException {
		SocketChannel channel = (SocketChannel) selectionKey.channel();
		ByteBuffer buffer = ByteBuffer.allocate(2048);
		buffer.clear();
		while (channel.read(buffer) > 0) {
			buffer.flip();
			if (buffer.hasArray()) {
				System.out.println(new String(buffer.array(), "utf-8").trim());
			}
			buffer.clear();
		}
	}
}
