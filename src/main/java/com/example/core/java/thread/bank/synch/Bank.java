package com.example.core.java.thread.bank.synch;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author chenlixin at 2017年3月17日 下午5:41:38
 */
public class Bank {

	private ReentrantLock bankLock;
	private final double[] accounts;
	private Condition sufficientFunds;

	public Bank(int n, int initBalance) {
		accounts = new double[n];
		for (int index = 0; index < accounts.length; index++) {
			accounts[index] = initBalance;
		}
		bankLock = new ReentrantLock();
		sufficientFunds = bankLock.newCondition();
	}

	public void unsynchTransfer(int from, int to, double amount) {
		System.out.print(Thread.currentThread());
		accounts[from] -= amount;
		System.out.printf(" %10.2f from %d to %d", amount, from, to);
		accounts[to] += amount;
		System.out.println("Total balance:" + getTotalBalance());
	}

	// public void synchTransfer(int from, int to, double amount) throws
	// InterruptedException {
	// bankLock.lock();
	// try {
	// while (accounts[from] < amount) {
	// sufficientFunds.await();
	// }
	// System.out.print(Thread.currentThread());
	// accounts[from] -= amount;
	// System.out.printf(" %10.2f from %d to %d", amount, from, to);
	// accounts[to] += amount;
	// System.out.println("Total balance:" + getTotalBalance());
	// sufficientFunds.signalAll();
	// } finally {
	// bankLock.unlock();
	// }
	// }
	//
	// public double getTotalBalance() {
	// bankLock.lock();
	// try {
	// double sum = 0;
	// for (double a : accounts) {
	// sum += a;
	// }
	// return sum;
	// } finally {
	// bankLock.unlock();
	// }
	// }

	public synchronized void synchTransfer(int from, int to, double amount) throws InterruptedException {
		while (accounts[from] < amount) {
			wait();
		}
		System.out.print(Thread.currentThread());
		accounts[from] -= amount;
		System.out.printf(" %10.2f from %d to %d", amount, from, to);
		accounts[to] += amount;
		System.out.println("Total balance:" + getTotalBalance());
		notifyAll();
	}

	/**
	 * 同步阻塞
	 * @param from
	 * @param to
	 * @param amount
	 * @throws InterruptedException
	 */
	public void transferSyncBlock(int from, int to, double amount) throws InterruptedException {
		synchronized (this) {
			System.out.print(Thread.currentThread());
			accounts[from] -= amount;
			System.out.printf(" %10.2f from %d to %d", amount, from, to);
			accounts[to] += amount;
			System.out.println("Total balance:" + getTotalBalance());
		}
	}

	public synchronized double getTotalBalance() {
		double sum = 0;
		for (double a : accounts) {
			sum += a;
		}
		return sum;
	}

	public int size() {
		return accounts.length;
	}
}
