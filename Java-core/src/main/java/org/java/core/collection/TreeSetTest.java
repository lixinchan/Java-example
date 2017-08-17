package org.java.core.collection;

import java.util.Set;
import java.util.TreeSet;

/**
 * @author chenlixin at 2016年2月23日 下午3:09:06
 */
public class TreeSetTest {

    public static void main(String[] args) {
        Set<String> set = new TreeSet<String>();
        set.add("b");
        set.add("d");
        set.add("c");
        set.add("a");
        
        for(String str : set) 
            System.out.println(str);
    }
}
