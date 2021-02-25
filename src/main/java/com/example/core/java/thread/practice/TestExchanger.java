package com.example.core.java.thread.practice;

import java.util.concurrent.Exchanger;

/**
 * @author clx
 */
public class TestExchanger {

	public static void main(String[] args) {
		Exchanger<String> exchanger = new Exchanger<>();
		new Thread(() -> {
			try {
				System.out.println("thread a:" + exchanger.exchange("from a"));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {

		}
		new Thread(() -> {
			try {
				System.out.println("thread b:" + exchanger.exchange("from b"));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();
	}
}
