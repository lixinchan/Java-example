package org.java.core.thread.dc;

/**
 * double check test
 * 
 * @author clx at 2017年7月7日 上午11:37:49
 */
public class Foo {

    /**
     * single thread version
     */

    // private Helper helper = null;
    //
    // public Helper getHelper() {
    // if (helper == null) {
    // helper = new Helper();
    // }
    // return helper;
    // }

    /**
     * correct multithread version
     */
    // private Helper helper = null;
    //
    // public synchronized Helper getHelper() {
    // if (helper == null) {
    // helper = new Helper();
    // }
    // return helper;
    // }

    /**
     * broken multithread version
     */
    // private Helper helper = null;
    //
    // public Helper getHelper() {
    // if (helper == null) {
    // synchronized (this) {
    // if (helper == null) {
    // helper = new Helper();
    // }
    // }
    // }
    // return helper;
    // }

    /**
     * ThreadLocal
     */
    // private final ThreadLocal threadInstance = new ThreadLocal();
    // private Helper helper = null;
    //
    // public Helper getHelper() {
    // if (threadInstance.get() == null) {
    // createHelper();
    // }
    // return helper;
    // }
    //
    // private final void createHelper() {
    // synchronized (this) {
    // if (helper == null) {
    // helper = new Helper();
    // }
    // }
    // threadInstance.set(threadInstance);
    // }

    private volatile Helper helper = null;

    public Helper getHelper() {
        if (helper == null) {
            synchronized (this) {
                if (helper == null) {
                    helper = new Helper();
                }
            }
        }
        return helper;
    }
}
