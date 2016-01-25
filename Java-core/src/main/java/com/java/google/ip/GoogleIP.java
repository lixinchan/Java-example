package com.java.google.ip;

import java.util.Arrays;

import org.apache.commons.lang3.StringUtils;

/**
 * @author chenlixin at 2015年9月22日 下午5:51:32
 */
public class GoogleIP {

    public static void main(String[] args) {
        String newIP = "64.233.162.85|64.233.162.86|173.194.75.83|64.233.162.81|173.194.75.132|173.194.75.148|64.233.187.101|216.239.38.123|216.239.38.124|216.239.38.125";
        String oldIP = "64.233.162.82|64.233.162.87|74.125.230.23|64.233.162.85|74.125.230.21|74.125.230.8|64.233.162.81|74.125.230.31|74.125.230.28";
        String[] newArray = StringUtils.split(newIP, '|');
        String[] oldArray = StringUtils.split(oldIP, '|');

        System.out.println(Arrays.toString(newArray));
    }
}
