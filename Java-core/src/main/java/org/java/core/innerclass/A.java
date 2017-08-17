package org.java.core.innerclass;

/**
 * @author chenlixin at 2015年5月19日 上午11:46:18
 */
// class A {

// private int interval;
// private boolean beep;
//
// public TimeClock(int interval, boolean beep) {
// this.interval = interval;
// this.beep = beep;
// }
//
// public void start() {
// this.new TimePrinter();
// TimeClock jack = new TimeClock(100, true);
//
// TimeClock.TimePrinter inner = jack.new TimePrinter();
// }
//
// public class TimePrinter implements ActionLisenter {
//
// public TimePrinter() {
//
// }
//
// @Override
// public void actionPerformed() {
// if (TimeClock.this.beep) {
//
// }
// }
// }

// public void start(int interval, final boolean beep) {
//
// ActionLisenter lisenter = new ActionLisenter() {
//
// @Override
// public void actionPerformed() {
// // TODO Auto-generated method stub
//
// }
// };
//
// }
// }

// class Test {
// public void func() {
// TimeClock rose = new TimeClock(100, true);
//
// TimeClock.TimePrinter in = rose.new TimePrinter();
// }
// }

public class A {
    public int x = 1;

    class B {
        int x = 2;

        void func() {
            int x = 3;
            System.out.println("first:" + A.this.x);
            System.out.println("second:" + x);
        }
    }

    public static void main(String[] args) {
        new A().new B().func();
    }
}