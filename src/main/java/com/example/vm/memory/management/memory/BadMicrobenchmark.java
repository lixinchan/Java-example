package com.example.vm.memory.management.memory;

/**
 * @author clx
 */
public class BadMicrobenchmark {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        for (int idx = 0; idx < 10_000_100; idx++) {
            Math.sin(idx);
        }
        long endTime = System.nanoTime();
        System.out.println("duration:" + (endTime - startTime));
    }
}
