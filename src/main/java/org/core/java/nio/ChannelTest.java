package org.core.java.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

/**
 * @author clx 2018/5/28.
 */
public class ChannelTest {

	public static void main(String[] args) {
		write();
		read();
	}

	/**
	 * FileChannel write test
	 */
	private static void write() {
		RandomAccessFile randomAccessFile = null;
		try {
			String filePath = "E:\\test\\fileChannel.txt";
			File file = new File(filePath);
			randomAccessFile = new RandomAccessFile(file, "rw");
			FileChannel channel = randomAccessFile.getChannel();
			String srcText = "哈哈哈哈 FileChannel write/read test.";
			ByteBuffer buffer = ByteBuffer.allocate(64);
			buffer.put(srcText.getBytes(Charset.forName("utf-8")));
			buffer.flip();
			channel.write(buffer);
			buffer.clear();
			if (channel.isOpen()) {
				channel.close();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (randomAccessFile != null) {
				try {
					randomAccessFile.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * FileChannel read test
	 */
	private static void read() {
		FileInputStream inputStream = null;
		try {
			inputStream = new FileInputStream(new File("E:\\test\\fileChannel.txt"));
			FileChannel channel = inputStream.getChannel();
			if (channel.isOpen()) {
				ByteBuffer buffer = ByteBuffer.allocate(256);
				channel.read(buffer);
				buffer.flip();
				byte[] bytes = new byte[buffer.capacity()];
				if (buffer.hasArray()) {
					bytes = buffer.array();
				}
				System.out.println(new String(bytes, "utf-8").trim());
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
