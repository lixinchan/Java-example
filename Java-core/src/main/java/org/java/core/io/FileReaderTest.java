package org.java.core.io;

import java.io.File;
import java.io.FileReader;

/**
 * @author clx 2017/11/19 23:52
 */
public class FileReaderTest {
	public static void main(String[] args) throws Exception {
		String fileName = "E:" + File.separator + "test" + File.separator + "writer.txt";
		File file = new File(fileName);
		FileReader reader = new FileReader(file);
		char[] buffer = new char[1024];
		int idx = reader.read(buffer);
		while (idx == -1) {
			System.out.println(new String(buffer, 0, idx));
		}
		reader.close();
	}
}
