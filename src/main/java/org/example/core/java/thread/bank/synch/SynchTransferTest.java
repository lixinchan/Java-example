package org.example.core.java.thread.bank.synch;

/**
 * @author chenlixin at 2017年3月6日 下午6:21:17
 */
public class SynchTransferTest {

    public static final int NNACOUNTS = 5;
    public static final int INITBALANCE = 1000;

    public static void main(String[] args) {
        Bank bank = new Bank(NNACOUNTS, INITBALANCE);
        for (int index = 0; index < NNACOUNTS; index++) {
            new Thread(new TransferRunnable(bank, index, INITBALANCE)).start();
        }
    }
}
