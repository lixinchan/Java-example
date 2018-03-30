package org.core.java.innerclass;

import java.util.ArrayList;

/**
 * @author chenlixin at 2015年5月26日 下午6:56:15
 */
public class ArrayAlg {

    public static void main(String[] args) {
        // ArrayAlg.Pair p = ArrayAlg.minmax(null);
        // p.getFirst();
        // p.getSecond();
    }

    public static Pair minmax(double[] values) {
        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;

        for (double v : values) {
            if (v < min)
                min = v;
            if (v > max)
                max = v;
        }
        return new Pair(min, max);
    }

    public static class Pair {
        private double first;
        private double second;

        public Pair(double first, double second) {
            this.first = first;
            this.second = second;
        }

        public double getFirst() {
            return first;
        }

        public double getSecond() {
            return second;
        }
    }

    public void doubleBraceInit() {
        /*
         * ArrayList<String> friends = new ArrayList<String>();
         * friends.add("jack"); friends.add("rose");
         * 
         * invite(friends);
         */

        invite(new ArrayList<String>() {
            {
                add("Jack");
                add("Rose");
            }
        });
    }

    public void invite(ArrayList<String> friends) {
        // TODO Auto-generated method stub

    }
}
