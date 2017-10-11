package org.java.core.poly;

/**
 * @author clx 2017年10月8日 下午9:55:33
 */
public class StaticTest {
	static abstract class Human {

	}

	static class Man extends StaticTest.Human {

	}

	static class Woman extends StaticTest.Human {

	}

	static class Girl extends StaticTest.Woman {

	}

	public void sayHello(Object guy) {
		System.out.println("你...");
	}

	public void sayHello(Human guy) {
		System.out.println("你好");
	}

	public void sayHello(Man guy) {
		System.out.println("您好，先生");
	}

	public void sayHello(Woman guy) {
		System.out.println("您好，美女");
	}

	public void sayHello(Girl guy) {
		System.out.println("您好，美少女");
	}

	public static void main(String[] args) {
		StaticTest test = new StaticTest();
		StaticTest.Human manAsGuy = new StaticTest.Man();
		StaticTest.Human womanAsGuy = new StaticTest.Woman();
		StaticTest.Woman girlAsWoman = new StaticTest.Girl();
		test.sayHello(manAsGuy);
		test.sayHello(womanAsGuy);
		test.sayHello(girlAsWoman);
	}
}
