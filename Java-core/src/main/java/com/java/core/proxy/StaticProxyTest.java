package com.java.core.proxy;

/**
 * @author chenlixin at 2015年6月24日 上午10:43:31
 */
public class StaticProxyTest {

    public static void main(String[] args) {
        ITalk proxy = new StaticProxy(new TalkToSomebody());
        proxy.talk("Jack");
    }
}
