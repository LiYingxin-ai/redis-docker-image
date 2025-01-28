package com.test.queue;

import org.slf4j.LoggerFactory;

public class MyReceiver {
    private org.slf4j.Logger logger = LoggerFactory.getLogger(MyReceiver.class);
    public void receiveMessage(String message) {
        logger.info("Received <" + message + ">");
    }
}
