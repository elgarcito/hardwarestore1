package com.solvd.hardwarestore1;

import org.apache.logging.log4j.LogManager;

import java.sql.Connection;
import java.util.logging.Logger;

public class ThreadWithRunnable1 implements Runnable{
    private static final org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger(ThreadWithRunnable1.class);
    private final  ConnectionPool conectionPool;

    public ThreadWithRunnable1(ConnectionPool connectionPool){
        this.conectionPool=connectionPool;
    }

    @Override
    public void run(){
        try {
            MockConnection mockConnection= conectionPool.getConnection();
            LOGGER.info(Thread.currentThread().getName()+ " is connected: "+mockConnection);

            Thread.sleep(5000);

            conectionPool.releaseConnection(mockConnection);
            LOGGER.info(Thread.currentThread().getName()+ " is released: "+mockConnection);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
