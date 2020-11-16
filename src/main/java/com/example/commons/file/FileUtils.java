package com.example.commons.file;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Objects;

/**
 * file utils
 *
 * @author clx
 */
public class FileUtils {
	private FileUtils() {
	}

	/**
	 * read project's file
	 *
	 * @param filePath
	 */
	public static void readProjectFile(String filePath) {
		if (StringUtils.isBlank(filePath)) {
			// TODO: log
			return;
		}
		InputStream in = null;
		OutputStream out = null;
		try {
			in = FileUtils.class.getClassLoader().getResourceAsStream(filePath);
			out = new FileOutputStream(new File("out.txt"));
			IOUtils.copy(in, out);
			out.flush();
		} catch (Exception e) {
			// TODO: log
		} finally {
			if (!Objects.isNull(out)) {
				try {
					out.close();
				} catch (IOException e) {
					// TODO: log
				}
			}
			if (!Objects.isNull(in)) {
				try {
					in.close();
				} catch (IOException e) {
					// TODO: log
				}
			}
		}
	}
}
