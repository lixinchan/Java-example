package org.java.core.util;

/**
 * String utils
 *
 * @author chenlixin at 2016年12月8日 下午3:20:32
 */
public class StringUtils {

	public static void main(String[] args) {
		String test = "abccba";
		System.out.println(StringUtils.isPalindrome(test));
	}

	/**
	 * decide string is or not palindrome
	 *
	 * @param s
	 * @return
	 */
	public static boolean isPalindrome(String s) {
		int len = s.length();
		for (int idx = 0; idx < len / 2; idx++) {
			if (s.charAt(idx) == s.charAt(len - 1 - idx)) {
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
