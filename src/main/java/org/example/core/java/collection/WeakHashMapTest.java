package org.example.core.java.collection;

import java.util.WeakHashMap;

/**
 * @author chenlixin at 2016年9月19日 下午3:53:09
 */
public class WeakHashMapTest {

    public static void main(String[] args) {
        WeakHashMap<String, String> map = new WeakHashMap<String, String>();
        map.put("Jack", "man");
        map.put("Rose", "female");
        System.out.println(map);
    }
}

class Person {
    private String giveName;
    private String fimalyName;
    private String mobile;

    public String getGiveName() {
        return giveName;
    }

    public void setGiveName(String giveName) {
        this.giveName = giveName;
    }

    public String getFimalyName() {
        return fimalyName;
    }

    public void setFimalyName(String fimalyName) {
        this.fimalyName = fimalyName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return "Person [giveName=" + giveName + ", fimalyName=" + fimalyName
                + ", mobile=" + mobile + "]";
    }
}