package org.core.java.serial;

import java.io.*;

/**
 * @author clx 2017/12/4 0:13
 */
public class SerializableObject implements Serializable {

	private String name;
	private transient int age;
	private static byte gender = 1;

	public SerializableObject(String name, int age) {
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

	public static byte getGender() {
		return gender;
	}

	public static void setGender(byte gender) {
		SerializableObject.gender = gender;
	}

	@Override
	public String toString() {
		return "SerializableObject{" +
				"name='" + name + '\'' +
				", age=" + age +
				'}';
	}

	/**
	 * self-define serialize
	 *
	 * @param oos
	 */
	private void writeObject(ObjectOutputStream oos) throws Exception {
		oos.defaultWriteObject();
		oos.writeInt(age);
	}

	/**
	 * self-define deserialize
	 *
	 * @param ois
	 */
	private void readObject(ObjectInputStream ois) throws Exception {
		ois.defaultReadObject();
		this.age = ois.readInt();
	}

	public static void main(String[] args) throws Exception {
		String filePath = "E:" + File.separator + "test" + File.separator + "serial.txt";
		File file = new File(filePath);
		OutputStream os = new FileOutputStream(file);
		ObjectOutputStream oos = new ObjectOutputStream(os);
		SerializableObject serial = new SerializableObject("clx", 26);
		oos.writeObject(serial);
		oos.close();
		os.close();

		InputStream in = new FileInputStream(file);
		ObjectInputStream ois = new ObjectInputStream(in);
		SerializableObject test = (SerializableObject) ois.readObject();
		System.out.println(test);
		ois.close();
		in.close();
	}
}
