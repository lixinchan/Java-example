package org.java.core.exception;

import java.util.Scanner;

/**
 * @author chenlixin at 2015年7月29日 下午4:39:40
 */
public class StackTraceTest {

    public static int factorial(int n) {
        System.out.println("Factorial(" + n + ")");
        Throwable e = new Throwable();
        StackTraceElement[] frames = e.getStackTrace();
        for (StackTraceElement frame : frames) {
            System.out.println(frame);
        }

        int retVal = 0;
        if (n <= 1) {
            retVal = 1;
        } else {
            retVal = n * factorial(n - 1);
        }
        System.out.println("Return:" + retVal);
        return retVal;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter n:");
        StackTraceTest.factorial(in.nextInt());
    }
}
