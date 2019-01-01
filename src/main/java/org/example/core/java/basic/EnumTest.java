package org.example.core.java.basic;

public class EnumTest {

    public static void main(String[] args) {
//        System.out.println(Integer.parseInt("100.00"));
//        System.out.println(Long.parseLong("100"));
//        System.out.println(Double.parseDouble("100.00"));
//        BigDecimal bd = new BigDecimal("100.00");
//        System.out.println(bd);
        
        int i = 10;
        new EnumTest().func(i);
        System.out.println("i=" + i);
        System.out.println( 1<<3);
        
        System.out.println((127 & 1)<<8);
    }
    
    public void func(int i){
        i = 100;
    }

    public static <T extends Comparable<T>> Pair<T> minMax(T[] array) {
        Pair<String> a = new Pair<String>();
        
        Pair<String> p = (Pair<String>) a;
        p.toString();
        if(array == null || array.length == 0) {
            return null;
        }
        T min = array[0];
        T max = array[0];
        for(int i = 0; i < array.length; i++) {
            if(min.compareTo(array[i]) > 0)
                min = array[i];
            if(max.compareTo(array[i]) < 0)
                max = array[i];
        }
        return null;
    }
    
    public static <T extends Throwable> void doJob(T t) throws T {
        try {
            
        } catch(Throwable e) {
            t.initCause(e);
            throw t;
        }
    }
    
    /*public static <T extends Throwable> void doWork(Class<T> t) throws T{
        try {
            
        } catch (T cause) { //Cannot use the type parameter T in a catch block
            
        }
    }*/
}
