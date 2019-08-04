package com.example.core.java.io;

import java.io.*;

/**
 * @author clx 2017/11/21 23:42
 */
public class BufferedWriterTest {

	public static void main(String[] args) throws Exception {
		File file = new File("E:" + File.separator + "test" + File.separator + "buffered.txt");
		OutputStream os = new FileOutputStream(file);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
		bw.write("Hello,World.");
		bw.flush();
		bw.close();
		os.close();
	}
}
