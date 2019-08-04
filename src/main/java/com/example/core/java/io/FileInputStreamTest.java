package com.example.core.java.io;

import java.io.File;
import java.io.FileInputStream;

/**
 * @author clx 2017/11/15 23:20
 */
public class FileInputStreamTest {

	public static void main(String[] args) throws Exception {
		execTest();
	}

	public static void execTest() throws Exception {
		File file = new File("E:" + File.separator + "test" + File.separator + "stream.txt");
		FileInputStream in = new FileInputStream(file);
		byte[] bytes = new byte[(int) file.length()];
		int totalBytes = in.read(bytes);
		System.out.println("TotalBytes:" + totalBytes + "---" + new String(bytes, 0, totalBytes));
		in.close();
	}
}
