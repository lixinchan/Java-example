package org.core.java.proxy;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author chenlixin at 2015年6月24日 上午10:33:01
 */
public class StaticProxy implements ITalk {

    private Logger logger = Logger.getLogger(StaticProxy.class.getName());

    private ITalk somebody;

    public StaticProxy(ITalk somebody) {
        this.somebody = somebody;
    }

    public void talk(String name) {
        log("start...");
        somebody.talk("Jack");
        log("end...");
    }

    public void log(String message) {
        logger.log(Level.INFO, message);
    }
}
