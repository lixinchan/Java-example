package com.java.core.basic;

/**
 * @author clx at 2017年5月22日 下午3:50:05
 */
public class FizzBuzz {

    public static void main(String[] args) {
        for (int idx = 1; idx <= 100; idx++) {
            if (idx % 3 == 0 && idx % 5 == 0) {
                System.out.println("FizzBuzz");
            } else if (idx % 3 == 0) {
                System.out.println("Fizz");
            } else if (idx % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(idx);
            }
        }
    }
}
