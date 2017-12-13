package org.java.core.util;

/**
 * array utils
 *
 * @author clx 2017/12/13.
 */
public class ArrayUtils {

	public static void main(String[] args) {
		int[] array = new int[]{1, 2, 3, 4, 5};
		ArrayUtils.printArray(array);
	}

	/**
	 * print array
	 *
	 * @param array input array
	 */
	public static void printArray(int[] array) {
		if (array == null) {
			return;
		}
		System.out.print('[');
		if (array.length == 0) {
			System.out.print(']');
			return;
		}
		for (int idx = 0; idx < array.length - 1; idx++) {
			System.out.print(array[idx] + ",");
		}
		System.out.println(array[array.length - 1] + "]");
	}
}
