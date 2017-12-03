package org.java.core.basic;

import java.util.Scanner;

/**
 * @author clx 2017年9月23日 上午10:59:49
 */
public class CalculatorBinary {

	private static int calBinaryOne(int idx) {
		int count = 0;
		while (idx > 0) {
			idx = idx & idx - 1;
			count++;
		}
		return count;
	}

	public static void main(String[] args) {
		int idx = -1;
		System.out.println("Please input a int number.");
		Scanner scan = new Scanner(System.in);
		idx = Integer.valueOf(scan.next());
		scan.close();
		if (idx != -1) {
			System.out.println(calBinaryOne(idx));
			System.out.println(Integer.toBinaryString(idx));
		}
	}
}
