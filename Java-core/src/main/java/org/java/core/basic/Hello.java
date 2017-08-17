package org.java.core.basic;

/**
 * @author chenlixin at 2016年4月20日 下午3:31:58
 */
public class Hello {
    public static void main(String[] args) {
        Drive.c = '4';
        new Drive();
    }
}

class Base {
    
    static {
         c = '0';
    }
    
    public static char c = '1';
    
    public Base() {
        System.out.println(c);
        c = '2';
    }
    
    {
        c = '3';
    }
}

class Drive extends Base {
    static {
        System.out.println(c);
    }
}
