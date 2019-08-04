package com.example.core.java.reflect;

import java.lang.reflect.*;

/**
 * reflect
 * 
 * @author clx
 */
public class ReflectTest {

	public static void main(String[] args) throws ClassNotFoundException {
		Class clazz = Class.forName("java.lang.String");
		System.out.println("-----------Construct-----------");
		ReflectTest.printConstruct(clazz);
		System.out.println("-----------fields--------------");
		ReflectTest.printFields(clazz);
		System.out.println("-----------methods-------------");
		ReflectTest.printMethods(clazz);
	}

	/**
	 * fields
	 * 
	 * @param clazz
	 */
	private static void printFields(Class clazz) {
		Field[] fields = clazz.getDeclaredFields();
		if (fields.length == 0) {
			return;
		}
		for (Field field : fields) {
			String fieldName = field.getName();
			Class fieldType = field.getType();
			String modifier = Modifier.toString(field.getModifiers());
			if (modifier.length() > 0) {
				System.out.print(modifier + " ");
			}
			System.out.println(fieldType.getName() + " " + fieldName);
		}
	}

	/**
	 * construct
	 * 
	 * @param clazz
	 */
	private static void printConstruct(Class clazz) {
		Constructor[] constructors = clazz.getDeclaredConstructors();
		if (constructors.length == 0) {
			return;
		}
		for (Constructor constructor : constructors) {
			String modifier = Modifier.toString(constructor.getModifiers());
			if (modifier.length() > 0) {
				System.out.print(modifier + " ");
			}
			System.out.print(constructor.getName());
			Class[] types = constructor.getParameterTypes();
			if (types.length == 0) {
				System.out.println("();");
				continue;
			}
			System.out.print("(");
			Parameter[] parameters = constructor.getParameters();
			for (int idx = 0; idx < types.length; idx++) {
				if (idx > 0) {
					System.out.print(", ");
				}
				System.out.print(types[idx].getName() + " " + parameters[idx].getName());
			}
			System.out.println(");");
		}
	}

	/**
	 * methods
	 * 
	 * @param clazz
	 */
	private static void printMethods(Class clazz) {
		Method[] methods = clazz.getDeclaredMethods();
		if (methods.length == 0) {
			return;
		}
		for (Method method : methods) {
			String modifier = Modifier.toString(method.getModifiers());
			if (modifier.length() > 0) {
				System.out.print(modifier + " ");
			}
			System.out.print(method.getName());
			Class[] types = method.getParameterTypes();
			if (types.length == 0) {
				System.out.println("();");
				continue;
			}
			System.out.print("(");
			Parameter[] parameters = method.getParameters();
			for (int idx = 0; idx < types.length; idx++) {
				if (idx > 0) {
					System.out.print(", ");
				}
				System.out.print(types[idx].getName() + " " + parameters[idx].getName());
			}
			System.out.println(");");
		}
	}
}
