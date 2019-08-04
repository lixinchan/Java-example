package com.example.core.java.proxy;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author chenlixin at 2015年6月3日 上午10:23:47
 */
public class TalkToSomebody implements ITalk {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    public void talk(String name) {
        logger.log(Level.INFO, "talking start...");
        System.out.println("Hi," + name);
        logger.log(Level.INFO, "talking end...");
    }
}
