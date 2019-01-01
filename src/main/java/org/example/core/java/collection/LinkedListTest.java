package org.example.core.java.collection;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Queue;

/**
 * @author chenlixin at 2016年2月22日 下午2:24:03
 */
public class LinkedListTest {

    public static void main(String[] args) {
        List<String> list_a = new LinkedList<String>();
        list_a.add("A");
        list_a.add("B");
        list_a.add("C");
        
        List<String> list_b = new LinkedList<String>();
        list_b.add("a");
        list_b.add("b");
        list_b.add("c");
        list_b.add("d");
        
        // add b to a
        ListIterator<String> iter_a = list_a.listIterator();
        Iterator<String> iter_b = list_b.iterator();
        while(iter_b.hasNext()) {
            if(iter_a.hasNext()) 
                iter_a.next();
            iter_a.add(iter_b.next());
        }
        System.out.println(list_a);
        
        // remove one element from b per one
        iter_b = list_b.iterator();
        while(iter_b.hasNext()){
            iter_b.next();
            if(iter_b.hasNext()) {
                iter_b.next();
                iter_b.remove();
            }
        }
        System.out.println(list_b);
        
        // remove b from a
        list_a.removeAll(list_b);
        System.out.println(list_a);
        
        Queue<String> queue = new LinkedList<String>();
        for(int i = 0; i < 16; i++) {
            queue.add("a" + i);
        }
        System.out.println(queue);
        queue.add("b");
        queue.offer("c");
        System.out.println(queue);
        queue.remove();
        queue.poll();
        System.out.println(queue);
        System.out.println(queue.peek());
        System.out.println(queue.element());
    }
}
