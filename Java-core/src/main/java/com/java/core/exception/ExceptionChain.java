package com.java.core.exception;

import java.text.ParseException;
import java.util.Map;

/**
 * @author chenlixin at 2015年7月23日 下午6:15:41
 */
public class ExceptionChain {

    // public void test() {
    // try {
    //
    // } catch (Exception ex) {
    // Throwable se = new ServletException("message");
    // se.initCause(ex);
    // throw se;
    // }
    //
    // Throwable e = se.getCause();
    // }

    // public void test() {
    // InputStream in = null;
    // try {
    // try {
    // in = new FileInputStream("");
    // } finally {
    // in.close();
    // }
    // } catch (IOException ex) {
    //
    // }
    // }

    public static int test(int n) {
        try {
            int retVal = (int) Math.pow(n, n);
            return retVal;

        } catch (Exception ex) {
            return 0;
        } finally {
            if (n == 3) {
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
