package org.example.core.java.newfeatures;

import java.util.Optional;

/**
 * @author clx 2018/6/22.
 */
public class OptionalTest {

	public static void main(String[] args) {
		OptionalTest test = new OptionalTest();
		User user = new User();
		user.setName("lmm");
		System.out.println(test.newOfNullable(user));
	}

	/**
	 * new Nullable
	 *
	 * @param user
	 * @return
	 */
	private String newOfNullable(User user) {
		User newUser = null;
		// newUser = Optional.of(user).orElse(createUser());
		// User result = Optional.ofNullable(user).orElse(createUser());
		// newUser = Optional.ofNullable(user).orElseGet(() -> createUser());
		newUser = Optional.ofNullable(user).orElseGet(this::createUser);
		// return result.getName();

		return Optional.ofNullable(user).map(User::getAddress).map(Address::getProvince)
				.orElseThrow(IllegalArgumentException::new);
	}

	/**
	 * get province
	 *
	 * @param user
	 * @return
	 */
	private String getProvince(User user) {
		return Optional.ofNullable(user).map(User::getAddress).map(Address::getProvince)
				.orElseThrow(IllegalArgumentException::new);
	}

	/**
	 * original NPE handle method
	 *
	 * @param user
	 * @return
	 */
	private String oriOfNullable(User user) {
		// if (user != null) {
		// Address address = user.getAddress();
		// if (address != null) {
		// return address.getProvince();
		// }
		// }
		// return null;

		Optional.ofNullable(user).ifPresent(u -> {
			u.getAddress();
		});

		Optional.ofNullable(user).ifPresent(User::getAddress);
		return null;
	}

	/**
	 * get user
	 *
	 * @param user
	 * @return
	 */
	private User getUser(User user) {
		// if (user != null) {
		// if ("clx".equals(user.getName())) {
		// return user;
		// } else {
		// user.setName("clx");
		// return user;
		// }
		// } else {
		// user = new User();
		// user.setName("clx");
		// return user;
		// }

		return Optional.ofNullable(user).filter(u -> "clx".equals(u.getName())).orElseGet(() -> {
			User newUser = new User();
			newUser.setName("lmm");
			return newUser;
		});
	}

	/**
	 * create user
	 *
	 * @return
	 */
	private User createUser() {
		System.out.println("I'm running");
		User user = new User();
		user.setName("clx");
		return user;
	}

}

class User {

	private static Long id;
	private String name;
	private String phone;
	private Address address;

	public User() {
		System.out.println("I'm Running...");
	}

	public static Long getId() {
		return id;
	}

	public static void setId(Long id) {
		User.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "User{" + "name='" + name + '\'' + ", phone='" + phone + '\'' + ", address=" + address + '}';
	}
}

class Address {
	private String country;
	private String province;
	private String city;

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Address{" + "country='" + country + '\'' + ", province='" + province + '\'' + ", city='" + city + '\''
				+ '}';
	}
}
