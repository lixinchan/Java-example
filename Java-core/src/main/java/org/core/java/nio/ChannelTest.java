package org.core.java.nio;

import java.io.File;
import java.io.FileInputStream;
import java.nio.channels.FileChannel;

/**
 * @author clx 2018/5/28.
 */
public class ChannelTest {

	public static void main(String[] args) {
		try {
			FileInputStream inputStream = new FileInputStream(new File("E:\\test\\serial.txt"));
			FileChannel channel = inputStream.getChannel();
			if (channel.isOpen()) {
				channel.close();
				System.out.println("File channel closed.");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
