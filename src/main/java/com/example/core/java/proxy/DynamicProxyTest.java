package com.example.core.java.proxy;

/**
 * @author chenlixin at 2015年6月24日 下午3:18:37
 */
public class DynamicProxyTest {

    public static void main(String[] args) {
        LogTalk DynamicProxy = new LogTalk();
        ITalk proxy = (ITalk) DynamicProxy.bind(new TalkToSomebody());
        proxy.talk("Rose");
    }
}
