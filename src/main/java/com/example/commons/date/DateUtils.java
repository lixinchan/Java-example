package com.example.commons.date;

import org.apache.commons.lang3.time.FastDateFormat;

import java.text.ParseException;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author clx 2019-08-12
 */
public final class DateUtils {
	private DateUtils() {
	}

	public static String defaultDateFormat = "yyyy-MM-dd HH:mm:ss.S";

	public static String PATTERN_YMD = "yyyyMMdd";

	public static String PATTERN_YMDHMS = "yyyyMMddHHmmss";

	public static String PATTERN_Y_M_D_HMS = "yyyy-MM-dd HH:mm:ss";

	public static String PATTERN_YMDHMSMS = "yyyyMMddHHmmssSSS";

	public static long DAY_MILLTIMES = 24 * 3600 * 1000;

	public static long LOCAL_TIMEZONE_OFFSET = TimeZone.getDefault().getRawOffset();

	private static FastDateFormat getDateFormat(String pattern) {
		return FastDateFormat.getInstance(pattern);
	}

	/**
	 * format
	 *
	 * @param pattern
	 * @param date
	 * @return
	 */
	public static String format(String pattern, long date) {
		FastDateFormat df = DateUtils.getDateFormat(pattern);
		return df.format(date);
	}

	/**
	 * format
	 *
	 * @param pattern
	 * @param date
	 * @param timeZone
	 * @return
	 */
	public static String format(String pattern, long date, TimeZone timeZone) {
		if (timeZone == null) {
			return format(pattern, date);
		}
		FastDateFormat df = FastDateFormat.getInstance(pattern, timeZone);
		return df.format(date);
	}

	/**
	 * format
	 *
	 * @param pattern
	 * @param date
	 * @return
	 */
	public static String format(String pattern, Date date) {
		FastDateFormat df = DateUtils.getDateFormat(pattern);
		return df.format(date);
	}

	/**
	 * format
	 *
	 * @param pattern
	 * @param date
	 * @param timeZone
	 * @return
	 */
	public static String format(String pattern, Date date, TimeZone timeZone) {
		if (timeZone == null) {
			return format(pattern, date);
		}
		FastDateFormat df = FastDateFormat.getInstance(pattern, timeZone);
		return df.format(date);
	}

	/**
	 * parse String date to Date
	 *
	 * @param pattern
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static Date parse(String pattern, String date) throws ParseException {
		FastDateFormat df = DateUtils.getDateFormat(pattern);
		return df.parse(date);
	}

	/**
	 * format date with timezone
	 *
	 * @param pattern
	 * @param date
	 * @param timeZone
	 * @return
	 * @throws ParseException
	 */
	public static Date parse(String pattern, String date, TimeZone timeZone) throws ParseException {
		if (timeZone == null) {
			return parse(pattern, date);
		}
		FastDateFormat df = FastDateFormat.getInstance(pattern, timeZone);
		return df.parse(date);
	}

	/**
	 * get the day begin(include)
	 *
	 * @param time
	 * @param localTimeZone
	 * @return
	 */
	public static long getDayBegin(long time, boolean localTimeZone) {
		time = time - (time % DateUtils.DAY_MILLTIMES);
		if (localTimeZone) {
			time -= DateUtils.LOCAL_TIMEZONE_OFFSET;
		}
		return time;
	}

	/**
	 * get the day begin(include) with local timezone
	 *
	 * @param time
	 * @return
	 */
	public static long getDayBegin(long time) {
		return DateUtils.getDayBegin(time, true);
	}

	/**
	 * get the day end time(include)
	 *
	 * @param time
	 * @param localTimeZone
	 * @return
	 */
	public static long getDayEnd(long time, boolean localTimeZone) {
		return DateUtils.getDayBegin(time, localTimeZone) + DateUtils.DAY_MILLTIMES - 1;
	}

	/**
	 * get the day end time(include) with local timezone
	 *
	 * @param time
	 * @return
	 */
	public static long getDayEnd(long time) {
		return DateUtils.getDayEnd(time, true);
	}
}
