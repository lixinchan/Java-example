package org.algorithm.oop;

/**
 * @author chenlixin at 2016年12月7日 下午4:37:42
 */
public class Counter {
    private final String id;
    private int count;
    
    public Counter(String id) {
        this.id = id;
    }
    
    /**
     * counter add one
     */
    public void increment() {
        count++;
    }
    
    /**
     * record add one time
     * @return
     */
    public int tally() {
        return count;
    }
    
    @Override
    public String toString() {
        return "Counter [id=" + id + "]";
    }
}
