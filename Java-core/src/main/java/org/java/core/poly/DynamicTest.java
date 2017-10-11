package org.java.core.poly;

/**
 * @author clx 2017年10月8日 下午10:01:02
 */
public class DynamicTest {

	static abstract class Human {

		public void sayHello() {
			System.out.println("你好");
		}
	}

	static class Man extends DynamicTest.Human {

		@Override
		public void sayHello() {
			System.out.println("您好，我是Y先生");
		}
	}

	static class Woman extends DynamicTest.Human {

		@Override
		public void sayHello() {
			System.out.println("您好，我是X美女");
		}
	}

	public static void main(String[] args) {
		DynamicTest.Human manAsGuy = new DynamicTest.Man();// 注释1
		DynamicTest.Human womanAsGuy = new DynamicTest.Woman();
		manAsGuy.sayHello();
		womanAsGuy.sayHello();
	}

}
