package com.java.core.thread;


/**
 * @author chenlixin at 2015年7月20日 上午10:59:53
 */
public class TraditionalTread {

    public static void main(String[] args) {
        new Thread(new Runnable() {
            
            public void run() {
                System.out.println("Runnable");
            }

        }) {

            @Override
            public void run() {
                System.out.println("Thread");
            }
        }.start();

    }
}
