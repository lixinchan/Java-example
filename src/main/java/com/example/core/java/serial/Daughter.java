package com.example.core.java.serial;

import java.io.Serializable;

/**
 * @author clx 2017/12/5.
 */
public class Daughter extends Father implements Serializable {

	private String hobbies;

	public Daughter(int id, String name, int age, String hobbies) {
		super(id, name, age);
		this.hobbies = hobbies;
	}

	public String getHobbies() {
		return hobbies;
	}

	public void setHobbies(String hobbies) {
		this.hobbies = hobbies;
	}

	@Override
	public String toString() {
		return "Daughter{" +
				"hobbies='" + hobbies + '\'' +
				'}';
	}
}
