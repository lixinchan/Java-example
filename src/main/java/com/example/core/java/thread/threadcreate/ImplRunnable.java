package com.example.core.java.thread.threadcreate;

/**
 * @author clx 3/5/2018
 */
public class ImplRunnable implements Runnable {

	@Override
	public void run() {
		System.out.println("Running...");
	}

	public static void main(String[] args) {
		new Thread(new ImplRunnable()).start();
		new Thread(() -> {
			System.out.println("...");
		}).start();
	}
}
