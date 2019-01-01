package org.example.core.java.inheritance;

/**
 * @author chenlixin at 2015年4月20日 下午4:48:37
 */
public class AbstractTest {

    public static void main(String[] args) {
        Person[] p = new Person[2];
        p[0] = new Employee();
        p[1] = new Student();
    }
}
