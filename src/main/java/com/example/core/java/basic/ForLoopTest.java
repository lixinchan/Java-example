package com.example.core.java.basic;

public class ForLoopTest {

    public static void main(String[] args) {
        String s = "Hello";
        System.out.println(s.substring(0, 3));
    }

    // public static int forLoop(int n) {
    // int sum = 0;
    // for (int i = 1; i < n; i++) {
    // for (int j = 1; j < i; j++) {
    // for (int k = 1; k < j; k++) {
    // sum += k;
    // }
    // }
    // }
    // return sum;
    // }

    public static int forLoop(int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    sum += k;
                }
            }
        }
        return sum;
    }
}
