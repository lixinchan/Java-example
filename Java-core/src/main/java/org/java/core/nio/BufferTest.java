package org.java.core.nio;

import java.nio.CharBuffer;

/**
 * @author clx 2017/12/22.
 */
public class BufferTest {

	public static void main(String[] args) {
		CharBuffer buffer = CharBuffer.allocate(256);
		if (fillBuffer(buffer)) {
			buffer.flip();
			drainBuffer(buffer);
			buffer.clear();
		}
	}

	private static String[] array = new String[]{
			"A random string value",
			"The product of an infinite number of monkeys",
			"Hey hey we're the monkeys",
			"Opening act for the monkeys:Jack Hendrix",
			"Scuse me while I kiss this fly",
			"Help Me! Help Me!"
	};

	/**
	 * fill buffer
	 *
	 * @param buffer
	 * @return
	 */
	private static boolean fillBuffer(CharBuffer buffer) {
		if (array.length > 0) {
			for (String element : array) {
				for (int idx = 0; idx < element.length(); idx++) {
					buffer.put(element.charAt(idx));
				}
			}
			return buffer.hasRemaining();
		}
		return false;
	}

	/**
	 * drain buffer
	 *
	 * @param buffer
	 */
	private static void drainBuffer(CharBuffer buffer) {
		while (buffer.hasRemaining()) {
			System.out.print(buffer.get());
		}
	}
}
