package com.example.commons.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * log utils
 *
 * @author clx
 */
public final class LogUtils {
	private LogUtils() {
	}

	private static final Logger LOGGER = LoggerFactory.getLogger(LogUtils.class);

	/**
	 * debug log grade
	 *
	 * @param pattern    log format
	 * @param logContent log content
	 */
	public static void debug(String pattern, Object... logContent) {
		LOGGER.debug(pattern, logContent);
	}

	/**
	 * info log grade
	 *
	 * @param pattern    log format
	 * @param logContent log content
	 */
	public static void info(String pattern, Object... logContent) {
		LOGGER.info(pattern, logContent);
	}

	/**
	 * warn log grade
	 *
	 * @param pattern    log format
	 * @param logContent log content
	 */
	public static void warn(String pattern, Object... logContent) {
		LOGGER.warn(pattern, logContent);
	}

	/**
	 * error log grade
	 *
	 * @param pattern    log format
	 * @param logContent log content
	 */
	public static void error(String pattern, Object... logContent) {
		LOGGER.error(pattern, logContent);
	}
}
