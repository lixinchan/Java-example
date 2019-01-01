package org.example.core.java.io;

import java.io.File;
import java.io.FileWriter;

/**
 * @author clx 2017/11/19 22:13
 */
public class FileWriterTest {
	public static void main(String[] args) throws Exception {
		String fileName = "E:" + File.separator + "test" + File.separator + "writer.txt";
		File file = new File(fileName);
		FileWriter writer = new FileWriter(file);
		String content = "Hello,World!";
		writer.write(content);
		writer.close();
	}
}
