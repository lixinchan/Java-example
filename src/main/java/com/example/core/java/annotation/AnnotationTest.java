package com.example.core.java.annotation;

import java.lang.reflect.Field;

/**
 * @author clx 3/14/2018
 */
public class AnnotationTest {

	public static void main(String[] args) {
		AnnotationTest.getFruitInfo(Apple.class);
	}

	public static void getFruitInfo(Class<?> clazz) {
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			if (field.isAnnotationPresent(FruitProvider.class)) {
				FruitProvider provider = field.getAnnotation(FruitProvider.class);
				System.out.println("Provider id:" + provider.providerId());
				System.out.println("Provider name:" + provider.providerName());
				System.out.println("Provider address:" + provider.providerAddress());
			}
		}
	}
}
