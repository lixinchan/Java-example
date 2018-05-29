package org.core.java.serial;

import java.io.*;

/**
 * @author clx 2017/12/4.
 */
public class SerialEnhance {

	public static void main(String[] args) throws Exception {
//		String filePath = "E:" + File.separator + "test" + File.separator + "serial.txt";
//		File file = new File(filePath);
//		OutputStream os = new FileOutputStream(file);
//		ObjectOutputStream oos = new ObjectOutputStream(os);
//		Female female = new Female("clx");
//		oos.writeObject(female);
//		oos.close();
//		os.close();
//
//		InputStream in = new FileInputStream(file);
//		ObjectInputStream ois = new ObjectInputStream(in);
//		Female test = (Female) ois.readObject();
//		System.out.println(test);
//		ois.close();
//		in.close();

		String filePath = "E:" + File.separator + "test" + File.separator + "serial.txt";
		File file = new File(filePath);
		OutputStream os = new FileOutputStream(file);
		ObjectOutputStream oos = new ObjectOutputStream(os);
		Daughter female = new Daughter(1, "l", 18, "clx");
		oos.writeObject(female);
		oos.close();
		os.close();

		InputStream in = new FileInputStream(file);
		ObjectInputStream ois = new ObjectInputStream(in);
		Daughter test = (Daughter) ois.readObject();
		System.out.println(test);
		ois.close();
		in.close();
	}
}
