package com.java.core.thread.bank.synch.rw;

/**
 * @author chenlixin at 2017年4月6日 下午5:41:38
 */
public class SynchTransferTest {

    public static final int NNACOUNTS = 3;
    public static final int INITBALANCE = 1000;

    public static void main(String[] args) {
        Bank bank = new Bank(NNACOUNTS, INITBALANCE);
        for (int index = 0; index < NNACOUNTS; index++) {
            new Thread(new TransferRunnable(bank, index, INITBALANCE)).start();
        }
    }
}
