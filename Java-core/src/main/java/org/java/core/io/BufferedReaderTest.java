package org.java.core.io;

import java.io.*;

/**
 * @author clx 2017/11/21 23:47
 */
public class BufferedReaderTest {
	public static void main(String[] args) throws Exception {
		File file = new File("E:" + File.separator + "test" + File.separator + "buffered.txt");
		InputStream in = new FileInputStream(file);
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		String str = null;
		while ((str = reader.readLine()) != null) {
			System.out.println(str);
		}
		reader.close();
		in.close();
	}
}
