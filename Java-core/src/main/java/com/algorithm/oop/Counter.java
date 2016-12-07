package com.algorithm.oop;

/**
 * @author chenlixin at 2016年12月7日 下午4:37:42
 */
public class Counter {
    private String id;
    
    public Counter(String id) {
        this.id = id;
    }
    
    /**
     * counter add one
     */
    public void increment() {
        
    }
    
    /**
     * record add one time
     * @return
     */
    public int tally() {
        return 0;
    }
    
    @Override
    public String toString() {
        return "Counter [id=" + id + "]";
    }
}
