package org.vm;

/**
 * -Xss2m
 * 
 * @author clx 2018/12/16
 */
public class StackOutOfMemory {

	public static void main(String[] args) {
		new StackOutOfMemory().stackLeakByThread();
	}

	private void donotStop() {
		while (true) {

		}
	}

	public void stackLeakByThread() {
		while (true) {
			Thread thread = new Thread(new Runnable() {
				@Override
				public void run() {
					donotStop();
				}
			});
			thread.start();
		}
	}
}
