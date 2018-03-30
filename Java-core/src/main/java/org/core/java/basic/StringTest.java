package org.core.java.basic;

public class StringTest {

	public static void main(String[] args) {
		// String str = "";
		// if (str != null && str.length() != 0) {
		// System.out.println("true");
		// } else {
		// System.out.println("false");
		// }

		// for (int i = 10; i > 0; --i)
		// System.out.println("Counting down..." + i);
		// System.out.println("Time out!");

		long timeStamp = System.currentTimeMillis();
		long time = timeStamp / 1000;
		System.out.println(timeStamp);
		System.out.println(time);
		// System.out.println((time << 20) | (1 << 8));
		System.out.println(Long.toBinaryString(time).length());
		System.out.println(Long.toBinaryString(time << 28).length());
		System.out.println(Long.toBinaryString(1 << 8));
		System.out.println(Long.toBinaryString((time << 28) | (262143 << 10) | 9).length());
		// System.out.println(Long.toBinaryString(262143 << 10).length());
		// System.out.println(Long.toBinaryString(9).length());
	}

}
