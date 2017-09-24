package org.java.core.basic;

/**
 * @author clx 2017年9月23日 上午10:59:49
 */
public class CaculatorBinary {

	public static int calBinaryOne(int idx) {
		int count = 0;
		while (idx > 0) {
			idx = idx & idx - 1;
			count++;
		}
		return count;
	}

	public static void main(String[] args) {
		int idx = 5;
		System.out.println(calBinaryOne(idx));
	}
}
