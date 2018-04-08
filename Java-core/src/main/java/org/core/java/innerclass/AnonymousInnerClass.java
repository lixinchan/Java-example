package org.core.java.innerclass;

/**
 * @author clx 2018/4/8.
 */
public class AnonymousInnerClass {

	public static void main(String[] args) {
		int idx = 1;
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println(idx);
			}
		});
		thread.start();
	}
}
