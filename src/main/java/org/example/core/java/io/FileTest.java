package org.example.core.java.io;

import java.io.File;

/**
 * @author clx 2017/11/5 21:37
 */
public class FileTest {

	public static void main(String[] args) {
		FileTest.fileTest();
	}

	private static void fileTest() {
		String fileName = "E:" + File.separator + "test";
		File file = new File(fileName);
		if (file.exists() && file.isDirectory()) {
			File[] files = file.listFiles();
			if (files == null) {
				return;
			}
			for (File f : files) {
				System.out.println("isExist:" + f.exists());
				System.out.println("isFile:" + f.isFile());
				System.out.println("fileName:" + f.getName());
				System.out.println("filePath:" + f.getPath());
				System.out.println("file absolute path:" + f.getAbsolutePath());
				System.out.println("file parent:" + f.getParent());
				System.out.println("file canRead:" + f.canRead());
				System.out.println("file canWrite:" + f.canWrite());
				System.out.println("file length:" + f.length());
				System.out.println("file lastModified:" + f.lastModified());
				System.out.println("file uri:" + f.toURI());
			}
		}
	}
}
