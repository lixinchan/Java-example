package org.example.core.java.innerclass;

/**
 * @author clx 2018/4/8.
 */
public class TestMemberInnerClass {

	public static void main(String[] args) {
		MemberInnerClass outer = new MemberInnerClass(1);
		outer.privateInnerGetIdx();
		MemberInnerClass.PublicInner publicInner = outer.new PublicInner();
		publicInner.printIdx();
	}
}
