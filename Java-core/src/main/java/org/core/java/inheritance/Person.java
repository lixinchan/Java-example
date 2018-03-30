package org.core.java.inheritance;

/**
 * @author chenlixin at 2015年4月20日 下午4:45:50
 */
public abstract class Person {

    private String name;

    public Person() {

    }

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public abstract String getDesc();
}
