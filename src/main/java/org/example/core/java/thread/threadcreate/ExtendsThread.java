package org.example.core.java.thread.threadcreate;

/**
 * @author clx 3/5/2018
 */
public class ExtendsThread extends Thread {

	@Override
	public void run() {
		System.out.println("Running...");
	}

	public static void main(String[] args) {
		Thread thread = new ExtendsThread();
		thread.start();
	}
}
