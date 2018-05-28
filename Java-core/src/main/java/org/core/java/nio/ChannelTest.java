package org.core.java.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author clx 2018/5/28.
 */
public class ChannelTest {

	public static void main(String[] args) {
		FileInputStream inputStream = null;
		try {
			inputStream = new FileInputStream(new File("E:\\test\\serial.txt"));
			FileChannel channel = inputStream.getChannel();
			if (channel.isOpen()) {
				ByteBuffer buffer = ByteBuffer.allocate(256);
				channel.read(buffer);
				buffer.flip();
				while (buffer.hasRemaining()) {
					System.out.print((char) buffer.get());
				}
				buffer.clear();
				channel.close();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
