package org.java.core.thread.dc;

/**
 * singleton Initialization on Demand Holder
 * 
 * @author clx at 2017年7月7日 下午1:39:08
 */
public class Singleton {

    static class SingletonHolder {
        static Singleton instance = new Singleton();
    }

    public static Singleton getInstance() {
        return SingletonHolder.instance;
    }
}
