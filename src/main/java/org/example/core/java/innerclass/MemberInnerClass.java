package org.example.core.java.innerclass;

/**
 * @author clx 2018/4/8.
 */
public class MemberInnerClass {
	private int idx;

	public MemberInnerClass(int idx) {
		this.idx = idx;
	}

	public void privateInnerGetIdx() {
		new PrivateInner().printIdx();
	}

	private class PrivateInner {
		public void printIdx() {
			System.out.println(idx);
		}
	}

	public class PublicInner {
		private int idx = 2;
		public void printIdx() {
			System.out.println(idx);
		}
	}
}
