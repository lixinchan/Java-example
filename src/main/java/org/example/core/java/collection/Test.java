package org.example.core.java.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Test {

	public static void main(String[] args) {
		//
		// // TreeSet
		// Set<Integer> tree = new TreeSet<Integer>();
		// long startTime_tree = System.currentTimeMillis();
		// for(int i = 0; i < 10000000; i++){
		// tree.add(i);
		// }
		// System.out.println("Tree:" + (System.currentTimeMillis() -
		// startTime_tree));
		//
		// // HashSet
		// Set<Integer> hash = new HashSet<Integer>();
		// long startTime_hash = System.currentTimeMillis();
		// for(int i = 0; i < 10000000; i++){
		// hash.add(i);
		// }
		// System.out.println("Hash:" + (System.currentTimeMillis() -
		// startTime_hash));
		//
		// // LinkedList
		// List<Integer> link = new LinkedList<Integer>();
		// long startTime_link = System.currentTimeMillis();
		// for(int i = 0; i < 10000000; i++){
		// link.add(i);
		// }
		// System.out.println("Link:" + (System.currentTimeMillis() -
		// startTime_link));
		//
		// // ArrayList
		// List<Integer> array = new ArrayList<Integer>();
		// long startTime_array = System.currentTimeMillis();
		// for(int i = 0; i < 10000000; i++){
		// array.add(i);
		// }
		// System.out.println("Array:" + (System.currentTimeMillis() -
		// startTime_array));

		Integer idx = 1200;
		int index = 1200;
		Integer i = 1200;
		System.out.println(idx == index);
		System.out.println(idx == i);
	}
}
