package org.java.core.io;

import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.RandomAccessFile;

/**
 * @author clx 2017/11/11 22:29
 */
public class RandomAccessFileTest {

	public static void main(String[] args) throws Exception {
		RandomAccessFileTest test = new RandomAccessFileTest();
		test.initData();

		test.runTest();
	}

	private void runTest() throws Exception {
		File file = new File("E:" + File.separator + "test" + File.separator + "employee.txt");
		RandomAccessFile raf = new RandomAccessFile(file, "r");
		int len = 8;
		raf.skipBytes(12);
		System.out.println("第二个员工的信息：");
		String str = "";
		for (int i = 0; i < len; i++) {
			str = str + (char) raf.readByte();
		}
		System.out.println("name：" + str);
		System.out.println("age：" + raf.readInt());
		System.out.println("第一个员工的信息：");
		raf.seek(0);
		str = "";
		for (int i = 0; i < len; i++) {
			str = str + (char) raf.readByte();
		}
		System.out.println("name：" + str);
		System.out.println("age：" + raf.readInt());
		System.out.println("第三个员工的信息：");
		raf.skipBytes(12);
		str = "";
		for (int i = 0; i < len; i++) {
			str = str + (char) raf.readByte();
		}
		System.out.println("name：" + str);
		System.out.println("age：" + raf.readInt());
		raf.close();
	}

	private void initData() throws Exception {
		Employee e1 = new Employee("zhangsan", 23);
		Employee e2 = new Employee("lisi", 24);
		Employee e3 = new Employee("wangwu", 25);

		RandomAccessFile raf = new RandomAccessFile(new File("E:\\test\\employee.txt"), "rw");
		raf.writeBytes(e1.getName());
		raf.writeInt(e1.getAge());
		raf.writeBytes(e2.getName());
		raf.writeInt(e2.getAge());
		raf.writeBytes(e3.getName());
		raf.writeInt(e3.getAge());
		raf.close();
	}
}

class Employee {
	private String name;
	private int age;
	private static final int LEN = 8;

	public Employee() {

	}

	public Employee(String name, int age) {
		if (StringUtils.isNotBlank(name) && name.length() > LEN) {
			name = StringUtils.substring(name, 0, LEN);
		} else {
			while (name != null && name.length() < LEN) {
				name += "\u0000";
			}
		}
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Employee{" +
				"name='" + name + '\'' +
				", age=" + age +
				'}';
	}
}