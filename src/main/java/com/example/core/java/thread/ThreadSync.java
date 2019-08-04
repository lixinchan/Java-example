package com.example.core.java.thread;

/**
 * synchronized 用法
 * 
 * @author chenlixin at 2017年2月23日 下午6:02:13
 */
public class ThreadSync implements Runnable {

    /**
     * 代码块：在多线程环境下，synchronized块中的方法获取了lock实例的monitor，如果实例相同，那么只有一个线程可以执行该块；
     */
    Object lock;

    // @Override
    // public void run() {
    // synchronized (lock) {
    // // do sth } }
    // }
    // }

    /**
     * 直接用于方法：实际上是获取的ThreadSync类的monitor,若方法为静态方法，则锁住该类所有实例；
     */
    @Override
    public synchronized void run() {

    }

    // synchronized, wait, notify结合:典型场景生产者消费者问题。
    /**
     * 生产者生产商品给店员
     */
    public synchronized void producers() {

    }

    /**
     * 消费者从店员处取商品
     */
    public synchronized void consumers() {

    }
}
