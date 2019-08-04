package com.example.core.java.annotation;

/**
 * @author clx 3/14/2018
 */
public class Apple {

	@FruitProvider(providerId = 1, providerName = "pink apple", providerAddress = "cs")
	private String appleProvider;

	public void setAppleProvider(String appleProvider) {
		this.appleProvider = appleProvider;
	}

	public String getAppleProvider() {
		return appleProvider;
	}
}
