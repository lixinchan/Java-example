package org.example.core.java.exception;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.Map;

/**
 * @author chenlixin at 2015年7月23日 下午6:15:41
 */
public class ExceptionChain {

    public void test1() throws Throwable {
        try {

        } catch (Exception ex) {
            Throwable se = new Throwable("message");
            se.initCause(ex);
            throw se;
        }
    }

    public void test2() {
        InputStream in = null;
        try {
            try {
                in = new FileInputStream("");
            } finally {
                in.close();
            }
        } catch (IOException ex) {

        }
    }

    public static int test3(int n) {
        try {
            int retVal = (int) Math.pow(n, n);
            int val = retVal / 1;
            return retVal;
        } catch (Exception ex) {
            return 1;
        } finally {
            if (n == 4) {
                return 0;
            }
        }
    }

    public static void main(String[] args) throws ParseException {
        // String date = "July 28 2015";
        // SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd",
        // Locale.ENGLISH);
        // Date now = sdf.parse(date);
        // System.out.println(now);
        System.out.println(test3(2));
    }

    public static void test() {
        Throwable e = new Throwable();
        StackTraceElement[] element = e.getStackTrace();
        for (StackTraceElement frame : element) {

        }
        Map<Thread, StackTraceElement[]> stackMap = Thread.getAllStackTraces();
        for (Thread t : stackMap.keySet()) {
            StackTraceElement[] frames = stackMap.get(t);
        }
    }
}
