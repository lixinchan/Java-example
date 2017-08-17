package org.java.core.generics;

import org.java.core.basic.Pair;
import org.java.core.inheritance.Manager;

public class GenericTest {

    /**
     * 不能再catch中使用类型变量
     * 
     * @param clazz
     */
    public static <T extends Throwable> void doWorks(Class<T> clazz) {
        // try {
        //
        // } catch (T t) {
        //
        // }
    }

    /**
     * 可以声明参数化类型的异常
     * 
     * @param t
     * @throws T
     */
    public static <T extends Throwable> void doWorks(T t) throws T {
        try {

        } catch (Throwable realCause) {
            t.initCause(realCause);
            throw t;
        }
    }

    /**
     * 不能声明参数化的数组，如果需收集参数化类型可直接使用集合
     */
    public static void doJobs() {
        // Pair<String>[] arr = new Pair<String>[10];

    }

    /**
     * 不能构造泛型数组
     * 
     * @param t
     */
    public static <T extends Comparable<T>> void minmax(T[] t) {
        // T[] tt = new T[3];
    }

    public static <T extends Comparable<? super T>> void minmax2(T[] t) {

    }

    public static void main(String[] args) {
        Pair<Manager> man = new Pair<Manager>();
        Pair pair = man;

    }
}
