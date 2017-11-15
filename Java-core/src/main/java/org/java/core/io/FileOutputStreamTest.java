package org.java.core.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * @author clx 2017/11/14 7:20
 */
public class FileOutputStreamTest {

	public static void main(String[] args) throws Exception {
		execTest();
	}

	private static void execTest() throws Exception {
		File file = new File("E:" + File.separator + "test" + File.separator + "stream.txt");
		OutputStream out = new FileOutputStream(file);
		byte[] bytes = "Hello World!!!".getBytes();
		out.write(bytes);
		out.close();
	}


}
