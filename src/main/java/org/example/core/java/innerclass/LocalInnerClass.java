package org.example.core.java.innerclass;

/**
 * @author clx 2018/4/8.
 */
public class LocalInnerClass {

	int idx = 1;

	public void localInnerClass() {
		int idx = 2;
		class InnerClass {
			public void printIdx() {
				System.out.println(idx);
			}
		}
		InnerClass inner = new InnerClass();
		inner.printIdx();
		System.out.println(this.idx);
	}
}
