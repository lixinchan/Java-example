package com.example.core.java.basic;

import java.util.Scanner;

public class LotteryOdds {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        int n = in.nextInt();
        int lotteryOdds = 1;
        for (int i = 1; i <= k; ++i)
            lotteryOdds = lotteryOdds * (n - i + 1) / i;
        System.out.println(lotteryOdds);
    }
}
