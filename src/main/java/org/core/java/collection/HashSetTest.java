package org.core.java.collection;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author chenlixin at 2016年2月23日 上午11:30:56
 */
public class HashSetTest {

    public static void main(String[] args) {
        Set<String> words = new HashSet<String>();

        long totalTime = 0;
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            long startTime = System.currentTimeMillis();
            String word = in.next();
            words.add(word);
            long endTime = System.currentTimeMillis();
            totalTime += endTime - startTime;
        }
        
        System.out.println(words.size() + ":" + totalTime);
        in.close();
    }
}
