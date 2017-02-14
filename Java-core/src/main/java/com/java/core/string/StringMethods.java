package com.java.core.string;

import java.util.Arrays;

import org.junit.Test;

/**
 * @author chenlixin at 2017年2月10日 下午4:10:00
 */
public class StringMethods {

    public static void main(String[] args) {
//        String str = "a,b,c,,";
//        String[] array = str.split(",");
//        System.out.println(Arrays.toString(array));
        
        String str = "abcdef";
        System.out.println(mystery(str));
    }
    
    @Test
    public void testString() {
        String s1 = "hello";
        String s2 = s1;
        s1 = "world";
        System.out.println(s1);
        System.out.println(s2);
        
        String s3 = "hello world";
        s3 = s3.toUpperCase();
        s3 = s3.substring(6, 11);
        System.out.println(s3);
    }
    
    @Test
    public static String mystery(String s) {
        int len = s.length();
        if (len <= 1) {
            return s;
        }
        String a = s.substring(0, len / 2);
        String b = s.substring(len / 2, len);
        return mystery(a) + mystery(b);
    }
}
