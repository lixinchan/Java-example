package com.java.core.thread.bank.synch.rw;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author chenlixin at 2017年4月6日 下午5:41:38
 */
public class Bank {

    private ReentrantReadWriteLock rwLock;
    private Lock readLock;
    private Lock writeLock;
	private final double[] accounts;

	public Bank(int n, int initBalance) {
		accounts = new double[n];
		for (int index = 0; index < accounts.length; index++) {
			accounts[index] = initBalance;
		}
		rwLock = new ReentrantReadWriteLock();
		readLock = rwLock.readLock();
		writeLock = rwLock.writeLock();
	}

	public  void synchTransfer(int from, int to, double amount) throws InterruptedException {
	    writeLock.lock();
	    try {
	        System.out.print(Thread.currentThread());
	        accounts[from] -= amount;
	        System.out.printf(" %10.2f from %d to %d", amount, from, to);
	        accounts[to] += amount;
	        System.out.println("Total balance:" + getTotalBalance());
	    } finally {
	        writeLock.unlock();
	    }
	}

	public double getTotalBalance() {
	    readLock.lock();
	    try {
	        double sum = 0;
	        for (double a : accounts) {
	            sum += a;
	        }
	        return sum;
	    } finally {
	        readLock.unlock();
	    }
	}

	public int size() {
		return accounts.length;
	}
}
