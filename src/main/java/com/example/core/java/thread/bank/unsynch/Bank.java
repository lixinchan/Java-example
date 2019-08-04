package com.example.core.java.thread.bank.unsynch;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author chenlixin at 2017年3月6日 下午5:41:38
 */
public class Bank {

    private ReentrantLock bankLock = new ReentrantLock();

    private final double[] accounts;

    public Bank(int n, int initBalance) {
        accounts = new double[n];
        for (int index = 0; index < accounts.length; index++) {
            accounts[index] = initBalance;
        }
    }

    public void unsynchTransfer(int from, int to, double amount) {
        System.out.print(Thread.currentThread());
        accounts[from] -= amount;
        System.out.printf(" %10.2f from %d to %d", amount, from, to);
        accounts[to] += amount;
        System.out.println("Total balance:" + getTotalBalance());
    }

    public void synchTransfer(int from, int to, double amount) {
        bankLock.lock();
        try {
            System.out.print(Thread.currentThread());
            accounts[from] -= amount;
            System.out.printf(" %10.2f from %d to %d", amount, from, to);
            accounts[to] += amount;
            System.out.println("Total balance:" + getTotalBalance());
        } finally {
            bankLock.unlock();
        }
    }

    public double getTotalBalance() {
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
