package com.example.core.java.thread.bank.synch;

/**
 * @author chenlixin at 2017年3月6日 下午6:05:03
 */
public class TransferRunnable implements Runnable {

    private Bank bank;
    private int fromAmount;
    private double maxAmount;
    private static int DELAY = 10;

    public TransferRunnable(Bank bank, int fromAmount, double maxAmount) {
        this.bank = bank;
        this.fromAmount = fromAmount;
        this.maxAmount = maxAmount;
    }

    @Override
    public void run() {
        while (true) {
            try {
                int toAccount = (int) (bank.size() * Math.random());
                double amount = maxAmount * Math.random();
                // bank.unsynchTransfer(fromAmount, toAccount, amount);
                bank.synchTransfer(fromAmount, toAccount, amount);
                Thread.sleep((long) (DELAY * Math.random()));
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
