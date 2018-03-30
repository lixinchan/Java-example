package org.core.java.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ReflectTest {

    public static void main(String[] args) throws ClassNotFoundException {
        Class clazz = Class.forName("java.lang.String");
        ReflectTest.printConstruct(clazz);
        System.out.println("-------------------------");
        ReflectTest.printFields(clazz);
        System.out.println("-------------------------");
        ReflectTest.printMethods(clazz);
    }

    public static void printFields(Class clazz) {
        Field[] fields = clazz.getDeclaredFields();

        for (Field f : fields) {
            // field name
            String name = f.getName();

            // modifier
            String modifiers = Modifier.toString(f.getModifiers());

            // params type
            Class type = f.getType();

            if (modifiers.length() > 0)
                System.out.print(modifiers + " ");
            System.out.print(type.getName() + " " + name);
            System.out.println(";");
        }
    }

    public static void printConstruct(Class clazz) {
        Constructor[] cons = clazz.getDeclaredConstructors();

        for (Constructor c : cons) {
            // constructor name
            String name = c.getName();

            // modifier
            String modifiers = Modifier.toString(c.getModifiers());

            if (modifiers.length() > 0)
                System.out.print(modifiers + " ");
            System.out.print(name + "(");

            // print param type
            Class[] paramTypes = c.getParameterTypes();

            for (int i = 0; i < paramTypes.length; ++i) {
                if (i > 0)
                    System.out.print(", ");
                System.out.print(paramTypes[i].getName());
            }
            System.out.println(");");
        }
    }

    public static void printMethods(Class clazz) {
        Method[] methods = clazz.getDeclaredMethods();

        for (Method method : methods) {
            // method name
            String name = method.getName();

            // modifiers
            String modifiers = Modifier.toString(method.getModifiers());
            if (modifiers.length() > 0)
                System.out.print(modifiers + " ");

            // return type
            Class retType = method.getReturnType();

            System.out.print(retType.getName() + " ");
            System.out.print(name + "(");

            // params type
            Class[] paramTypes = method.getParameterTypes();
            for (int i = 0; i < paramTypes.length; ++i) {
                if (i > 0)
                    System.out.print(", ");
                System.out.print(paramTypes[i].getName());
            }
            System.out.println(");");
        }
    }
}
