package com.example.core.java.basic;

public class OperateTest {
    public static void main(String[] args) {
        OperateTest.operate(8);
    }

    public static void operate(int i) {
        int retVal = (i & 8) / 8;
        System.out.println(retVal);
    }
}
