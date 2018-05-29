package org.core.java.innerclass;

/**
 * @author clx 2018/4/8.
 */
public class TestStaticInnerClass {

	public static void main(String[] args) {
		StaticInnerClass.StaticInner inner = new StaticInnerClass.StaticInner();
		inner.printIdx();
		StaticInnerClass.StaticInner.staticPrintIdx();
	}
}
