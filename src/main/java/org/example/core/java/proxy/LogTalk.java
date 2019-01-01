package org.example.core.java.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author chenlixin at 2015年6月24日 下午12:17:12
 */
public class LogTalk implements InvocationHandler {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    private Object object;

    public Object bind(Object object) {
        this.object = object;
        return Proxy.newProxyInstance(this.getClass().getClassLoader(), object
                .getClass().getInterfaces(), this);
    }

    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        Object result = null;

        result = method.invoke(object, args);

        return result;

    }

    public void log(String message) {
        logger.log(Level.INFO, message);
    }
}
