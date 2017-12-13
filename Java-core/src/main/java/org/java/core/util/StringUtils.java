package org.java.core.util;

/**
 * @author chenlixin at 2016年12月8日 下午3:20:32
 */
public class StringUtils {

	/**
	 * decide string is or not palindrome
	 *
	 * @param s
	 * @return
	 */
	public static boolean isPalindrome(String s) {
		int len = s.length();
		for (int index = 0; index < len / 2; index++) {
			if (s.charAt(index) == s.charAt(len - 1 - index)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * decided string is or not sorted
	 *
	 * @param s
	 * @return
	 */
	public static boolean isSorted(String[] s) {
		for (int index = 1; index < s.length; index++) {
			if (s[index - 1].compareTo(s[index]) < 0) {
				return true;
			}
		}
		return false;
	}
}
