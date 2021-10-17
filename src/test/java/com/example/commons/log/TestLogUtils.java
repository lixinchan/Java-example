package com.example.commons.log;

import org.junit.Test;

/**
 * @author clx
 */
public class TestLogUtils {

	@Test
	public void testPrintlnLog() {
		String content = "xxxxx";
		LogUtils.info("content={}", content);
	}
}
