package org.example.core.java.innerclass;

/**
 * @author clx 2018/4/8.
 */
public class StaticInnerClass {

	static int idx = 1;

	public static void printIdx() {
		System.out.println(idx);
	}

	public static class StaticInner {
		int idx = 2;

		public void printIdx() {
			StaticInnerClass.printIdx();
			System.out.println(idx);
		}

		public static void staticPrintIdx() {
			System.out.println("StaticInnerClass.StaticInner.staticPrintIdx()");
		}
	}
}
