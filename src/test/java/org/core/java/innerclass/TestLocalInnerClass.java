package org.core.java.innerclass;

/**
 * @author clx 2018/4/8.
 */
public class TestLocalInnerClass {

	public static void main(String[] args) {
		LocalInnerClass outer = new LocalInnerClass();
		outer.localInnerClass();

		int idx = 5;
		class Test {
			public void printIdx() {
				System.out.println(idx);
			}
		}
		Test test = new Test();
		test.printIdx();
	}
}
