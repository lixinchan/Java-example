package org.example.design.patterns.principle;

/**
 * LSP,所有能使用基类的地方，都能够透明的使用其子类对象
 * 
 * @author clx 2018/7/13.
 */
public class LiskovSubstitutionPrinciple {

}

/**
 * before refactor
 */
class EmailSender {
	/**
	 * normal consumer sender
	 * 
	 * @param consumer
	 */
	void send(NormalConsumer consumer) {
	}

	/**
	 * vip consumer sender
	 * 
	 * @param consumer
	 */
	void send(VipConsumer consumer) {
	}

	/**
	 * after refactor common sender
	 */
	void send(Consumer consumer) {
	}
}

/**
 * before refactor
 */
class NormalConsumer {
	private String name;
	private String email;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "NormalConsumer{" + "name='" + name + '\'' + ", email='" + email + '\'' + '}';
	}
}

/**
 * before refactor
 */
class VipConsumer {
	private String name;
	private String email;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "VIPConsumer{" + "name='" + name + '\'' + ", email='" + email + '\'' + '}';
	}
}

class Consumer {
	private String name;
	private String email;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Consumer{" + "name='" + name + '\'' + ", email='" + email + '\'' + '}';
	}
}

class MaleConsumer extends Consumer {

}
