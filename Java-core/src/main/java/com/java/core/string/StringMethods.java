package com.java.core.string;

import java.util.Arrays;

/**
 * @author chenlixin at 2017年2月10日 下午4:10:00
 */
public class StringMethods {

    public static void main(String[] args) {
        String str = "a,b,c,,";
        String[] array = str.split(",");
        System.out.println(Arrays.toString(array));
    }
}
