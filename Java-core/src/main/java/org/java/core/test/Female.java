package org.java.core.test;

/**
 * @author chenlixin at 2015年6月9日 下午7:40:14
 */
public class Female {

    private int id;
    private String name;
    private short age;
    private byte gender = 1;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public short getAge() {
        return age;
    }

    public void setAge(short age) {
        this.age = age;
    }

    public byte getGender() {
        return gender;
    }

    public void setGender(byte gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Female [id=" + id + ", name=" + name + ", age=" + age
                + ", gender=" + gender + "]";
    }
}
