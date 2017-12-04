package org.java.core.serial;

/**
 * @author clx 2017/12/4.
 */
public class Female extends Person {

	private String hobbies;

	public Female(String hobbies) {
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
		return "Female{" +
				"hobbies='" + hobbies + '\'' +
				'}';
	}
}
