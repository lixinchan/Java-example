package org.vm.automemorymanagement;

/**
 * -Xss128k
 * 
 * @author clx 2018/12/16
 */
public class StackOverflow {

	private int stackLength = 1;

	public void stackLeak() {
		stackLength++;
		stackLeak();
	}

	public static void main(String[] args) {
		StackOverflow oom = new StackOverflow();
		try {
			oom.stackLeak();
		} catch (Throwable e) {
			System.out.println("stack length:" + oom.stackLength);
			throw e;
		}
	}
}
