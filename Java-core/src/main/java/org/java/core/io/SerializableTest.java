package org.java.core.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author clx 2017/11/28.
 */
public class SerializableTest implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;
	private transient int age;
	private static String address = "bj";
	private List<Test> idLists;

	public SerializableTest(String name, int age, List<Test> idLists) {
		this.name = name;
		this.age = age;
		this.idLists = idLists;
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

	public static String getAddress() {
		return address;
	}

	public static void setAddress(String address) {
		SerializableTest.address = address;
	}

	public List<Test> getIdLists() {
		return idLists;
	}

	public void setIdLists(List<Test> idLists) {
		this.idLists = idLists;
	}

	@Override
	public String toString() {
		return "SerializableTest{" +
				"name='" + name + '\'' +
				", age=" + age +
				", idLists=" + idLists +
				'}';
	}

	public static void main(String[] args) throws Exception {
		String filePath = "E:" + File.separator + "test" + File.separator + "serial.txt";
		File file = new File(filePath);
		OutputStream os = new FileOutputStream(file);
		ObjectOutputStream oos = new ObjectOutputStream(os);
		List<Test> idLists = new ArrayList<>(16);
		idLists.add(new Test());
		SerializableTest serial = new SerializableTest("clx", 26, idLists);
		oos.writeObject(serial);
		oos.close();
		os.close();

		InputStream in = new FileInputStream(file);
		ObjectInputStream ois = new ObjectInputStream(in);
		SerializableTest test = (SerializableTest) ois.readObject();
		System.out.println(test);
		ois.close();
		in.close();
	}
}

class Test implements Serializable {

}
