package org.core.java.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author clx 2017/11/26 23:53
 */
public class ObjectStreamTest {

	public static void main(String[] args) throws Exception {
		File file = new File("E:" + File.separator + "test" + File.separator + "serializable.txt");
		serializable(file);
		deserializable(file);
	}

	/**
	 * 序列化方法
	 *
	 * @param file
	 * @throws Exception
	 */
	public static void serializable(File file) throws Exception {
		OutputStream out = new FileOutputStream(file);
		ObjectOutputStream oos = new ObjectOutputStream(out);
		List<String> address = new ArrayList<>();
		address.add("1.");
		address.add("2.");
		address.add("3.");
		oos.writeObject(new Person("clx", 27, address));
		oos.close();
	}

	/**
	 * 反序列化方法
	 *
	 * @param file
	 * @throws Exception
	 */
	public static void deserializable(File file) throws Exception {
		InputStream in = new FileInputStream(file);
		ObjectInputStream ois = new ObjectInputStream(in);
		Person person = (Person) ois.readObject();
		System.out.println(person);
	}

}

class Person implements Serializable {

	private transient String name;
	private int age;
	private final static String GENDER = "man";
	private List<String> address;

	public Person(String name, int age, List<String> address) {
		this.name = name;
		this.age = age;
		this.address = address;
	}

	@Override
	public String toString() {
		return "Person{" + "name='" + name + '\'' + ", age=" + age + ", address=" + address + '}';
	}
}